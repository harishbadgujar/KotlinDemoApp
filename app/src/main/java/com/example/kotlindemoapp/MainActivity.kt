package com.example.kotlindemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlindemoapp.view_images.adapter.ImagesAdapter
import com.example.kotlindemoapp.view_images.images_modal.ImageModal
import com.example.kotlindemoapp.view_images.viewmodel.ImageViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var imageviewModel: ImageViewModel
    private lateinit var imageAdapter: ImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupObservers()

    }

    private fun setupObservers() {

        progressBar.isVisible = true
        imageviewModel.photoLiveDataList.observe(this, androidx.lifecycle.Observer {
            setIndiaUpdate(it)
        })
        imageviewModel.getAllImages()


    }

    private fun setupViewModel() {
        imageviewModel = ViewModelProvider(this).get(ImageViewModel::class.java)
    }

    fun setIndiaUpdate(imagesList: List<ImageModal>) {
        progressBar.isVisible = false
        imageAdapter = ImagesAdapter(imagesList, MainActivity@ this)
        // imageAdapter.addPhotos(it)
        recyclerView.apply {

            recyclerView.adapter = imageAdapter
            recyclerView.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }

    }

}
