package com.example.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.gallery.adapter.ImagePagerAdapter
import com.example.gallery.adapter.ImgAdapter
import com.example.gallery.databinding.ActivityMainBinding
import com.example.gallery.interfaces.ItemCliclListener

class MainActivity : AppCompatActivity(), ItemCliclListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imaList = listOf(*Constants.IMAGE_ID)
        setUpRV(imaList)
        setUPViewPager(imaList)
    }

    private fun setUPViewPager(imaList: List<Int>) {
        val pagerAdapter = ImagePagerAdapter(supportFragmentManager, imaList)
        binding.viewPager.adapter = pagerAdapter
        binding.viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.rv.scrollToPosition(position)

            }

        })

    }

    private fun setUpRV(imaList: List<Int>) {
        binding.rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rv.adapter = ImgAdapter(this, imaList)

    }

   override fun ItemClick(index: Int,item:Boolean) {
        binding.viewPager.currentItem = index

    }
}