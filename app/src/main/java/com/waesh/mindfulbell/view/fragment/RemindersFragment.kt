package com.waesh.mindfulbell.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.waesh.mindfulbell.R
import com.waesh.mindfulbell.application.MindfulApplication
import com.waesh.mindfulbell.viewmodel.ApplicationViewModel
import com.waesh.mindfulbell.viewmodel.ApplicationViewModelFactory

class RemindersFragment : Fragment() {

    private val viewModel by viewModels<ApplicationViewModel> {
        ApplicationViewModelFactory((requireActivity().application as MindfulApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_reminders, container, false)
    }

}