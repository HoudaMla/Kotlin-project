package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myapplication.DetailPopup
import com.example.myapplication.R
import com.example.myapplication.MyDataItem

class ListAdapter(
    val context: Context,
    private val photoList: List<MyDataItem>,
   ): RecyclerView.Adapter<ListAdapter.ViewHolder>(){



     class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener{
        var username : TextView
        var image : ImageView
        var created : TextView
        init {
            username = itemView.findViewById(R.id.username_item)
            image = itemView.findViewById(R.id.image_item1)
            created = itemView.findViewById(R.id.creation_item)
            image.setOnClickListener(this )
        }

        override fun onClick(v: View?) {

        }
        interface  OnItemClickListener{
            fun onItemClick()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(context)
            .inflate(R.layout.item_vertical,parent, false )


        return ViewHolder(itemView )


        

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val currentPhoto = photoList[position]
        Glide.with(context)
            .load(photoList[position].urls.small)
            .into(holder.image)
        holder.created.text = photoList[position].created_at.toString()
        holder.username.text = photoList[position].user.username.toString()

        //interaction lors du click popup


            }


    override fun getItemCount(): Int = photoList.size



}