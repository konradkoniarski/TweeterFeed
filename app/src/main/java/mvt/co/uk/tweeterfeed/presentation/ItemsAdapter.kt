package mvt.co.uk.tweeterfeed.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import mvt.co.uk.tweeterfeed.R
import mvt.co.uk.tweeterfeed.databinding.ItemTweetBinding
import mvt.co.uk.tweeterfeed.domain.model.Tweet

/**
 * Copyright (c) 2020 Mobile Vision Technologies LTD. All rights reserved.
 * Created on 2020-02-09.
 */
class ItemsAdapter() :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private var items: MutableList<Tweet> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(parent)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        if (items.size > position) {
            holder.bind(items[position])
        }
    }

    fun update(items: List<Tweet>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    companion object {
        @JvmStatic
        @BindingAdapter("items")
        fun RecyclerView.bindItems(items: MutableLiveData<List<Tweet>>) {
            val adapter = adapter as ItemsAdapter
            adapter.update(items.value ?: emptyList())
            scheduleLayoutAnimation()
        }
    }

    class ItemViewHolder(
        private val parent: ViewGroup,
        private val binding: ItemTweetBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_tweet,
            parent,
            false
        )
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Tweet) {
            binding.textCreatedAt.text = item.createdAt
            binding.textFullText.text = item.fullText
        }
    }
}