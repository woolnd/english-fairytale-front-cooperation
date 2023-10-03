package com.example.master

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.master.databinding.ActivityReportNickBinding

class ReportNickActivity: AppCompatActivity() {
    lateinit var binding: ActivityReportNickBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityReportNickBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}