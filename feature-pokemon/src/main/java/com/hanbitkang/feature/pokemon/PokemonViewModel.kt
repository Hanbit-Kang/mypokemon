package com.hanbitkang.feature.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanbitkang.core.network.MpNetworkDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val mpNetworkDataSource: MpNetworkDataSource
) : ViewModel() {
    fun testRetrofit() {
        viewModelScope.launch {
            mpNetworkDataSource.getPokemonList()
        }
    }
}