package com.unifor.pokedroid.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.unifor.pokedroid.R
import com.unifor.pokedroid.adapter.PokemonAdapter
import com.unifor.pokedroid.model.Named
import com.unifor.pokedroid.service.PokemonService
import com.unifor.pokedroid.service.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var pokemonService: PokemonService
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pokemonService = RetrofitConfig.getPokemonService()

        val listaPokemons = pokemonService.getAllPokemons()

        listaPokemons.enqueue(pokemonCallbackHandler)
    }

    private val pokemonCallbackHandler = object : Callback<Named> {
        override fun onFailure(call: Call<Named>?, t: Throwable?) {
            Log.i("onResponse", "Falha no callback handler")
        }

        override fun onResponse(call: Call<Named>?, response: Response<Named>?) {
            if (response != null) {
//                Log.i("onResponse",response.body().results.size.toString())
//                Log.i("onResponse",response.body().toString())
//                Log.i("onResponse",response.body()?.results?.get(1).toString())// recupera informações do 2 pokemon da lista
//                Log.i("onResponse", response.body()?.results?.get(1)?.url)// pega a url especifica
//                recyclerView.adapter = PokemonAdapter(this,response.body()?.results.)
            } else {
                Log.i("onResponse", "response é null")
            }
        }

    }
}
