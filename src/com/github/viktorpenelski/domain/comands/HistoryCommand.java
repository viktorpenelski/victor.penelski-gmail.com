package com.github.viktorpenelski.domain.comands;

import com.github.viktorpenelski.domain.io.Logger;
import com.github.viktorpenelski.domain.repository.ConversionHistoryRepository;

import java.util.List;

public class HistoryCommand implements Command<HistoryCommand.Input> {

    private final ConversionHistoryRepository repo;
    private Logger logger;

    public HistoryCommand(ConversionHistoryRepository repo,
                          Logger logger) {
        this.repo = repo;
        this.logger = logger;
    }

    @Override
    public void execute(Input input) {
        List<String> lastNConversions = repo.getLast(input.getNumberToShow());
        lastNConversions.forEach(cmd -> logger.logLine(cmd));
    }

    public static class Input extends EmptyInput {
        private final int numberToShow;

        public Input(int numberToShow) {
            if (numberToShow < 1) {
                throw new IllegalArgumentException("input must be a positive integer!");
            }
            this.numberToShow = numberToShow;
        }

        public int getNumberToShow() {
            return numberToShow;
        }
    }

}
