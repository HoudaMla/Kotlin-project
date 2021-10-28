package com.example.myapplication
import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import com.bumptech.glide.Glide


import com.example.myapplication.adapter.NavAdapter

class StoryPopup (
    private val adapter: NavAdapter,
    private val currentPhoto : MyDataItem
)
    : Dialog(adapter.context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popup_story_details)
    }
    private fun setupComponents() {
        val photoImage = findViewById<ImageView>(R.id.image_story)
        Glide.with(adapter.context).load(Uri.parse(currentPhoto.user.profile_image.toString())).into(photoImage)
    }
}