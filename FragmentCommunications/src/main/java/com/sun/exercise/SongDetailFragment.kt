package com.sun.exercise

import android.content.ClipData
import android.os.Bundle
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.sun.exercise.databinding.FragmentSongDetailBinding
import com.sun.exercise.placeholder.PlaceholderContent

class SongDetailFragment : Fragment() {

    private var item: PlaceholderContent.PlaceholderItem? = null

    private val binding: FragmentSongDetailBinding by lazy {
        FragmentSongDetailBinding.inflate(layoutInflater)
    }

    private val dragListener = View.OnDragListener { _, event ->
        if (event.action == DragEvent.ACTION_DROP) {
            val clipDataItem: ClipData.Item = event.clipData.getItemAt(0)
            val dragData = clipDataItem.text
            item = PlaceholderContent.ITEM_MAP[dragData]
            updateContent()
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { if (it.containsKey(ARG_ITEM_ID)) { item = PlaceholderContent.ITEM_MAP[it.getString(ARG_ITEM_ID)] } }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        updateContent()

        binding.root.setOnDragListener(dragListener)

        return binding.root
    }

    private fun updateContent() {
        binding.toolbarLayout?.title = item?.content
        item?.let { binding.songDetail.text = it.details }
    }

    companion object {
        const val ARG_ITEM_ID = "item_id"
    }
}
