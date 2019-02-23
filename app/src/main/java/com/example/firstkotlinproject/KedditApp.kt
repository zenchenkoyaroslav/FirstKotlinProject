package com.example.firstkotlinproject

import android.app.Application
import com.example.firstkotlinproject.di.news.AppModule
import com.example.firstkotlinproject.di.news.DaggerNewsComponent
import com.example.firstkotlinproject.di.news.NewsComponent
import com.example.firstkotlinproject.di.news.NewsModule

class KedditApp: Application() {
    companion object {
        lateinit var newsComponent: NewsComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerNewsComponent.builder()
            .appModule(AppModule(this))
            //.newsModule(NewsModule())
            .build()
    }

}