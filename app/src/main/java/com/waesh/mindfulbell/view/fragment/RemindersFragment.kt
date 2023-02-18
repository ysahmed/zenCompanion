package com.waesh.mindfulbell.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.waesh.mindfulbell.application.MindfulApplication
import com.waesh.mindfulbell.databinding.FragmentRemindersBinding
import com.waesh.mindfulbell.model.entity.Reminder
import com.waesh.mindfulbell.view.ItemClickActions
import com.waesh.mindfulbell.view.RemindersAdapter
import com.waesh.mindfulbell.viewmodel.RemindersViewModel
import com.waesh.mindfulbell.viewmodel.RemindersViewModelFactory

class RemindersFragment : Fragment() {

    private lateinit var binding: FragmentRemindersBinding
    private lateinit var recyclerView: RecyclerView
    private val adapter = RemindersAdapter(object : ItemClickActions {
        private var newHolderPosition = -1 // -1 -> no item inflated
        private var oldHolderPosition = -1
        override fun onClick(holderPosition: Int, viewId: Int) {
            oldHolderPosition = newHolderPosition
            newHolderPosition = holderPosition
            if (oldHolderPosition == newHolderPosition) {
                newHolderPosition = -1
                oldHolderPosition = -1
            } else if (oldHolderPosition != -1) {
                recyclerView.findViewHolderForAdapterPosition(oldHolderPosition)
                    ?.let { holder ->
                        holder.itemView.findViewById<ConstraintLayout>(viewId)
                            .visibility = View.GONE
                    }
            }
        }

        override fun onLongClick(reminder: Reminder, holderPosition: Int) {
            TODO("Not yet implemented")
        }

    })

    private val viewModel by viewModels<RemindersViewModel> {
        RemindersViewModelFactory((requireActivity().application as MindfulApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRemindersBinding.inflate(layoutInflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.adapter = adapter
        viewModel.reminders.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}