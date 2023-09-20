package com.example.make

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.make.databinding.ActivityCreateFinishBinding

class CreateFinishActivity : AppCompatActivity() {
    lateinit var binding: ActivityCreateFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}