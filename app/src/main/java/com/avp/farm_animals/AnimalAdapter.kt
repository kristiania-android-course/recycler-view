package com.avp.farm_animals

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.animal_image_item.view.*


/**
 *
 *
 * Created by:  Arun Pillai
 * Email: arun.vijayan.pillai@shortcut.no
 *
 * Date: 03 February 2020
 */
class AnimalAdapter(val context: Context,
                    val list: List<String>,
                    val clickListener: ImageClickListener) : RecyclerView.Adapter<AnimalAdapter.ViewHolder>(){


    class ViewHolder(itemView: View, val clickListener: ImageClickListener) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.img_small
        init {
            itemView.setOnClickListener {
                clickListener.itemClicked(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.animal_image_item, null)
        return ViewHolder(view, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val drawableRes = when (list[position]) {
            "Chicken" -> R.drawable.chicken
            "Cow" -> R.drawable.cow
            "Goat" -> R.drawable.goat
            "Sheep" -> R.drawable.sheep
            else -> 0
        }
        holder.imageView.setImageResource(drawableRes)
    }
}


interface ImageClickListener{
    fun itemClicked(position: Int)
}