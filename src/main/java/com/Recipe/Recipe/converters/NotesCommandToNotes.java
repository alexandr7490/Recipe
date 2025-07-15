package com.Recipe.Recipe.converters;

import com.Recipe.Recipe.commands.NotesCommand;
import com.Recipe.Recipe.domain.Notes;
import jakarta.annotation.Nullable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {


    @Nullable
    @Override
    synchronized public Notes convert(NotesCommand source) {
        if(source == null) {
            return null;
        }

        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
    }
}
