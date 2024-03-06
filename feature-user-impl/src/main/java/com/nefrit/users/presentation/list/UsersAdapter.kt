package com.nefrit.users.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nefrit.users.R
import com.nefrit.users.databinding.ItemHeaderBinding
import com.nefrit.users.databinding.ItemUserBinding

class UsersAdapter(
    private val clickHandler: ClickHandler,
) : ListAdapter<UsersAdapter.ListItem, UserViewHolder>(UserDiffCallback) {

    sealed class ListItem {

        data class UserListItem(
            val id: Int,
            val firstName: String,
            val lastName: String,
        ) : ListItem()

        data class HeaderListItem(
            val title: String,
        ) : ListItem()
    }

    interface ClickHandler {
        fun userClicked(userListItem: ListItem.UserListItem)
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item is ListItem.UserListItem) {
            R.layout.item_user
        } else {
            R.layout.item_header
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return when (viewType) {
            R.layout.item_user -> {
                val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                UserViewHolder.UserVH(binding)
            }
            else -> {
                val binding = ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                UserViewHolder.HeaderVH(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        if (holder is UserViewHolder.UserVH) {
            val userItem = getItem(position) as ListItem.UserListItem
            holder.bind(userItem, clickHandler)
        } else {
            val headerItem = getItem(position) as ListItem.HeaderListItem
            (holder as UserViewHolder.HeaderVH).bind(headerItem)
        }
    }
}

sealed class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class UserVH(private val itemBinding: ItemUserBinding) : UserViewHolder(itemBinding.root) {

        fun bind(user: UsersAdapter.ListItem.UserListItem, interactionHandler: UsersAdapter.ClickHandler) {
            with(itemBinding) {
                firstNameTv.text = user.firstName
                lastNameTv.text = user.lastName
            }
            itemView.setOnClickListener {
                interactionHandler.userClicked(user)
            }
        }
    }

    class HeaderVH(private val itemBinding: ItemHeaderBinding) : UserViewHolder(itemBinding.root) {

        fun bind(header: UsersAdapter.ListItem.HeaderListItem) {
        }
    }
}

object UserDiffCallback : DiffUtil.ItemCallback<UsersAdapter.ListItem>() {

    override fun areItemsTheSame(oldItem: UsersAdapter.ListItem, newItem: UsersAdapter.ListItem): Boolean {
        return if (oldItem is UsersAdapter.ListItem.UserListItem && newItem is UsersAdapter.ListItem.UserListItem) {
            oldItem.id == newItem.id
        } else false
    }

    override fun areContentsTheSame(oldItem: UsersAdapter.ListItem, newItem: UsersAdapter.ListItem): Boolean {
        return if (oldItem is UsersAdapter.ListItem.UserListItem && newItem is UsersAdapter.ListItem.UserListItem) {
            oldItem == newItem
        } else false
    }
}