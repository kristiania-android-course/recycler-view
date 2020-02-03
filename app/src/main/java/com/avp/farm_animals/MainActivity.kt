package com.avp.farm_animals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*fimClick*/
        img_chicken.setOnClickListener (this)
        img_cow.setOnClickListener(this)
        img_goat.setOnClickListener(this)
        img_sheep.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        when(view?.id){
            R.id.img_chicken -> openAnimalActivity("Chicken")
            R.id.img_cow -> openAnimalActivity("Cow")
            R.id.img_goat -> openAnimalActivity("Goat")
            R.id.img_sheep -> openAnimalActivity("Sheep")
        }
    }

    private fun openAnimalActivity(name : String){
        val intent = Intent(this, AnimalActivity::class.java)
        intent.putExtra("name_of_animal", name)
        startActivity(intent)
    }

    /*fopAnim*/



    /*fwhenOnClick*/



}
