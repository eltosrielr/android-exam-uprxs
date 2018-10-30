package com.eltosriel.exam.hellouser.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eltosriel.exam.hellouser.R
import com.eltosriel.exam.hellouser.mvp.model.User
import kotlinx.android.synthetic.main.item_user.view.*

class ListAdapter(var context: Context): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private val mUsers: MutableList<User> = ArrayList()
    private lateinit var mOnItemClickListener: OnItemClickListener

    fun addUsers(users: MutableList<User>) {
        mUsers.clear()
        mUsers.addAll(users)
        notifyDataSetChanged()

        Log.d("Count again 1", mUsers.size.toString())
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        mOnItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false))
    }

    override fun getItemCount(): Int {
       return mUsers.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        Log.d("Count again", mUsers.size.toString())
        holder.bind(mUsers[position])
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(model: User) = with(itemView) {
            tvUsername.text =  "${model.firstName} ${model.lastName}"
            tvEmail.text =  model.emailAddress

            setOnClickListener {
                mOnItemClickListener.onClicked(model)
            }

            Log.d("Model", model.firstName)
        }
    }

    interface OnItemClickListener {
        fun onClicked(user: User)
    }
}