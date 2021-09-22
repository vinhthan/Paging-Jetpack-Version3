package com.example.pagingjetpackversion3.model

data class UserList(
    val info: Info,
    val results: List<Results>
)

data class Info(
    val count: Int?,
    val pages: String?,
    val next: String?,
    val prev: String?
)

data class Results(
    val id: Int?,
    val name: String?,
    val species: String?,
    val image: String?
)
