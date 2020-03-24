package com.github.viktorpenelski.domain.external;

import com.github.viktorpenelski.domain.entities.Money;

public interface ExchangeService {

    Money exchange(Money from, String toCurrency);

}
