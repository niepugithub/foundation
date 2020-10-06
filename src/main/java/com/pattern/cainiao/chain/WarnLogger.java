package com.pattern.cainiao.chain;

/**
 * @date:2020/10/6 15:07
 **/
public class WarnLogger extends AbstractLogger {

    public WarnLogger(int level) {
        super(level);
    }

    @Override
    protected void write(String msg) {
        System.out.println("warn-----logger-----" + msg);
    }

}
