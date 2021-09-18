package com.example.gallery.adapter

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.gallery.fragment.ImagesFragment

class ImagePagerAdapter(
    fragmentManager: FragmentManager,
    private val list: List<Int>
) : FragmentPagerAdapter(
    fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getCount() = list.size

    override fun getItem(position: Int) = ImagesFragment.newInstance(list[position])
}