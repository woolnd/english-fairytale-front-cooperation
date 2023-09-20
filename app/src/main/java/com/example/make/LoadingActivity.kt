package com.example.make

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.make.databinding.ActivityLoadingBinding
import android.os.Handler
import android.os.Looper

class LoadingActivity: AppCompatActivity() {

    lateinit var binding: ActivityLoadingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoadingBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.beforebuttonLoadingIv.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        Handler(Looper.getMainLooper()).postDelayed({
            val intent2 = Intent(this, CreateFinishActivity::class.java)
            startActivity(intent2)
        },2000)

    }
}