package com.pattern.cainiao.chain;

import org.junit.Test;

/**
 * @date:2020/10/6 15:08
 **/
public class ChainPatternDemo {

    @Test
    public void test1() {
        LoggerPipeline pipeline = new LoggerPipeline();
        ErrorLogger errorLogger = new ErrorLogger(0);
        WarnLogger warnLogger = new WarnLogger(1);
        InfoLogger infoLogger = new InfoLogger(2);

        pipeline.setFirst(errorLogger);
        errorLogger.setNextLogger(warnLogger);
        warnLogger.setNextLogger(infoLogger);

        pipeline.write("0级日志，只有errorlogger能输出", 0);
        System.out.println("-------------------------");
        pipeline.write("1级日志，只有error和warn能输出", 1);
        System.out.println("-------------------------");
        pipeline.write("2级日志，error和warn和info都能输出", 2);

    }

    @Test
    public void test2() {
        LoggerPipeline pipeline = new LoggerPipeline();
        ErrorLogger errorLogger = new ErrorLogger(0);
        WarnLogger warnLogger = new WarnLogger(1);
        InfoLogger infoLogger = new InfoLogger(2);

        pipeline.addLogger(errorLogger);
        pipeline.addLogger(warnLogger);
        pipeline.addLogger(infoLogger);

        pipeline.write("0级日志，只有errorlogger能输出", 0);
        System.out.println("-------------------------");
        pipeline.write("1级日志，只有error和warn能输出", 1);
        System.out.println("-------------------------");
        pipeline.write("2级日志，error和warn和info都能输出", 2);
    }

}
