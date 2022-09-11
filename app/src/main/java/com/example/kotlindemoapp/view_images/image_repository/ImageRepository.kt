package com.example.kotlindemoapp.view_images.image_repository

import com.example.kotlindemoapp.view_images.ImageRetrofitClient
import com.example.kotlindemoapp.view_images.image_listener.ImageApi
import com.example.kotlindemoapp.view_images.images_modal.ImageModal
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class ImageRepository {

    fun imagesRepo(action: (List<ImageModal>?) -> Unit){

        val compositeDisposable = CompositeDisposable()
        val apiRequest = ImageRetrofitClient.createIndiaService(ImageApi::class.java)
        val disposable: Disposable = apiRequest.getMyImages()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<List<ImageModal>>() {

                override fun onNext(response: List<ImageModal>) {
                    action(response)
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {
                }
            })

        compositeDisposable.add(disposable)


    }

}