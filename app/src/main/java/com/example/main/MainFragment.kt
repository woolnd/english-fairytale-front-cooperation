package com.example.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.main.databinding.FragmentMainBinding
import java.security.Key

class MainFragment: Fragment() {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.communityBtnIv.setOnClickListener {
            val intent = Intent(context, CommunityActivity::class.java)
            startActivity(intent)

        }

        val books = arrayListOf<Book>(
            Book("hello", arrayListOf("bio", "hello", "my name is jaewoong", "have a nice day", "hello"), false),
            Book("hello hello hello", arrayListOf("nice too meet you", "hello", "bye", "bye"), true)
        )

        binding.bookRv.apply {
            adapter = MainAdapter().build(books)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        return binding.root
    }
}