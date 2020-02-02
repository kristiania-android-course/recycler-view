package com.avp.farm_animals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_animals_list.*

class AnimalsListActivity : AppCompatActivity(), OnAnimalItemClick {

    val animals: List<String> = mutableListOf("Chicken", "Cow", "Goat", "Sheep")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals_list)
        recyclerview.layoutManager = GridLayoutManager(this, 2)
        val adapter = AnimalListAdapter(this, animals, this)
        recyclerview.adapter = adapter

    }

    override fun onClick(itemPosition: Int) {
        openImageActivity(animals[itemPosition])
    }

    private fun openImageActivity(name: String) {
        Intent(this, AnimalActivity::class.java).apply {
            putExtra("image_to_show", name)
        }.also {
            startActivity(it)
        }
    }
}
