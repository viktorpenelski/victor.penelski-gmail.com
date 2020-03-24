package com.github.viktorpenelski.console;

import com.github.viktorpenelski.domain.io.Logger;

public class ConsoleLogger implements Logger {

    @Override
    public void logLine(String line) {
        System.out.println(line);
    }
}
