package com.example.helloworld.sleepdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.helloworld.database.SleepDatabaseDao
import com.example.helloworld.database.SleepNight
import kotlinx.coroutines.Job



class SleepDetailViewModel(
        sleepNightKey: Long = 0L,
        dataSource: SleepDatabaseDao
) : ViewModel() {


    val database = dataSource


    private val viewModelJob = Job()

    private val night: LiveData<SleepNight>

    fun getNight() = night


    init {
        night=database.getNightWithId(sleepNightKey)
    }

    private val _navigateToSleepTracker = MutableLiveData<Boolean?>()

    val navigateToSleepTracker: LiveData<Boolean?>
        get() = _navigateToSleepTracker

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun doneNavigating() {
        _navigateToSleepTracker.value = null
    }

    fun onClose() {
        _navigateToSleepTracker.value = true
    }

}