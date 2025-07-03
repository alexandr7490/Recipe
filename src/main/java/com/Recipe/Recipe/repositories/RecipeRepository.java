package com.Recipe.Recipe.repositories;

import com.Recipe.Recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
