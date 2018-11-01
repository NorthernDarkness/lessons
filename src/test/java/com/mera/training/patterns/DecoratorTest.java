package com.mera.training.patterns;

import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.function.Consumer;

public class DecoratorTest {

    interface Pizza {
        public String make();
    }

    class Base implements Pizza {
        @Override
        public String make() {
            return "dough";
        }
    }

    abstract class PizzaDecorator implements Pizza {
        protected Pizza pizza;

        public PizzaDecorator(Pizza pizza) {
            this.pizza = pizza;
        }

        @Override
        public String make() {
            return pizza.make();
        }
    }

    public class CheeseDecorator extends PizzaDecorator {

        public CheeseDecorator(Pizza pizza) {
            super(pizza);
        }

        @Override
        public String make() {
            return pizza.make() + " + cheese ";
        }
    }

    public class MushroomDecorator extends PizzaDecorator {

        public MushroomDecorator(Pizza pizza) {
            super(pizza);
        }

        @Override
        public String make() {
            return pizza.make() + " + mushrooms ";
        }
    }

    public class MeetDecorator extends PizzaDecorator {

        public MeetDecorator(Pizza pizza) {
            super(pizza);
        }

        @Override
        public String make() {
            return pizza.make() + " + meat ";
        }
    }

    public class TomatoDecorator extends PizzaDecorator {

        public TomatoDecorator(Pizza pizza) {
            super(pizza);
        }

        @Override
        public String make() {
            return pizza.make() + " + tomato ";
        }
    }

    @Test
    public void test(){
        final String pizza = new MeetDecorator(new TomatoDecorator(new CheeseDecorator(new Base()))).make();
        System.out.println(pizza);
    }
}
