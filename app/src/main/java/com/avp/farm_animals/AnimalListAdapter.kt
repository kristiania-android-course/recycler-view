package com.avp.farm_animals

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.animal_list_item.view.*


/**
 *
 *
 * Created by:  Arun Pillai
 * Email: arun.vijayan.pillai@shortcut.no
 *
 * Date: 02 February 2020
 */
class AnimalListAdapter(
    private val context: Context,
    val listOfAnimals: List<String> = mutableListOf(),
    private val onAnimalItemClick: OnAnimalItemClick
) : RecyclerView.Adapter<AnimalListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View, onAnimalItemClick: OnAnimalItemClick) :
        RecyclerView.ViewHolder(itemView) {
        val itemImageView: ImageView = itemView.item_img

        init {

            itemView.setOnClickListener {
                onAnimalItemClick.onClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutView = LayoutInflater.from(context).inflate(R.layout.animal_list_item, null)
        return ViewHolder(layoutView, onAnimalItemClick)
    }

    override fun getItemCount(): Int {
        return listOfAnimals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val drawableRes = when (listOfAnimals[position]) {
            "Chicken" -> R.drawable.chicken
            "Cow" -> R.drawable.cow
            "Goat" -> R.drawable.goat
            "Sheep" -> R.drawable.sheep
            else -> 0
        }

        holder.itemImageView.setImageResource(drawableRes)
    }
}

interface OnAnimalItemClick {
    fun onClick(itemPosition: Int)
}