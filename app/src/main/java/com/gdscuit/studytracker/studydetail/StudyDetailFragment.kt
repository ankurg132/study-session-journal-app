package com.gdscuit.studytracker.studydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gdscuit.studytracker.R
import com.gdscuit.studytracker.database.StudyDatabase
import com.gdscuit.studytracker.databinding.FragmentStudyDetailBinding


class StudyDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentStudyDetailBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_study_detail, container, false)

        val application = requireNotNull(this.activity).application
        val arguments =
            StudyDetailFragmentArgs.fromBundle(
                arguments!!
            )

        // Create an instance of the ViewModel Factory.
        val dataSource = StudyDatabase.getInstance(application).studyDatabaseDao
        val viewModelFactory = StudyDetailViewModelFactory(arguments.sleepNightKey, dataSource)

        // Get a reference to the ViewModel associated with this fragment.
        val sleepDetailViewModel =
                ViewModelProvider(
                        this, viewModelFactory).get(StudyDetailViewModel::class.java)

        // To use the View Model with data binding, you have to explicitly
        // give the binding object a reference to it.
        binding.sleepDetailViewModel = sleepDetailViewModel

        binding.lifecycleOwner = this

        // Add an Observer to the state variable for Navigating when a Quality icon is tapped.
        sleepDetailViewModel.navigateToSleepTracker.observe(viewLifecycleOwner, Observer {
            if (it == true) { // Observed state is true.
                this.findNavController().navigate(
                    StudyDetailFragmentDirections.actionSleepDetailFragmentToSleepTrackerFragment()
                )
                // Reset state to make sure we only navigate once, even if the device
                // has a configuration change.
                sleepDetailViewModel.doneNavigating()
            }
        })

        return binding.root
    }
}
