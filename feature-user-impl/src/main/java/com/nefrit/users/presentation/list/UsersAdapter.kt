package com.nefrit.users.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nefrit.feature_user_api.domain.model.User
import com.nefrit.users.databinding.ItemUserBinding

class UsersAdapter(
    private val interactionHandler: InteractionHandler
) : ListAdapter<User, UserViewHolder>(DiffCallback) {

    interface InteractionHandler {

        fun clicked(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position), interactionHandler)
    }
}

class UserViewHolder(private val itemBinding: ItemUserBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(user: User, interactionHandler: UsersAdapter.InteractionHandler) {
        with(itemBinding) {
            firstNameTv.text = user.firstName
            lastNameTv.text = user.lastName

            itemView.setOnClickListener {
                interactionHandler.clicked(user)
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