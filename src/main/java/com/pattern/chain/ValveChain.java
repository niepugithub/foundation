package com.pattern.chain;

/**
 * @date:2020/9/2 22:47
 **/
public interface ValveChain<Context> {

    void doNext(Context context);

}
