package com.bonface.pokedex.viewmodel

import androidx.lifecycle.ViewModel
import com.bonface.pokedex.helpers.NetworkConnectionDelegate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NetworkConnectionViewModel @Inject constructor(
    private val networkConnectionDelegate: NetworkConnectionDelegate,
) : ViewModel() {
    val isConnected: StateFlow<Boolean> = networkConnectionDelegate.isConnected
}
