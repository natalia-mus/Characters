package com.example.characters_api_mvvm.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.characters_api_mvvm.R
import com.example.characters_api_mvvm.model.CharacterItem
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setData()
    }

    private fun setData() {
        val name = findViewById<TextView>(R.id.characterDetails_name)
        val nickname = findViewById<TextView>(R.id.characterDetails_nickname)
        val image = findViewById<ImageView>(R.id.characterDetails_image)
        val birthday = findViewById<TextView>(R.id.characterDetails_birthday)
        val status = findViewById<TextView>(R.id.characterDetails_status)

        val character: CharacterItem? = intent.getParcelableExtra("characterItem")

        val characterName = character?.name
        val characterNickname = character?.nickname
        val characterImage = character?.image
        val characterBirthday = character?.birthday
        val characterStatus = character?.status

        name.text = characterName
        nickname.text = characterNickname
        birthday.text = characterBirthday
        status.text = characterStatus

        Picasso.with(this).load(characterImage).fit().centerCrop().into(image)
    }
}