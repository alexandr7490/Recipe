package com.Recipe.Recipe.bootstrap;

import com.Recipe.Recipe.domain.*;
import com.Recipe.Recipe.repositories.CategoryRepository;
import com.Recipe.Recipe.repositories.RecipeRepository;
import com.Recipe.Recipe.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found!");
        }
        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if(!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found!");
        }
        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if(!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found!");
        }
        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
        if(!dashUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found!");
        }
        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
        if(!pintUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found!");
        }
        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
        if(!cupUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found!");
        }

        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found!");
        }
        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found!");
        }

        Category american = americanCategoryOptional.get();
        Category mexican = mexicanCategoryOptional.get();

        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("the Best Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1) Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl. \n" +
                "2)  Mash the avocado flesh:\n" +
                "\n" +
                "Using a fork, roughly mash the avocado. Don't overdo it! The guacamole should be a little chunky. \n" +
                "3)  Add the remaining ingredients to taste:\n" +
                "\n" +
                "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chilis. Chili peppers vary individually in their spiciness. So, start with a half of one chili pepper and add more to the guacamole to your desired degree of heat.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste. \n" +
                "4)  Serve immediately:\n" +
                "\n" +
                "If making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.)\n" +
                "\n" +
                "Garnish with slices of red radish or jicama strips. Serve with your choice of store-bought tortilla chips or make your own homemade tortilla chips.\n" +
                "\n" +
                "Refrigerate leftover guacamole up to 3 days. ");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("Chilling tomatoes dulls their flavor. So, if you want to add chopped tomato to your guacamole, add just before serving.");
        guacRecipe.setNotes(guacNotes);
        guacRecipe.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), eachUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("salt", new BigDecimal("0.5"), tableSpoonUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("lemon juice", new BigDecimal(2), teaSpoonUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("minced red onion", new BigDecimal(2), tableSpoonUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("chiles", new BigDecimal(2), eachUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Cilatro", new BigDecimal(2), tableSpoonUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("black pepper", new BigDecimal(2), dashUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("chopped tomato", new BigDecimal("0.5"), eachUom,guacRecipe));

        guacRecipe.getCategories().add(american);
        guacRecipe.getCategories().add(mexican);

        recipes.add(guacRecipe);

        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Buffalo Chicken Tacos");
        tacosRecipe.setPrepTime(15);
        tacosRecipe.setCookTime(2);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);
        tacosRecipe.setDirections("1) Make the Buffalo chicken:" +
                "\n" +
                "    Microwave the butter in a large microwave-safe bowl in 4 to 6 (10-second) bursts until just melted. Add the hot sauce and garlic powder and whisk until combined. Add the shredded chicken and toss to coat." +
                "\n" +
                "    Alternatively, melt the butter in a small saucepan over medium-low heat. Turn off the heat and add the hot sauce and garlic powder, then transfer to a large bowl and combine with the chicken." +
                "    Bowl of Buffalo Sauce and Melted Butter Whisked Together for Buffalo Taco Recipe" +
                "\n" +
                "2) Make the coleslaw:\n" +
                "\n" +
                "    Place the Greek yogurt or sour cream, lime juice, olive oil, salt, and pepper in a large bowl and whisk to combine. Add the coleslaw mix and toss to coat. " +
                "3)   Warm the tortillas:" +
                "\n" +
                "Stack the tortillas on a microwave-safe plate and cover with a damp paper towel. Microwave until warm, 30 to 45 seconds. Wrap the stack in a clean kitchen towel or aluminum foil to keep warm until ready to use. " +
                "4)   Assemble the tacos:" +
                "\n" +
                "To assemble the tacos, top the warmed tortillas with coleslaw. Top with the buffalo chicken and garnish with the scallions and blue cheese.");

        Notes tacosNotes = new Notes();
        tacosNotes.setRecipeNotes("Love the recipe? Leave us stars and a comment below!");
        tacosRecipe.setNotes(tacosNotes);
        tacosRecipe.getIngredients().add(new Ingredient("Chile powder", new BigDecimal(2), tableSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Dried Oregano", new BigDecimal(1), teaSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Dried Cumin", new BigDecimal(1), teaSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("sugar", new BigDecimal(1), teaSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("salt", new BigDecimal(".5"), teaSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("chopped garlic", new BigDecimal(1), eachUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("orange", new BigDecimal(1), tableSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("orange juice", new BigDecimal(3), tableSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("olive oil", new BigDecimal(2), tableSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Chicken thighs", new BigDecimal(4), tableSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("tortillas", new BigDecimal(8), eachUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("arugula", new BigDecimal(3), cupUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("avocados", new BigDecimal(2), eachUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Tomatoes halved", new BigDecimal("0.5"), eachUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("red onion sliced", new BigDecimal("0.25"), pintUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("chopped cilantro", new BigDecimal(4), eachUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("sour cream", new BigDecimal(4), cupUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("lime", new BigDecimal(4), cupUom, tacosRecipe));

        tacosRecipe.getCategories().add(mexican);

        recipes.add(tacosRecipe);

        return recipes;
    }

}
