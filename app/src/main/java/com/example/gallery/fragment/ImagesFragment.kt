package com.example.gallery.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gallery.databinding.FragmentImagesBinding

private const val KEY = "key"

class ImagesFragment : Fragment() {
    private var _binding: FragmentImagesBinding? = null
    private val binding get() = _binding

    private var image: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            image = it.getInt(KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImagesBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (image != 0) {
            _binding!!.ivPager.setImageResource(image)
        }
    }

    companion object {
        fun newInstance(id: Int) =
            ImagesFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY, id)
                }
            }
    }
}