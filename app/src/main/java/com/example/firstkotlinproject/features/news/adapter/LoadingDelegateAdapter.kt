package com.example.firstkotlinproject.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.firstkotlinproject.R
import com.example.firstkotlinproject.commons.adapter.ViewType
import com.example.firstkotlinproject.commons.adapter.ViewTypeDelegateAdapter
import com.example.firstkotlinproject.commons.extentions.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {

    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder (parent.inflate(R.layout.news_item_loading))
}