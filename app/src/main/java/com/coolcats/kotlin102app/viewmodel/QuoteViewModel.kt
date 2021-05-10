package com.coolcats.kotlin102app.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coolcats.kotlin102app.model.QuoteResponseItem
import com.coolcats.kotlin102app.model.network.QuoteRetrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class QuoteViewModel: ViewModel(){

    private val compositeDisposable = CompositeDisposable()

    private val quoteRetrofit = QuoteRetrofit()
    val liveData = MutableLiveData<List<QuoteResponseItem>>()

    fun getQuotesFromServer(){

        compositeDisposable.add(
            quoteRetrofit.getQuotes()
                .subscribeOn(
                    Schedulers.io()
                ).observeOn(AndroidSchedulers.mainThread())
                .subscribe({response ->

                    liveData.postValue(response)
                    compositeDisposable.clear()

                           }, { throwable ->

                    compositeDisposable.clear()
                    Log.d("TAG_X", throwable.toString())

                })
        )

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()

    }



}