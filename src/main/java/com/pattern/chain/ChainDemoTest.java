package com.pattern.chain;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @date:2020/9/2 22:51
 **/
public class ChainDemoTest {

    @Test
    public void chainTest() {

        Valve1 valve1 = new Valve1();
        Valve2 valve2 = new Valve2();
        List<Valve> valves = new ArrayList<>();
        valves.add(valve1);
        valves.add(valve2);

        SimpleValveChain simpleValveChain = new SimpleValveChain(valves);
        Context context = new Context();
        System.out.println(JSON.toJSONString(context));
        simpleValveChain.doNext(context);
        System.out.println(JSON.toJSONString(context));

    }


    class Context {

        String name;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }

    class Valve1 implements Valve<Context> {

        @Override
        public void handle(Context context, ValveChain chain) {
            context.setAge(18);
            chain.doNext(context);
        }

    }

    class Valve2 implements Valve<Context> {

        @Override
        public void handle(Context context, ValveChain chain) {
            context.setName("张三");
            chain.doNext(context);
        }

    }


}
