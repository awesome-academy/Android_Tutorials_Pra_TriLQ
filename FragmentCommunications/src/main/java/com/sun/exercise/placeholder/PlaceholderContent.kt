package com.sun.exercise.placeholder

import androidx.appcompat.app.AppCompatActivity
import com.sun.exercise.R
import java.util.ArrayList
import java.util.HashMap

object PlaceholderContent {

    val ITEMS: MutableList<PlaceholderItem> = ArrayList()

    val ITEM_MAP: MutableMap<String, PlaceholderItem> = HashMap()

    private lateinit var application: AppCompatActivity

    fun initData(application: AppCompatActivity){
        this.application = application
    }

    init {
        val context = application.applicationContext
        addItem(PlaceholderItem("1", context.getString(R.string.song_title_1), context.getString(R.string.song_description_1)))
        addItem(PlaceholderItem("2", context.getString(R.string.song_title_2), context.getString(R.string.song_description_2)))
        addItem(PlaceholderItem("3", context.getString(R.string.song_title_3), context.getString(R.string.song_description_3)))
        addItem(PlaceholderItem("4", context.getString(R.string.song_title_4), context.getString(R.string.song_description_4)))
        addItem(PlaceholderItem("5", context.getString(R.string.song_title_5), context.getString(R.string.song_description_5)))
        addItem(PlaceholderItem("6", context.getString(R.string.song_title_6), context.getString(R.string.song_description_6)))
        addItem(PlaceholderItem("7", context.getString(R.string.song_title_7), context.getString(R.string.song_description_7)))
    }

    private fun addItem(item: PlaceholderItem) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    data class PlaceholderItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}
