package com.Recipe.Recipe.services;

import com.Recipe.Recipe.commands.UnitOfMeasureCommand;
import com.Recipe.Recipe.domain.UnitOfMeasure;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
