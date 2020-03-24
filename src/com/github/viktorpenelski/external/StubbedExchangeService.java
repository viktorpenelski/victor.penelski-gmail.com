package com.github.viktorpenelski.external;

import com.github.viktorpenelski.domain.entities.Money;
import com.github.viktorpenelski.domain.external.ExchangeService;

import java.math.BigDecimal;

public class StubbedExchangeService implements ExchangeService {

    @Override
    public Money exchange(Money from, String toCurrency) {
        return new Money(BigDecimal.ONE, "USD");
    }
}
