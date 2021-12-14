package com.axiaworks.jetpack_compose_sample

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axiaworks.jetpack_compose_sample.qiita.QiitaInfo
import com.axiaworks.jetpack_compose_sample.qiita.QiitaService
import kotlinx.coroutines.launch

class QiitaViewModel: ViewModel() {

    var qiitaInfoList: List<QiitaInfo> by mutableStateOf(listOf())

    fun fetchItemList(tag: String) {
        viewModelScope.launch {
            val qiitaService = QiitaService.getInstance()
            runCatching {
                qiitaService.fetchItemsByTag(tag, 1)
            }.fold(
                onSuccess = {
                    qiitaInfoList = it
                },
                onFailure = {
                    Log.e("QiitaViewModel", it.message, it)
                }
            )
        }
    }
}