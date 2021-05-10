package com.coolcats.kotlin102app.model.network

import com.coolcats.kotlin102app.model.QuoteResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class QuoteRetrofit {

    private val quoteService = createRetrofit().create(QuoteService::class.java)//QuoteService.class

    private fun createRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://zenquotes.io/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getQuotes(): Single<QuoteResponse> = quoteService.getQuotes()

    interface QuoteService {
        @GET("/api/quotes")
        fun getQuotes(): Single<QuoteResponse>
    }

}