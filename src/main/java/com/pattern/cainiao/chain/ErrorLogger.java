package com.pattern.cainiao.chain;

/**
 * @date:2020/10/6 15:06
 **/
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        super(level);
    }

    @Override
    protected void write(String msg) {
        System.out.println("error-----logger-----" + msg);
    }

}
