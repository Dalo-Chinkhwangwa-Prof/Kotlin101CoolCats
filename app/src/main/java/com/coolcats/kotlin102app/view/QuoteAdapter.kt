package com.coolcats.kotlin102app.view

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coolcats.kotlin102app.BuildConfig
import com.coolcats.kotlin102app.R
import com.coolcats.kotlin102app.model.QuoteResponseItem
import kotlinx.android.synthetic.main.quote_item_layout.view.*

class QuoteAdapter(private var quoteList: List<QuoteResponseItem>) :
    RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {
    inner class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun updateQuotes(quoteList: List<QuoteResponseItem>) {
        this.quoteList = quoteList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.quote_item_layout, parent, false)
        return QuoteViewHolder(itemView)
    }

    fun String.fromHtmlToString(): String =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            Html.fromHtml(this).toString()
        }
    fun Int.cube() = this * this * this

    //String.toInt()
    //Int.toString()
    //Double.toInt()
    //Boolean
    //Float
    //Long
    //Short
    //Char
    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        quoteList[position].let {
            holder.itemView.apply {
                author_textview.text = "${position.cube()} ${it.a}"
                quote_textview.text = it.h.fromHtmlToString()
            }
        }
    }

    override fun getItemCount(): Int = quoteList.size
}