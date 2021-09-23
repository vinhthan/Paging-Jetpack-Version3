package com.example.pagingjetpackversion3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pagingjetpackversion3.model.Results
import com.example.pagingjetpackversion3.network.RetrofitInstance
import com.example.pagingjetpackversion3.network.RetrofitService
import kotlinx.coroutines.flow.Flow

class MainActivityViewModel: ViewModel() {

    var retrofitService: RetrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)

    fun getListData(): Flow<PagingData<Results>> {
        return Pager(config = PagingConfig(pageSize = 34, prefetchDistance = 20),
        pagingSourceFactory = {UserPagingSource(retrofitService)}).flow.cachedIn(viewModelScope)
    }

}