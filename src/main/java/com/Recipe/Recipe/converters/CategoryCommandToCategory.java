package com.Recipe.Recipe.converters;

import com.Recipe.Recipe.commands.CategoryCommand;
import com.Recipe.Recipe.domain.Category;
import jakarta.annotation.Nullable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Nullable
    @Override
    synchronized public Category convert(CategoryCommand source) {
        if (source == null) {
            return null;
        }

        final Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}
