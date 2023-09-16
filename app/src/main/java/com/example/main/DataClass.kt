package com.example.main

data class Book(
    var title: String,
    var keywords: ArrayList<String>,
    var heart: Boolean
)

data class Books(
    val nick: String,
    var title: String,
    var keywords: ArrayList<String>,
    var heart: Boolean
)