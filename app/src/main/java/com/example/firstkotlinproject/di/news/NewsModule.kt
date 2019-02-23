package com.example.firstkotlinproject.di.news

import com.example.firstkotlinproject.api.NewsApi
import com.example.firstkotlinproject.api.NewsRestApi
import com.example.firstkotlinproject.api.RedditApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NewsModule {

    @Provides
    @Singleton
    fun provideNewsApi(redditApi: RedditApi): NewsApi {
        return NewsRestApi(redditApi)
    }

    @Provides
    @Singleton
    fun provideRedditApi(retrofit: Retrofit): RedditApi{
        return retrofit.create(RedditApi::class.java)
    }

}