package com.example.myapplication

import com.example.myapplication.model.Links
import com.example.myapplication.model.Sponsorship
import com.example.myapplication.model.Urls
import com.example.myapplication.model.User

data class MyDataItem(
    val alt_description: String,
    val blur_hash: String,
    val categories: List<Any>,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: String,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: Links,
    val promoted_at: String,
    val sponsorship: Sponsorship,
    val updated_at: String,
    val urls: Urls,
    val user: User,
    val width: Int
)