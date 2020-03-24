package com.github.viktorpenelski.domain.comands;

import com.github.viktorpenelski.domain.external.CurrencyValidator;
import com.github.viktorpenelski.domain.external.ExchangeService;
import com.github.viktorpenelski.domain.io.Logger;
import com.github.viktorpenelski.domain.repository.ConversionHistoryRepository;

public class ValidatedHistorySavingConvertCommand extends HistorySavingConvertCommand {

    private CurrencyValidator validator;

    public ValidatedHistorySavingConvertCommand(ExchangeService exchangeService,
                                                Logger logger,
                                                ConversionHistoryRepository repo,
                                                CurrencyValidator validator) {
        super(exchangeService, logger, repo);
        this.validator = validator;
    }

    @Override
    public void execute(Input input) {
        validator.validate(input.getFrom().getCurrency());
        validator.validate(input.getToCurrency());
        super.execute(input);
    }
}
