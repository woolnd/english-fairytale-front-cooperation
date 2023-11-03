package com.example.front_end

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.front_end.databinding.ActivityServiceBinding

class ServiceActivity: AppCompatActivity() {

    lateinit var binding: ActivityServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityServiceBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backIv.setOnClickListener {
            finish()
        }
    }
}