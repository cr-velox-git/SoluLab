package com.solulab.coin.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solulab.coin.domain.model.DomainCoinResponse
import com.solulab.coin.domain.usecase.GetDataUseCase
import com.solulab.coin.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class HomeViewModel @Inject constructor(
private val getDataUseCase: GetDataUseCase
) : ViewModel() {

    private val _coinList = MutableLiveData<List<DomainCoinResponse>>()
    val coinList: LiveData<List<DomainCoinResponse>> = _coinList

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    init {
        Log.d("data_data","init")
        loadData()
    }

    private fun loadData(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = getDataUseCase.invoke()
            response.collectLatest { it ->
                when (it) {
                    is Resource.Success -> {
                        _loading.postValue(false)
                        it.data?.let {
                            _coinList.postValue(it)
                            Log.d("data_data",coinList.value.toString())
                        }
                    }

                    is Resource.Error -> {
                        _loading.postValue(false)
                        _msg.postValue(it.message.toString())
                    }

                    is Resource.Loading -> {
                        _loading.postValue(true)
                    }
                }

            }
        }
    }

}