package com.example.firstkotlinproject.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.firstkotlinproject.R
import com.example.firstkotlinproject.commons.RedditNewsItem
import com.example.firstkotlinproject.commons.adapter.ViewType
import com.example.firstkotlinproject.commons.adapter.ViewTypeDelegateAdapter
import com.example.firstkotlinproject.commons.extentions.getFreandlyTime
import com.example.firstkotlinproject.commons.extentions.inflate
import com.example.firstkotlinproject.commons.extentions.loadImg
import kotlinx.android.synthetic.main.news_item.view.*

class NewsDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item)) {
        fun bind(item: RedditNewsItem) = with(itemView) {
            //Picasso.with(itemView.context).load(item.thumbnail).into(img_thumbnail)
            author.text = item.author
            description.text = item.title
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFreandlyTime()
            img_thumbnail.loadImg(item.thumbnail)
        }
    }

}