package com.sun.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.sun.exercise.placeholder.PlaceholderContent
import com.sun.exercise.databinding.FragmentSongListBinding
import com.sun.exercise.databinding.SongListContentBinding

class SongListFragment : Fragment() {
    private val binding: FragmentSongListBinding by lazy {
        FragmentSongListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView(binding.songList, binding.songDetailNavContainer)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView, itemDetailFragmentContainer: View?) {
        recyclerView.adapter = SimpleItemRecyclerViewAdapter(
            PlaceholderContent.ITEMS, itemDetailFragmentContainer
        )
    }

    class SimpleItemRecyclerViewAdapter(private val values: List<PlaceholderContent.PlaceholderItem>, private val itemDetailFragmentContainer: View?) :
        RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = SongListContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = values[position]
            holder.bindData(item)

            with(holder.itemView) {
                tag = item
                setOnClickListener { itemView ->
                    val itemSelected = itemView.tag as PlaceholderContent.PlaceholderItem

                    val bundle = Bundle()
                    bundle.putString(SongDetailFragment.ARG_ITEM_ID, itemSelected.id)

                    if (itemDetailFragmentContainer != null) {
                        itemDetailFragmentContainer.findNavController().navigate(R.id.fragment_song_detail, bundle)
                    } else {
                        itemView.findNavController().navigate(R.id.show_song_detail, bundle)
                    }
                }
            }
        }

        override fun getItemCount() = values.size

        inner class ViewHolder(binding: SongListContentBinding) : RecyclerView.ViewHolder(binding.root) {
            private var idView: TextView = binding.idText
            private var contentView: TextView = binding.content
            fun bindData(item: PlaceholderContent.PlaceholderItem){
                idView.text = item.id
                contentView.text = item.content
            }
        }
    }
}
