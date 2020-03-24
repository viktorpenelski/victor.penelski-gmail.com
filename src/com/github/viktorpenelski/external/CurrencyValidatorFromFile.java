package com.github.viktorpenelski.external;

import com.github.viktorpenelski.domain.exceptions.InvalidCurrencyException;
import com.github.viktorpenelski.domain.external.CurrencyValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CurrencyValidatorFromFile implements CurrencyValidator {

    private final Path filePath;

    public CurrencyValidatorFromFile(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public void validate(String currency) throws InvalidCurrencyException {
        try {
            Files.lines(filePath)
                    .filter(currency::equals)
                    .findAny()
                    .orElseThrow(InvalidCurrencyException::new);

        } catch (IOException e) {
            throw new InvalidCurrencyException();
        }
    }
}
