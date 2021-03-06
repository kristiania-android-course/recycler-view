package com.avp.farm_animals

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_animal.*

class AnimalActivity : AppCompatActivity() {
    var mPlayer: MediaPlayer? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal)

        val name = intent.getStringExtra("name_of_animal")

        text_name_animal.text = name

        val drawableRes = when (name) {
            "Chicken" -> R.drawable.chicken
            "Cow" -> R.drawable.cow
            "Goat" -> R.drawable.goat
            "Sheep" -> R.drawable.sheep
            else -> 0
        }

        image_bigger.setImageResource(drawableRes)

        image_bigger.setOnClickListener {
            val mp3File = when (name) {
                "Chicken" -> R.raw.chicken
                "Cow" -> R.raw.chicken
                "Goat" -> R.raw.chicken
                "Sheep" -> R.raw.chicken
                else -> 0
            }

            playAudio(mp3File)
        }
        /*fgetDrawable*/

        /*fimgBigClick*/
    }

    /*fplayAudio*/

    private fun playAudio(rawMP3File: Int) {
        mPlayer = MediaPlayer.create(this, rawMP3File)
        mPlayer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPlayer?.stop()
        mPlayer?.release()
    }


}
