package com.example.demo.service;

import com.example.demo.domain.Purchase;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ToPlayWithStreamsService {
    private static final double AMOUNT_THRESHOLD = 100d;
    private static final LocalDateTime TIME_THRESHOLD = LocalDateTime.of(2023, Month.FEBRUARY, 20, 06, 30);

    public Set<Integer> getEvenNumbers(List<Integer> input) {
        return input.stream().filter(Objects::nonNull).filter(i -> i % 2 == 0).collect(Collectors.toSet());
    }

    public Set<Purchase> getSpecialPurchases(List<Purchase> input) {
        Predicate<Purchase> samplePredicate = purchase -> {
            boolean amountBoolean = purchase.getAmount() > AMOUNT_THRESHOLD;
            boolean timeBoolean = purchase.getTime().isAfter(TIME_THRESHOLD);
            return amountBoolean && timeBoolean;
        };
        return input.stream().filter(Objects::nonNull).filter(samplePredicate).collect(Collectors.toSet());
    }

    // TODO 1 with a Mapper
}
