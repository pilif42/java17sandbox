package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter @EqualsAndHashCode @AllArgsConstructor
public class Purchase {
    private UUID id;
    private double amount;
    private LocalDateTime time;
}
