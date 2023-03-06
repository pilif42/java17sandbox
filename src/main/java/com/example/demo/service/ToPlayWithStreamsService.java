package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ToPlayWithStreamsService {
    public Set<Integer> getEvenNumbers(List<Integer> input) {
        return input.stream().filter(Objects::nonNull).filter(i -> i % 2 == 0).collect(Collectors.toSet());
    }
}
