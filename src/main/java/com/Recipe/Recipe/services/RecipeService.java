package com.Recipe.Recipe.services;

import com.Recipe.Recipe.commands.RecipeCommand;
import com.Recipe.Recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Recipe findById(Long l);

    Set<Recipe> getRecipes();

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    Object findCommandById(Long l);

    void deleteById(Long l);

}
