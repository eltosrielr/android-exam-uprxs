package com.eltosriel.exam.hellouser.mvp.view.fragment

//import com.eltosriel.exam.hellouser.adapter.UserListAdapter
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.eltosriel.exam.hellouser.R
import com.eltosriel.exam.hellouser.adapter.ListAdapter
import com.eltosriel.exam.hellouser.base.BaseFragment
import com.eltosriel.exam.hellouser.databinding.FragmentUserListBinding
import com.eltosriel.exam.hellouser.di.component.DaggerUserListInjector
import com.eltosriel.exam.hellouser.di.component.UserListInjector
import com.eltosriel.exam.hellouser.di.module.UserListContextModule
import com.eltosriel.exam.hellouser.di.module.UserListMvpModule
import com.eltosriel.exam.hellouser.di.module.UtilityModule
import com.eltosriel.exam.hellouser.extension.getAppInjector
import com.eltosriel.exam.hellouser.mvp.model.User
import com.eltosriel.exam.hellouser.mvp.model.Users
import com.eltosriel.exam.hellouser.mvp.presenter.interactor.UserListInteractor
import com.eltosriel.exam.hellouser.mvp.view.UserListView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_user_list.*
import javax.inject.Inject

class UserListFragment : BaseFragment<FragmentUserListBinding>(), UserListView {

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var presenter: UserListInteractor

    private lateinit var mUserListAdapter: ListAdapter
    private lateinit var mBinding: FragmentUserListBinding
    private lateinit var mUserListInjector: UserListInjector

    override fun showUsers(users: Users) {
        mUserListAdapter.addUsers(users.users.toMutableList())


        Log.d("Users", gson.toJson(users.users))
        Log.d("Users adapter count", mUserListAdapter.itemCount.toString())
    }

    override fun showLoading() {
        Log.d("Loading", "Loading...")
    }

    override fun hideLoading() {
        Log.d("Loading", "Finish")
    }

    override fun applyDagger() {
        mUserListInjector = DaggerUserListInjector
            .builder()
            .utilityModule(UtilityModule())
            .userListMvpModule(UserListMvpModule(this))
            .userListContextModule(UserListContextModule(this))
            .appInjector(getAppInjector())
            .build()

        mUserListInjector.inject(this)

        mUserListAdapter = ListAdapter(activity!!.applicationContext)
    }

    override fun passDataBinding(binding: FragmentUserListBinding) {
        mBinding = binding
        mBinding.isNotEmpty = true
    }

    override fun configureLayout(): Int = R.layout.fragment_user_list

    override fun configureUI(view: View) {
        super.configureUI(view)

        presenter.fetchAllUsers()

        rvUserList.layoutManager = LinearLayoutManager(context)
        rvUserList.adapter = mUserListAdapter

        mUserListAdapter.setOnItemClickListener(object : ListAdapter.OnItemClickListener {
            override fun onClicked(user: User) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

                val args = bundleOf("user" to gson.toJson(user))

                navigate(R.id.userDetailsFragment, args)
            }
        })
    }

    override fun configureBehavior() {
        super.configureBehavior()
    }
}