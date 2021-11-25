package com.example.image_coroutines

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.example.image_coroutines.databinding.ActivityMainBinding
import java.util.concurrent.ExecutorService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val view = MainViewModel()
        if (binding.img.drawable == null) {
            viewModel.loadImageFromNet()
        }

        viewModel.bitmapData.observe(this) { value ->
            if (value != null) {
                binding.img.setImageBitmap(value)
            }
        }
    }
}