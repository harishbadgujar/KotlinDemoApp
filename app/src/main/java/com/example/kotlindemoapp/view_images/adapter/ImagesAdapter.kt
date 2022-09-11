package com.example.kotlindemoapp.view_images.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.example.kotlindemoapp.R
import com.example.kotlindemoapp.view_images.images_modal.ImageModal

class ImagesAdapter (
    private
    var imageList: List<ImageModal>, private val context: Context
) : RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.images_row, parent, false))
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = imageList.get(position)
        holder.title.text = dataModel.id.toString()
        holder.titleTextView.text = dataModel.title

        holder.ivImage.load(dataModel.url) {
            placeholder(R.drawable.ic_launcher_background)
        }

    }

    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {

         var titleTextView: TextView
         var title: TextView
        var ivImage: ImageView

        init {

            titleTextView = itemLayoutView.findViewById(R.id.image_title)
            ivImage = itemLayoutView.findViewById(R.id.imagephoto)
            title = itemLayoutView.findViewById(R.id.id_image)
        }


    }

}