package com.coolcats.kotlin102app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import com.coolcats.kotlin102app.QuoteK
import com.coolcats.kotlin102app.R
import com.coolcats.kotlin102app.viewmodel.QuoteViewModel
import kotlinx.android.synthetic.main.activity_main.*


//class MainActivity extends AppCompatActivity implements LifecycleOwner {///
class MainActivity : AppCompatActivity(), LifecycleOwner {

    //val -> immutable
    //var -> mutable

//    private val x = 2
//    var y = 3
//    lateinit var name: String
//    var surname: String? = null
//
//    val quoteList: List<QuoteK> = mutableListOf(QuoteK("To be or not to be"), QuoteK("Brush twice :-)", "Unknown"))

    private val viewModel: QuoteViewModel by viewModels()

    private val quoteAdapter = QuoteAdapter(listOf())

    //@Override
    //protected void onCreate(Bundle savedInstanceState){//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.liveData.observe(this, { list ->
            quoteAdapter.updateQuotes(list)
        })

        //Kotlin synthetics
        quote_recyclerview.adapter = quoteAdapter

        viewModel.getQuotesFromServer()

//
//        surname?.let {
//            Log.d("TAG_X", it)
//        } ?: {
//            if (this::name.isInitialized)
//                Log.d("TAG_X", name)
//            else
//                Log.d("TAG_X", "ooops")
//        }()
//
//
//        quoteList.forEach {
//
//        }
//
//        /*
//        * for(int i = 0; i < 10; i++){
//        * */
//
//        for (i in 0 until 10)
//            Log.d("TAG_X", i.toString())
//
//        for (i in 1..10)
//            Log.d("TAG_X222", i.toString())

    }
}