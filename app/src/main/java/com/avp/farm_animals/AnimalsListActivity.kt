package com.avp.farm_animals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_animals_list.*

class AnimalsListActivity : AppCompatActivity(), ImageClickListener {

    /*flistAnimals*/

    val animals : List<String> = mutableListOf("Chicken", "Cow", "Goat", "Sheep")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals_list)

        val adapter = AnimalAdapter(this, animals, this)
        recyclerview.layoutManager = GridLayoutManager(this, 2)
        recyclerview.adapter = adapter
    }

    override fun itemClicked(position: Int) {
        //Toast.makeText(this, animals[position], Toast.LENGTH_SHORT).show()
        openAnimalActivity(animals[position])
    }

    private fun openAnimalActivity(name : String){
        val intent = Intent(this, AnimalActivity::class.java)
        intent.putExtra("name_of_animal", name)
        startActivity(intent)
    }
}
