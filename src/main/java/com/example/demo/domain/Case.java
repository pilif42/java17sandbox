package com.example.demo.domain;

import lombok.Setter;

import java.util.UUID;

@Setter
public class Case {
    private UUID id;
    private UUID purchaseId;
}
