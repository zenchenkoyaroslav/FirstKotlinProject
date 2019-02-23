package com.example.firstkotlinproject.di.news

import com.example.firstkotlinproject.di.NetworkModule
import com.example.firstkotlinproject.features.news.NewsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AppModule::class,
    NewsModule::class,
    NetworkModule::class))
interface NewsComponent {
    fun inject(newsFragment: NewsFragment)
}