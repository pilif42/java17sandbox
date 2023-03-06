package com.example.demo.service;

import com.example.demo.domain.Case;
import com.example.demo.domain.Purchase;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ToPlayWithStreamsService {
    private static final double AMOUNT_THRESHOLD = 100d;
    private static final LocalDateTime TIME_THRESHOLD = LocalDateTime.of(2023, Month.FEBRUARY, 20, 06, 30);

    private static final Predicate<Purchase> SAMPLE_PREDICATE = purchase -> {
        boolean amountBoolean = purchase.getAmount() > AMOUNT_THRESHOLD;
        boolean timeBoolean = purchase.getTime().isAfter(TIME_THRESHOLD);
        return amountBoolean && timeBoolean;
    };

    private static final Function<Purchase, Case> CONVERTER = ToPlayWithStreamsService::mapToCase;

    private static Case mapToCase(Purchase purchase) {
        Case result = new Case();
        result.setId(UUID.randomUUID());
        result.setPurchaseId(purchase.getId());
        return result;
    }

    public Set<Integer> getEvenNumbers(List<Integer> input) {
        return input.stream().filter(Objects::nonNull).filter(i -> i % 2 == 0).collect(Collectors.toSet());
    }

    public Set<Purchase> getSpecialPurchases(List<Purchase> input) {
        return input.stream().filter(Objects::nonNull).filter(SAMPLE_PREDICATE).collect(Collectors.toSet());
    }

    public Set<Case> getCases(List<Purchase> input) {
        return input.stream().filter(Objects::nonNull).map(CONVERTER).collect(Collectors.toSet());
    }
}
