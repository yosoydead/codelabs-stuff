package com.example.dicerollerimg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //fac cunoscuti membrii din view ca sa poate fi folositi si din functii
    private var img1: ImageView? = null
    private lateinit var img2: ImageView
    private lateinit var clear: Button
    private lateinit var txt1: TextView
    private lateinit var txt2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initializez membrii din view
        img1 = findViewById(R.id.dice_image1)
        img2 = findViewById(R.id.dice_image2)
        txt1 = findViewById(R.id.dice1_text)
        txt2 = findViewById(R.id.dice2_text)

        //referinta la buton
        val button: Button = findViewById(R.id.roll_dice)
        clear = findViewById(R.id.clear)

        //click listener la buton
        button.setOnClickListener {
            roll(img1 as ImageView, txt1)
            roll(img2, txt2)
        }

        clear.setOnClickListener {
            reset(img1 as ImageView, txt1)
            reset(img2, txt2)
        }


    }
    private fun reset(img: ImageView, txt: TextView){
        img.setImageResource(R.drawable.empty_dice)
        txt.text = txt.tag.toString()

    }

    private fun genRndNum(): Int{
        val nr = Random.nextInt(6)+1

        return nr
    }
    private fun roll(src: ImageView, txt: TextView){
        val nr = genRndNum()

        val resource = when(nr){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        src.setImageResource(resource)
        txt.text = "${txt.tag} = $nr"
    }

}
