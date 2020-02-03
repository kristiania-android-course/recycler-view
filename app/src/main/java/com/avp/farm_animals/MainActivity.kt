package com.avp.farm_animals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


// implement on click listener for the activity
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set the onclick listener
        img_chicken.setOnClickListener(this)
        img_cow.setOnClickListener(this)
        img_goat.setOnClickListener(this)
        img_sheep.setOnClickListener(this)

    }


    override fun onClick(clickedView: View?) {

        // when the id is chicken(or any other) open the new activity with the name chicken
        when (clickedView?.id) {
            R.id.img_chicken -> openImageActivity("Chicken")
            R.id.img_cow -> openImageActivity("Cow")
            R.id.img_goat -> openImageActivity("Goat")
            R.id.img_sheep -> openImageActivity("Sheep")
        }
    }

    /**
     * Intent to open the new activity
     */
    private fun openImageActivity(name: String) {
        Intent(this, AnimalActivity::class.java).apply {
            putExtra("image_to_show", name)
        }.also {
            startActivity(it)
        }
    }
}
