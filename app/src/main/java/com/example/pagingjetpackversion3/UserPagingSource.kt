package com.example.pagingjetpackversion3

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingjetpackversion3.model.Results
import com.example.pagingjetpackversion3.network.RetrofitService

class UserPagingSource(private val apiService: RetrofitService): PagingSource<Int, Results>() {

    companion object {
        private const val FIRST_PAGE = 1
    }

    override fun getRefreshKey(state: PagingState<Int, Results>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Results> {
        return try {
            val nextPage = params.key ?: FIRST_PAGE
            val response = apiService.getDataFromAPI(nextPage)
            var nextPageNumber: Int? = null
            if (response.info.next != null) {
                val uri = Uri.parse(response.info.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }

            LoadResult.Page(data = response.results, prevKey = null, nextKey = nextPageNumber)

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}