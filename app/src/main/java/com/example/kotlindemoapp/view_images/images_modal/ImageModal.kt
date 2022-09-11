package com.example.kotlindemoapp.view_images.images_modal

import com.google.gson.annotations.SerializedName

data class ImageModal(
    @SerializedName("albumId")
    var albumId: Int,

    @SerializedName("id")
    var id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String
)