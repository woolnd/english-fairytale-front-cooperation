package com.example.master

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.master.databinding.ActivityMasterMainBinding
import com.example.master.databinding.ActivityReportPostBinding

class ReportPostActivity: AppCompatActivity() {
    lateinit var binding: ActivityReportPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityReportPostBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}