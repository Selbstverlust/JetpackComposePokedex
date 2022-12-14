package com.plcoding.jetpackcomposepokedex.repository

import com.plcoding.jetpackcomposepokedex.data.remote.PokeApi
import com.plcoding.jetpackcomposepokedex.data.remote.responses.Pokemon
import com.plcoding.jetpackcomposepokedex.data.remote.responses.PokemonAbility
import com.plcoding.jetpackcomposepokedex.data.remote.responses.PokemonList
import com.plcoding.jetpackcomposepokedex.data.remote.responses.PokemonSpecies
import com.plcoding.jetpackcomposepokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
){
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>{
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An error has occurred.")
        }
        return Resource.Success(response)
    }
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon>{
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An error has occurred.")
        }
        return Resource.Success(response)
    }
    suspend fun getPokemonSpeciesInfo(pokemonName: String): Resource<PokemonSpecies>{
        val response = try {
            api.getPokemonSpeciesInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An error has occurred.")
        }
        return Resource.Success(response)
    }
    suspend fun getPokemonAbilityInfo(abilityName: String): Resource<PokemonAbility>{
        val response = try {
            api.getPokemonAbilityInfo(abilityName)
        } catch (e: Exception) {
            return Resource.Error("An error has occurred.")
        }
        return Resource.Success(response)
    }
}