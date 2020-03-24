package com.github.viktorpenelski.domain.external;

import com.github.viktorpenelski.domain.exceptions.InvalidCurrencyException;

public interface CurrencyValidator {

    void validate(String currency) throws InvalidCurrencyException;

}
