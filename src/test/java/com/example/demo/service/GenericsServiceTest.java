package com.example.demo.service;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenericsServiceTest {
    @Test
    public void givenArrayOfStringsWithNoDuplicates_expectEmptySet() {
        GenericsService<String> genericsService = new GenericsService<>();
        assertTrue(genericsService.getDuplicates(new String[] {"Toyota", "Mercedes", "BMW", "Volkswagen", "Skoda" })
                .isEmpty());
    }

    @Test
    public void givenArrayOfStringsWithSomeDuplicates_expectSetContainingTheDuplicatedValues() {
        GenericsService<String> genericsService = new GenericsService<>();
        long start = System.currentTimeMillis();
        Set<String> result = genericsService.getDuplicates(new String[] {"Toyota", "Mercedes", "Toyota", "Volkswagen", "Mercedes" });
        long end = System.currentTimeMillis();
        System.out.println("It took " + (end - start) + " milliseconds.");
        assertThat(result).hasSameElementsAs(Set.of("Toyota", "Mercedes"));
    }
}
