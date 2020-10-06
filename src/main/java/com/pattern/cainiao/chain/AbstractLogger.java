package com.pattern.cainiao.chain;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @date:2020/10/6 15:02
 **/
public abstract class AbstractLogger {

    @Setter
    @Getter
    private AbstractLogger nextLogger;
    protected int level;

    public AbstractLogger(int level) {
        this.level = level;
    }

    public void write(String msg, int level) {
        if (this.level <= level) {
            write(msg);
        }
        if (Objects.nonNull(this.getNextLogger())) {
            this.getNextLogger().write(msg, level);
        }
    }

    protected abstract void write(String msg);

}
