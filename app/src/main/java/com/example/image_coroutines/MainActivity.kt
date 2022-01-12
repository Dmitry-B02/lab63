package com.example.image_coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.image_coroutines.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {
    private lateinit var download: Button
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        download = findViewById(R.id.download)
        download.setOnClickListener {
            val model = View()
            if (binding.img.drawable == null) {
                model.loadImage()
            }
            model.data.observe(this) { value ->
                if (value != null) {
                    binding.img.setImageBitmap(value)
                }
            }
            download.visibility = View.GONE
        }
    }
}