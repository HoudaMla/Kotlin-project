package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myapplication.MyDataItem
import com.example.myapplication.R
import com.example.myapplication.StoryPopup

class NavAdapter(
    val context: Context,
    private val photoList: List<MyDataItem>
) : RecyclerView.Adapter<NavAdapter.ViewHolder>(){
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var username : TextView
        var image : ImageView

        init {
            username = itemView.findViewById(R.id.username_item)
            image = itemView.findViewById(R.id.image_item)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(context)
            .inflate(R.layout.item_horizontale,parent, false )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(photoList[position].user.profile_image.large)
            .into(holder.image)
        holder.username.text = photoList[position].user.username.toString()

        holder.image.setOnClickListener {
            val currentPhoto = photoList[position]
            StoryPopup(this, currentPhoto).show()

        }
    }

    override fun getItemCount(): Int = photoList.size
}