package com.example.image_coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.image_coroutines.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val download: Button = findViewById(R.id.download)
        download.setOnClickListener {
            val viewModel = MainViewModel()
            if (binding.img.drawable == null) {
                viewModel.loadImage()
            }

            viewModel.bitmapData.observe(this) { value ->
                if (value != null) {
                    binding.img.setImageBitmap(value)
                }
            }
            download.visibility = View.GONE
        }
    }
}