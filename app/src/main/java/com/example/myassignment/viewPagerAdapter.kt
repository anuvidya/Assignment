package com.example.myassignment

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class viewPagerAdapter(private val context: Context, private val images: List<Any>) :  RecyclerView.Adapter<viewPagerAdapter.ImageViewHolder>() {

    //viewHolder class
    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)

//        init {
//
//            val radius = 16f
//            val shape = GradientDrawable()
//            shape.shape = GradientDrawable.RECTANGLE
//            shape.cornerRadius = radius
//            shape.setColor(Color.WHITE) // Set background color
//
//
//            imageView.background = shape
//            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
//        }
//
//        fun bind(imageResId: Int) {
//            imageView.setImageResource(imageResId)
//        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_images, parent, false)
        return ImageViewHolder(view)
    }
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        holder.imageView.setBackgroundResource(images[position] as Int)
//        Glide.with(context)
//            .load(images[position])
//            .centerCrop()
//            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return images.size
    }


}