package com.pattern.chain;

import java.util.List;

/**
 * @date:2020/9/2 22:47
 **/
public class BaseValveChain<V> {

    List<V> valves;
    int index;

    public List<V> getValves() {
        return valves;
    }

    public BaseValveChain(List<V> valves) {
        this.valves = valves;
    }

}
