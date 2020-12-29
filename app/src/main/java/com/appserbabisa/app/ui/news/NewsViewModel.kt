package com.appserbabisa.app.ui.news

import android.app.DownloadManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appserbabisa.app.data.model.ActionState
import com.appserbabisa.app.data.model.News
import com.appserbabisa.app.data.repository.NewsRepo
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val repo:NewsRepo by lazy { NewsRepo() }

    val loading = MutableLiveData(false)
    val actionState=MutableLiveData<ActionState<*>>()
    val listResp = MutableLiveData<List<News>>()
    val detailResp= MutableLiveData<News>()
    val serchResp= MutableLiveData<List<News>>()
    val url= MutableLiveData("")
    val query = MutableLiveData("")

    fun listNews(){
        viewModelScope.launch {
            loading.value=true
            val  resp = repo.listNews()
            actionState.value=resp
            listResp.value=resp.data
            loading.value=false
        }
    }

    fun detailNews(url:String?=this.url.value){
        url?.let {
            viewModelScope.launch {
                loading.value=true
                val resp=repo.detailNews(it)
                actionState.value=resp
                detailResp.value=resp.data
                loading.value=false
            }
        }
        fun serchNews(query: String?=this.query.value){
            query?.let {
                viewModelScope.launch {
                    loading.value=true
                    val  resp= repo.sercNews(it)
                    actionState.value=resp
                    serchResp.value=resp.data
                    loading.value=false
                }
            }
        }
    }
}