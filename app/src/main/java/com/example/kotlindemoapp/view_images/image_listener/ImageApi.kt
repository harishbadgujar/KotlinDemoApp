package com.example.kotlindemoapp.view_images.image_listener

import com.example.kotlindemoapp.view_images.images_modal.ImageModal
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface ImageApi {

    @GET("photos")
    fun getMyImages(): Observable<List<ImageModal>>

    /*@GET("photos")
    fun getMyImages(): Call<List<ImageModal>>*/

    /*@GET("data.json")
    fun getData(): Observable<ApiResponse>*/
}