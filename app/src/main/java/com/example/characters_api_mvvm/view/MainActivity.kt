package com.example.characters_api_mvvm.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.characters_api_mvvm.R
import com.example.characters_api_mvvm.adapters.CharactersListAdapter
import com.example.characters_api_mvvm.model.CharacterItem
import com.example.characters_api_mvvm.model.Characters
import com.example.characters_api_mvvm.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity(), CharactersListAdapter.OnItemClickAction {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var allCharactersAdapter: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        allCharactersAdapter = findViewById(R.id.recyclerView_all_characters)

        viewModel.getAllCharacters()
        setObservers()
    }

    private fun setObservers() {
        viewModel.status.observe(this, { if (it == false) errorInfo() })
        viewModel.characters.observe(this, { showData(it) })
    }

    private fun showData(characters: Characters) {
        allCharactersAdapter.layoutManager = GridLayoutManager(this, 2)
        allCharactersAdapter.adapter = CharactersListAdapter(this, characters, this)
    }

    private fun errorInfo() {
        Toast.makeText(this, "Error. Data can not be loaded.", Toast.LENGTH_SHORT).show()
    }

    override fun itemClicked(character: CharacterItem) {
        val intent = Intent(this, DetailsActivity::class.java)

        intent.putExtra("name", character.name)
        intent.putExtra("nickname", character.nickname)
        intent.putExtra("image", character.image)
        intent.putExtra("status", character.status)

        startActivity(intent)
    }

}