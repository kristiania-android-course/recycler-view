package com.avp.farm_animals

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal.*

class AnimalActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal)
        val name = intent.getStringExtra("image_to_show")
        val drawableRes = when (name) {
            "Chicken" -> R.drawable.chicken
            "Cow" -> R.drawable.cow
            "Goat" -> R.drawable.goat
            "Sheep" -> R.drawable.sheep
            else -> 0
        }
        image_bigger.setImageResource(drawableRes)
        txt_animal_name.text = name

        /*fimgBigClick*/
        image_bigger.setOnClickListener {
            val rawMP3File = when (name) {
                "Chicken" -> R.raw.chicken
                "Cow" -> R.raw.chicken
                "Goat" -> R.raw.chicken
                "Sheep" -> R.raw.chicken
                else -> 0
            }
            playAudio(rawMP3File)
        }

    }

    private fun playAudio(rawMP3File: Int) {
        var mPlayer: MediaPlayer? = null
        mPlayer = MediaPlayer.create(this, rawMP3File)
        mPlayer?.start()
    }


}
