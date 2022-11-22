package kr.dev.dspark.roomwordsample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.dev.dspark.roomwordsample.data.model.WordEntity
import kr.dev.dspark.roomwordsample.databinding.ItemWordBinding

class WordListAdapter : ListAdapter<WordEntity, WordListAdapter.WordViewHolder>(WordDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val binding = ItemWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.word)
    }

    inner class WordViewHolder(private val binding: ItemWordBinding) :  RecyclerView.ViewHolder(binding.root) {
        fun bind(word : String?) {
            binding.tvWordItem.text = word
        }
    }

    class WordDiffCallback : DiffUtil.ItemCallback<WordEntity>() {
        override fun areItemsTheSame(oldItem: WordEntity, newItem: WordEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: WordEntity, newItem: WordEntity): Boolean {
            return oldItem.word == newItem.word
        }

    }


}