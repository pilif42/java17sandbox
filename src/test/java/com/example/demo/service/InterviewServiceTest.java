package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class InterviewServiceTest {
    @InjectMocks
    private InterviewService interviewService;

    @Test
    public void givenNoDuplicates_expectEmptySet() {
        assertTrue(interviewService.getDuplicates(new String[] {"Toyota", "Mercedes", "BMW", "Volkswagen", "Skoda" })
                .isEmpty());
    }

    @Test
    public void givenSomeDuplicates_expectSetContainingTheDuplicatedValues() {
        long start = System.currentTimeMillis();
        Set<String> result = interviewService.getDuplicates(new String[] {"Toyota", "Mercedes", "Toyota", "Volkswagen", "Mercedes" });
        long end = System.currentTimeMillis();
        System.out.println("It took " + (end - start) + " milliseconds.");
        assertThat(result).hasSameElementsAs(Set.of("Toyota", "Mercedes"));
    }
}
