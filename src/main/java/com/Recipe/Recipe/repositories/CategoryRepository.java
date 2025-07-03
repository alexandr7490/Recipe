package com.Recipe.Recipe.repositories;

import com.Recipe.Recipe.domain.Category;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Id> {
}
