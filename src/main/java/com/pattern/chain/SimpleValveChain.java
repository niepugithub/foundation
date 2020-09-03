package com.pattern.chain;

import java.util.List;

/**
 * @date:2020/9/2 22:46
 **/
public class SimpleValveChain<Context, V extends Valve>
        extends BaseValveChain<V> implements ValveChain<Context> {

    public SimpleValveChain(List<V> valves) {
        super(valves);
    }

    @Override
    public void doNext(Context context) {
        if (index < getValves().size()) {
            getValves().get(index++).handle(context, this);
        }
    }

}
