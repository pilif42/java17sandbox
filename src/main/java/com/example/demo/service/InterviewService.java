package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class InterviewService {
    public Set<String> getDuplicates(String[] input) {
        Set<String> result = new HashSet<>();
        Set<String> temp = new HashSet<>();
        for (String aString : input) {
            if (!temp.add(aString)) {
                result.add(aString);
            }
        }
        return result;
    }
}
