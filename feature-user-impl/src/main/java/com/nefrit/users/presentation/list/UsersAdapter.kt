package com.nefrit.users.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nefrit.feature_user_api.domain.model.User
import com.nefrit.users.databinding.ItemUserBinding

class UsersAdapter(
    private val userClickListener: (User) -> Unit,
) : ListAdapter<User, UserViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position), userClickListener)
    }
}

class UserViewHolder(private val itemBinding: ItemUserBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(user: User, userClickListener: (User) -> Unit) {
        with(itemBinding) {
            firstNameTv.text = user.firstName
            lastNameTv.text = user.lastName

            itemView.setOnClickListener {
                userClickListener(user)
            }
        }
    }
}

object DiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}