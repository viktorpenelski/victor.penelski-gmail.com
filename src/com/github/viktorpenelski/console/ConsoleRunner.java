package com.github.viktorpenelski.console;

import com.github.viktorpenelski.domain.external.CurrencyValidator;
import com.github.viktorpenelski.domain.external.ExchangeService;
import com.github.viktorpenelski.domain.io.Logger;
import com.github.viktorpenelski.domain.repository.ConversionHistoryRepository;
import com.github.viktorpenelski.external.CurrConvExchangeService;
import com.github.viktorpenelski.external.CurrencyValidatorFromFile;
import com.github.viktorpenelski.repository.InMemoryConversionHistoryRepository;

import java.nio.file.Path;
import java.util.Scanner;

public class ConsoleRunner {


    public void run() {

        Scanner scanner = new Scanner(System.in);
        ExchangeService exchangeService = new CurrConvExchangeService();
        Logger logger = new ConsoleLogger();
        ConversionHistoryRepository conversionHistoryRepo = new InMemoryConversionHistoryRepository();
        CurrencyValidator currencyValidator = new CurrencyValidatorFromFile(Path.of("E:\\currencies.txt"));

        ConsoleCommandExecutor executor = new ConsoleCommandExecutor(
                conversionHistoryRepo,
                logger,
                exchangeService,
                currencyValidator
        );

        while (true) {
            String line = scanner.nextLine();
            String[] split = line.split("\\s+");
            executor.execute(split);
        }
    }


}
