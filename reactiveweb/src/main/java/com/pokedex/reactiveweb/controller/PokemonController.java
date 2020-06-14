package com.pokedex.reactiveweb.controller;

import com.pokedex.reactiveweb.models.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pokedex.reactiveweb.repository.PokemonRepository;

import java.util.List;

//mapeando a rota princinpal
@RestController
@RequestMapping(value = "/api")
public class PokemonController {
    @Autowired
    private PokemonRepository pokemon;

    public PokemonController(PokemonRepository pokemon){
        this.pokemon = pokemon;
    }

    @GetMapping("/pokemons")
    public List<Pokemon> listPokemons(){
        return pokemon.findAll();
    }

    @GetMapping("/pokemons/{id}")
    public Pokemon seachPokemons(@PathVariable(value = "id") long id){
        return pokemon.findById(id);
    }

    @PostMapping("/pokemons")
    public  Pokemon createPokemon(@RequestBody Pokemon poke){
        return pokemon.save(poke);
    }

    @DeleteMapping("/pokemons/{id}")
    public  void dropPokemon(@PathVariable(value = "id") long id){
        pokemon.deleteById(id);
    }

    @PutMapping("/pokemons")
    public  Pokemon putPolemon(@RequestBody Pokemon poke){
        return  pokemon.save(poke);
    }



}
