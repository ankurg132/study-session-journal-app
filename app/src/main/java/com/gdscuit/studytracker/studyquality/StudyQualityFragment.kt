package com.gdscuit.studytracker.studyquality

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
import com.gdscuit.studytracker.databinding.FragmentStudyQualityBinding

/**
 * Fragment that displays a list of clickable icons,
 * each representing a sleep quality rating.
 * Once the user taps an icon, the quality is set in the current sleepNight
 * and the database is updated.
 */
class StudyQualityFragment : Fragment() {

    /**
     * Called when the Fragment is ready to display content to the screen.
     *
     * This function uses DataBindingUtil to inflate R.layout.fragment_sleep_quality.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentStudyQualityBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_study_quality, container, false)

        val application = requireNotNull(this.activity).application

        val arguments =
            StudyQualityFragmentArgs.fromBundle(
                arguments!!
            )

        // Create an instance of the ViewModel Factory.
        val dataSource = StudyDatabase.getInstance(application).studyDatabaseDao
        val viewModelFactory = StudyQualityViewModelFactory(arguments.sleepNightKey, dataSource)

        // Get a reference to the ViewModel associated with this fragment.
        val sleepQualityViewModel =
                ViewModelProvider(
                        this, viewModelFactory).get(StudyQualityViewModel::class.java)

        // To use the View Model with data binding, you have to explicitly
        // give the binding object a reference to it.
        binding.sleepQualityViewModel = sleepQualityViewModel

        // Add an Observer to the state variable for Navigating when a Quality icon is tapped.
        sleepQualityViewModel.navigateToSleepTracker.observe(viewLifecycleOwner, Observer {
            if (it == true) { // Observed state is true.
                this.findNavController().navigate(
                    StudyQualityFragmentDirections.actionSleepQualityFragmentToSleepTrackerFragment()
                )
                // Reset state to make sure we only navigate once, even if the device
                // has a configuration change.
                sleepQualityViewModel.doneNavigating()
            }
        })

        return binding.root
    }
}
