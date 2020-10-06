package com.pattern.cainiao.chain;

import lombok.Setter;

import java.util.Objects;

/**
 * @date:2020/10/6 15:09
 **/
public class LoggerPipeline {

    @Setter
    private AbstractLogger first;

    public void write(String msg, int level) {
        this.first.write(msg, level);
    }

    public void addLogger(AbstractLogger logger) {
        if (Objects.isNull(first)) {
            first = logger;
        } else {
            AbstractLogger next = first;
            while (Objects.nonNull(next.getNextLogger())) {
                next = next.getNextLogger();
            }
            next.setNextLogger(logger);
        }
    }

}
