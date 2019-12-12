package com.example.helloworld.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.helloworld.network.MarsApi
import com.example.helloworld.network.MarsProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


enum class MarsApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel : ViewModel() {
    private val _status = MutableLiveData<MarsApiStatus>()

    val status: LiveData<MarsApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<MarsProperty>>()

    val properties: LiveData<List<MarsProperty>>
        get() = _properties

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main
    )

    init {
        getMarsRealEstateProperties()
    }

    private fun getMarsRealEstateProperties() {
        coroutineScope.launch {
            var getPropertiesDeferred = MarsApi.retrofitService.getProperties()
            try {
                var listResult = getPropertiesDeferred.await()
                _status.value =
                    MarsApiStatus.DONE
                _properties.value = listResult
            } catch (e: Exception) {
                _status.value = MarsApiStatus.ERROR
                _properties.value = ArrayList()

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}