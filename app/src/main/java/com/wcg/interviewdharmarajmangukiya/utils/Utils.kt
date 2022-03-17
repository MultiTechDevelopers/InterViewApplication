package com.wcg.interviewdharmarajmangukiya.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.wcg.interviewdharmarajmangukiya.R
import com.wcg.interviewdharmarajmangukiya.data.network.MyBase
import com.wcg.interviewdharmarajmangukiya.data.network.MyCalls
import com.wcg.interviewdharmarajmangukiya.data.network.PrefManager

//for API calling
fun Context?.selectApi(): MyCalls? {
    return MyBase.getMyBase(this)?.create(MyCalls::class.java)
}

//for sharedPreference
fun Context?.prefManager(): PrefManager {
    return PrefManager(this)
}

//to Toast
fun Context?.toast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

//start activity
fun <T> Context.moveTo(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}

//To make view visibility GONE
fun viewGone(view: View?) {
    view?.visibility = View.GONE
}

//To make view visibility VISIBLE
fun viewVisible(view: View?) {
    view?.visibility = View.VISIBLE
}

//glide set image
fun setImage(imageView: ImageView?, url: String?) {
    if (imageView != null) {
        Glide.with(imageView.context)
            .load(url)
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(imageView)
    }
}