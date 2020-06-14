package com.pokedex.reactiveweb.repository;

import com.pokedex.reactiveweb.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    Pokemon findById(long Id);
    Pokemon deleteById(long Id);
}
