package com.example.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.main.databinding.FragmentPwModifyPopupBinding

class PwModifyPopupFragment: Fragment() {

    lateinit var binding: FragmentPwModifyPopupBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPwModifyPopupBinding.inflate(inflater, container, false)

        binding.btnIv.setOnClickListener {
            (activity as PwModifyActivity).changeFragment(this)
        }

        binding.closeIv.setOnClickListener {
            (activity as PwModifyActivity).changeFragment(this)
        }

        return binding.root
    }
}