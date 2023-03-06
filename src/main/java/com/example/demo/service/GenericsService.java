package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class GenericsService<T> {
    public Set<T> getDuplicates(T[] input) {
        Set<T> result = new HashSet<>();
        Set<T> temp = new HashSet<>();
        for (T anObject : input) {
            if (!temp.add(anObject)) {
                result.add(anObject);
            }
        }
        return result;
    }
}
