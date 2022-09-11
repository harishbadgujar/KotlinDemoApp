package com.example.kotlindemoapp.view_images.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlindemoapp.view_images.image_repository.ImageRepository
import com.example.kotlindemoapp.view_images.images_modal.ImageModal

class ImageViewModel : ViewModel() {

    var photoLiveDataList = MutableLiveData<List<ImageModal>>()

    fun getAllImages(){

        val respImages : (List<ImageModal>?) -> Unit = {s : List<ImageModal>? ->  photoLiveDataList.value = s }

        ImageRepository().imagesRepo(respImages)

    }
}

