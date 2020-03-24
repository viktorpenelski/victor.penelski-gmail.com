package com.github.viktorpenelski.domain.comands;

import com.github.viktorpenelski.domain.entities.Money;
import com.github.viktorpenelski.domain.external.ExchangeService;
import com.github.viktorpenelski.domain.io.Logger;
import com.github.viktorpenelski.domain.repository.ConversionHistoryRepository;

public class HistorySavingConvertCommand extends ConvertCommand {

    private final ConversionHistoryRepository repo;

    public HistorySavingConvertCommand(ExchangeService exchangeService,
                                       Logger logger,
                                       ConversionHistoryRepository repo) {
        super(exchangeService, logger);
        this.repo = repo;
    }

    @Override
    public void execute(Input input) {
        Money converted = exchangeAndLog(input);
        repo.save(input.getFrom(), converted);
    }

}
