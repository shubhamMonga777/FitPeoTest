package com.test.fitpeotest.ui.list.vm

import androidx.lifecycle.*
import com.test.fitpeotest.domain.Album
import com.test.fitpeotest.useCase.AlbumUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.test.fitpeotest.util.Result

@HiltViewModel
@ExperimentalCoroutinesApi
class DataViewModel
@Inject
constructor(
    private val savedStateHandle: SavedStateHandle,
    private val useCase: AlbumUseCase

) : ViewModel() {

    private val _errorLD = MutableLiveData<String>()
    val errorLD: LiveData<String> = _errorLD

    private val _isProgressVisible = MutableLiveData<Boolean>()
    val isProgressVisible: LiveData<Boolean> = _isProgressVisible

    private val _albumData = MutableLiveData<List<Album>>()
    val albumData: LiveData<List<Album>> = _albumData


    fun fetchApiData() {
        showProgress()
        viewModelScope.launch {
            when (val result = useCase.getApiData()) {
                is Result.Success -> {
                    _albumData.value = result.value
                }
                is Result.Failure -> {
                    _errorLD.value = result.error?.message
                }
            }
            hideProgress()
        }
    }

    fun onRetryButtonClick() {
        fetchApiData()
    }


    private fun showProgress() {
        _isProgressVisible.value = true
    }

    private fun hideProgress() {
        _isProgressVisible.value = false
    }
}