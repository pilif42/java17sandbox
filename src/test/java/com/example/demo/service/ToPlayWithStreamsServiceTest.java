package com.example.demo.service;

import com.example.demo.domain.Purchase;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ToPlayWithStreamsServiceTest {
    private final ToPlayWithStreamsService classUnderTest = new ToPlayWithStreamsService();

    @Test
    public void givenListWithSomeEvenNbs_expectSetOfAllEvenNbs() {
        Set<Integer> result = classUnderTest.getEvenNumbers(List.of(1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 10));
        assertThat(result).hasSameElementsAs(Set.of(2, 4, 6, 8, 10));
    }

    @Test
    public void givenListWithSomePurchases_expectSetOfAllSpecialPurchases() {
        Purchase smallPurchase = new Purchase(UUID.randomUUID(), 10d, LocalDateTime.MAX);
        Purchase specialPurchaseOne = new Purchase(UUID.randomUUID(), 101d, LocalDateTime.of(2023, Month.FEBRUARY, 20, 07, 30));
        Purchase amountThresholdPurchase = new Purchase(UUID.randomUUID(), 100d, LocalDateTime.MAX);
        Purchase tooOldPurchase = new Purchase(UUID.randomUUID(), 101d, LocalDateTime.of(2023, Month.FEBRUARY, 20, 05, 30));
        Purchase specialPurchaseTwo = new Purchase(UUID.randomUUID(), 1001d, LocalDateTime.of(2023, Month.FEBRUARY, 21, 07, 30));

        Set<Purchase> result = classUnderTest.getSpecialPurchases(List.of(smallPurchase, specialPurchaseOne, amountThresholdPurchase, tooOldPurchase, specialPurchaseTwo));
        assertThat(result).hasSameElementsAs(Set.of(specialPurchaseOne, specialPurchaseTwo));
    }
}
