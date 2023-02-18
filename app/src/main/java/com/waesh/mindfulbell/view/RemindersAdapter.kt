package com.waesh.mindfulbell.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.waesh.mindfulbell.databinding.ItemReminderViewBinding
import com.waesh.mindfulbell.model.entity.Reminder

class RemindersAdapter(private val itemClickActions: ItemClickActions): ListAdapter<Reminder, RemindersAdapter.ItemViewHolder>(Comparator()) {

    class ItemViewHolder(binding: ItemReminderViewBinding) : ViewHolder(binding.root){
        private val textView = binding.tvReminderText
        private val chipEnabled = binding.chipEnabled
        private val chipFavorite = binding.chipFavorite
        val clBottom = binding.clBottom
        val root = binding.root

        fun bind(reminder: Reminder){
            textView.text = reminder.body
            chipEnabled.isActivated = reminder.enabled
            chipFavorite.isActivated = reminder.favorite
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemReminderViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(currentList[position])
        holder.root.setOnClickListener {

            when(holder.clBottom.visibility){
                View.GONE -> holder.clBottom.visibility = View.VISIBLE
                View.VISIBLE -> holder.clBottom.visibility = View.GONE
            }
            itemClickActions.onClick(holder.adapterPosition, holder.clBottom.id)
        }
    }

}

class Comparator: DiffUtil.ItemCallback<Reminder>() {
    override fun areItemsTheSame(oldItem: Reminder, newItem: Reminder): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Reminder, newItem: Reminder): Boolean {
        return oldItem == newItem
    }
}

interface ItemClickActions {
    fun onClick(holderPosition: Int, viewId: Int)
    fun onLongClick(reminder: Reminder, holderPosition: Int)
}
