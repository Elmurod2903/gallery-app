package com.example.gallery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.interfaces.ItemCliclListener
import com.example.gallery.R
import com.example.gallery.databinding.ImageRvLayoutBinding

@Suppress("DEPRECATION")
class ImgAdapter(
    context: Context,
    private val list: List<Int>
) : RecyclerView.Adapter<ImgAdapter.ImgVH>() {

    private val inflater by lazy { LayoutInflater.from(context) }
    private val listener by lazy { context as ItemCliclListener }
    private var selectedP: Int = 0
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImgVH {
        val view = inflater.inflate(R.layout.image_rv_layout, parent, false)
        return ImgVH(view)
    }

    override fun onBindViewHolder(holder: ImgVH, position: Int) {
        val fusion = { pos: Int ->
            if (selectedP != pos) {
                selectedP = pos
                //  Color.TRANSPARENT
                notifyDataSetChanged()
            }
        }
        holder.onBind(position, position == selectedP, fusion, list[position])

    }

    override fun getItemCount() = list.size

    inner class ImgVH(
        private val view: View,
    ) : RecyclerView.ViewHolder(view) {
        private val binding = ImageRvLayoutBinding.bind(view)
        /*  init {
              containerView.setOnClickListener { listener.ItemClick(adapterPosition) }
          }*/

        fun onBind(id: Int, selected: Boolean, fusion: (Int) -> Unit, imageId: Int) {
            binding.imageRv.setImageResource(imageId)
            view.isSelected = selected
            view.setOnClickListener {
                listener.ItemClick(id,selected)
                fusion(id)
            }

        }

    }

}