package com.example.characters_api_mvvm.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.characters_api_mvvm.R
import com.example.characters_api_mvvm.model.Characters
import com.squareup.picasso.Picasso

class CharactersListAdapter(private val context: Context, private val characters: Characters) :
    RecyclerView.Adapter<CharactersListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersListViewHolder {
        return CharactersListViewHolder(
            LayoutInflater.from(context).inflate(R.layout.character_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharactersListViewHolder, position: Int) {
        Picasso.with(context)
            .load(characters[position].image)
            .resize(130, 200)
            .centerCrop()
            .into(holder.image)

        holder.name.text = characters[position].name
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}


class CharactersListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val image = itemView.findViewById<ImageView>(R.id.allCharacters_image)
    val name = itemView.findViewById<TextView>(R.id.allCharacters_name)
}