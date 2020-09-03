package com.pattern.chain;

/**
 * @date:2020/9/2 22:46
 **/
public interface Valve<Context> {

    void handle(Context context, ValveChain chain);

}
