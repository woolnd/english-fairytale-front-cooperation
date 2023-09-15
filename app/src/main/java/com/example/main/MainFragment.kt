package com.example.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.main.databinding.FragmentMainBinding

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

        val itemList = ArrayList<MyBook>()
        itemList.add(MyBook("hello its me"))
        itemList.add(MyBook("my name is wodnd"))

        val mainAdapter = MainAdapter(itemList)
        mainAdapter.notifyDataSetChanged()
        binding.bookRv.adapter = mainAdapter
        binding.bookRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        return binding.root
    }
}