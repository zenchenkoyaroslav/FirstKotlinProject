package com.example.firstkotlinproject.commons.extentions

import android.os.Parcel
import android.os.Parcelable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.firstkotlinproject.R
import com.squareup.picasso.Picasso

fun ViewGroup.inflate(layoutID: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutID, this, attachToRoot)
}

fun ImageView.loadImg(imageURL: String) {
    if (TextUtils.isEmpty(imageURL)) {
        Picasso.with(context).load(R.mipmap.ic_launcher_round).into(this)
    } else {
        Picasso.with(context).load(imageURL).into(this)
    }
}

inline fun <reified T : Parcelable> createParcel(crossinline createFromParcel: (Parcel) -> T?)
        : Parcelable.Creator<T> =
        object : Parcelable.Creator<T> {
            override fun createFromParcel(source: Parcel): T? = createFromParcel(source)
            override fun newArray(size: Int): Array<out T?> = arrayOfNulls(size)
        }