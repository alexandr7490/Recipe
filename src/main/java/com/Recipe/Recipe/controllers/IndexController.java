package com.Recipe.Recipe.controllers;

import com.Recipe.Recipe.domain.Category;
import com.Recipe.Recipe.domain.UnitOfMeasure;
import com.Recipe.Recipe.repositories.CategoryRepository;
import com.Recipe.Recipe.repositories.UnitOfMeasureRepository;
import com.Recipe.Recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","index", "/recipes"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());
        return "recipes";
    }
}
