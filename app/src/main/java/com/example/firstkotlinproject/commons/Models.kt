package com.example.firstkotlinproject.commons

import android.os.Parcel
import android.os.Parcelable
import com.example.firstkotlinproject.commons.adapter.AdapterConstants
import com.example.firstkotlinproject.commons.adapter.ViewType
import com.example.firstkotlinproject.commons.extentions.createParcel

data class RedditNews(
    val after: String,
    val before: String,
    val news: List<RedditNewsItem>
):Parcelable {
    companion object {
        @Suppress("unused")
        @JvmField val CREATOR = createParcel { RedditNews(it) }
        /* : Parcelable.Creator<RedditNews> = object : Parcelable.Creator<RedditNews> {
            override fun createFromParcel(source: Parcel): RedditNews = RedditNews(source)
            override fun newArray(size: Int): Array<RedditNews?> = arrayOfNulls(size)
        }*/
    }

    protected constructor(sourse: Parcel) : this(
        sourse.readString(),
        sourse.readString(),
        mutableListOf<RedditNewsItem>().apply {
            sourse.readTypedList(this, RedditNewsItem.CREATOR)
        }
        //sourse.createTypedArrayList(RedditNewsItem.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(after)
        dest.writeString(before)
        dest.writeTypedList(news)
    }
}

data class RedditNewsItem(
    val author: String,
    val title: String,
    val numComments: Int,
    val created: Long,
    val thumbnail: String,
    val url: String
) : ViewType, Parcelable {

    override fun getViewType() = AdapterConstants.NEWS

    companion object {
        @JvmField val CREATOR = createParcel { RedditNewsItem(it) }
        /*: Parcelable.Creator<RedditNewsItem> = object : Parcelable.Creator<RedditNewsItem> {
            override fun createFromParcel(source: Parcel): RedditNewsItem = RedditNewsItem(source)
            override fun newArray(size: Int): Array<RedditNewsItem?> = arrayOfNulls(size)
        }*/
    }

    protected constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readLong(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(author)
        dest?.writeString(title)
        dest?.writeInt(numComments)
        dest?.writeLong(created)
        dest?.writeString(thumbnail)
        dest?.writeString(url)
    }
}