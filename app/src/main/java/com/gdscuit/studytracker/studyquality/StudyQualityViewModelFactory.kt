package com.gdscuit.studytracker.studyquality

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gdscuit.studytracker.database.StudyDatabaseDao

/**
 * This is pretty much boiler plate code for a ViewModel Factory.
 *
 * Provides the key for the night and the SleepDatabaseDao to the ViewModel.
 */
class StudyQualityViewModelFactory(
        private val sleepNightKey: Long,
        private val dataSource: StudyDatabaseDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudyQualityViewModel::class.java)) {
            return StudyQualityViewModel(sleepNightKey, dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
