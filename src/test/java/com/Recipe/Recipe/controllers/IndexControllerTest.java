package com.Recipe.Recipe.controllers;

import com.Recipe.Recipe.domain.Recipe;
import com.Recipe.Recipe.repositories.RecipeRepository;
import com.Recipe.Recipe.services.RecipeService;
import com.Recipe.Recipe.services.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IndexControllerTest {

    @Mock
    private RecipeService mockRecipeService;

    @Mock
    private Model mockModel;

    @InjectMocks
    IndexController indexController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testMockMVC() throws Exception{
        MockMvc mockMVC = MockMvcBuilders.standaloneSetup(indexController).build();
        mockMVC.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    void getIndexPage() {
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();

        recipes.add(recipe1);
        recipes.add(recipe2);

        when(mockRecipeService.getRecipes()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        String viewName = indexController.getIndexPage(mockModel);
        assertEquals("index", viewName);
        verify(mockRecipeService, times(1)).getRecipes();
        //verify(mockModel, times(1)).addAttribute(eq("recipes"), anySet());//Works
        verify(mockModel, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());

        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2,setInController.size());


    }
}

