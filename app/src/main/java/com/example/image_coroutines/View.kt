package com.example.image_coroutines

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class View: ViewModel() {
    val data = MutableLiveData<Bitmap>()


    fun loadImage() {
        viewModelScope.launch(Dispatchers.IO) {
            val url = URL("https://i.ibb.co/LCGjry8/Screenshot-20211121-231052-Gallery.jpg")
            val stream = url.openConnection().getInputStream()
            stream.use {
                val mIcon_val = BitmapFactory.decodeStream(it)
                withContext(Dispatchers.Main) {
                    data.value = mIcon_val
                }
            }
        }
    }
}