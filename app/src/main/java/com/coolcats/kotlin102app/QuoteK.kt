package com.coolcats.kotlin102app

data class QuoteK(val message: String, val personName: String){

    constructor(message: String) : this(message, "")

}
