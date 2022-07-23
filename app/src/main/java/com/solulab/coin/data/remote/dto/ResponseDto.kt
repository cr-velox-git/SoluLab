package com.solulab.coin.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResponseDto(

    @field:SerializedName("result")
    val result: Int? = null,

    @field:SerializedName("msg")
    val msg: String? = null,

    @field:SerializedName("data")
    val data: Data? = null
)

data class Data(

    @field:SerializedName("totalItems")
    val totalItems: Int? = null,

    @field:SerializedName("startIndex")
    val startIndex: Int? = null,

    @field:SerializedName("itemsPerPage")
    val itemsPerPage: Int? = null,

    @field:SerializedName("list")
    val list: List<ListItem?>? = null
)

data class ListItem(

    @field:SerializedName("isGraded")
    val isGraded: Boolean? = null,

    @field:SerializedName("year")
    val year: Int? = null,

    @field:SerializedName("price")
    val price: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("history")
    val history: String? = null,

    @field:SerializedName("age")
    val age: Int? = null,

    @field:SerializedName("pictures")
    val pictures: Pictures? = null,

    @field:SerializedName("isSold")
    val isSold: Boolean? = null,

    @field:SerializedName("isCoin")
    val isCoin: Boolean? = null,

    @field:SerializedName("tags")
    val tags: List<String?>? = null
)

data class Pictures(

    @field:SerializedName("back")
    val back: Back? = null,

    @field:SerializedName("front")
    val front: Front? = null
)

data class Front(

    @field:SerializedName("sizeInMegaByte")
    val sizeInMegaByte: Double? = null,

    @field:SerializedName("key")
    val key: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class Back(

    @field:SerializedName("sizeInMegaByte")
    val sizeInMegaByte: Double? = null,

    @field:SerializedName("key")
    val key: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)




