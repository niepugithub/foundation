package com.pattern.cainiao.chain;

/**
 * @date:2020/10/6 15:07
 **/
public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level) {
        super(level);
    }

    @Override
    protected void write(String msg) {
        System.out.println("info-----logger-----" + msg);
    }

}
