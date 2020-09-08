package com.vytrack.step_definitions.ConfigPojo;

import com.vytrack.Student;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

import java.util.Locale;
import java.util.Map;

public class Configurer implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(Student.class, new TableEntryTransformer<Student>() {
            @Override
            public Student transform(Map<String, String> entry) {
                return new Student(entry.get("name"), entry.get("age"), entry.get("batch"));
            }
        }));
    }

}
