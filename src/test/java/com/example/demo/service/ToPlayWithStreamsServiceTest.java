package com.example.demo.service;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ToPlayWithStreamsServiceTest {
    private final ToPlayWithStreamsService classUnderTest = new ToPlayWithStreamsService();

    @Test
    public void given() {
        Set<Integer> result = classUnderTest.getEvenNumbers(List.of(1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 10));
        assertThat(result).hasSameElementsAs(Set.of(2, 4, 6, 8, 10));
    }
}
