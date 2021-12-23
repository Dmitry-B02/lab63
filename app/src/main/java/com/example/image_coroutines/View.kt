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

class MainViewModel: ViewModel() {
    val bitmapData = MutableLiveData<Bitmap>()

    fun loadImage() {
        viewModelScope.launch(Dispatchers.IO) {
            val url = URL("https://i.ibb.co/LCGjry8/Screenshot-20211121-231052-Gallery.jpg")
            val stream = url.openConnection().getInputStream()
            val bitmap = BitmapFactory.decodeStream(stream)
            withContext(Dispatchers.Main) {
                bitmapData.value = bitmap
            }
        }
    }
}