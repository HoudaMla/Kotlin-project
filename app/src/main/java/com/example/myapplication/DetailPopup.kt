package com.example.myapplication

import android.app.Dialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import com.bumptech.glide.Glide

class DetailPopup(
    private val adapter: Context,
    private val currentPhoto: MyDataItem
        ): Dialog(adapter.applicationContext){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popup_home_details)

        setupComponents()
        setupCloseButton()
}

    private fun setupCloseButton() {
        findViewById<ImageView>(R.id.close_button).setOnClickListener{
            dismiss()
        }

    }

    private fun setupComponents() {
        val photoImage = findViewById<ImageView>(R.id.image_item_2)
        Glide.with(adapter.applicationContext).
        load(Uri.parse(currentPhoto.urls.small)).
        into(photoImage)





    }
}