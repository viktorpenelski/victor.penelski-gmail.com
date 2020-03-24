package com.github.viktorpenelski.domain.repository;

import com.github.viktorpenelski.domain.entities.Money;

import java.util.List;

public interface ConversionHistoryRepository {

    List<String> getLast(int n);

    void save(Money from, Money to);
}
