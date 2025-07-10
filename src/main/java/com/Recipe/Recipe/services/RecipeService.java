package com.Recipe.Recipe.services;

import com.Recipe.Recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
