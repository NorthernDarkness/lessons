package com.mera.training.patterns;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FactoryTest {

    enum Body {
        WAGON,
        SEDAN,
        COUPE,
        HACTHBACK,
        SUV,
        MINIVAN;
    }

    abstract static class Car {

        Body body;
        int enginePower;
        int maxVelocity;
        int trunkVolume;

        Car(Body body, int enginePower, int maxVelocity, int trunkVolume) {
            this.body = body;
            this.enginePower = enginePower;
            this.maxVelocity = maxVelocity;
            this.trunkVolume = trunkVolume;
        }

        abstract void drive();
    }

    static class Wagon extends Car {

        Wagon(int enginePower, int maxVelocity, int trunkVolume) {
            super(Body.WAGON, enginePower, maxVelocity, trunkVolume);
        }

        @Override
        void drive() {
            System.out.println("Carry a lot of stuff");
        }
    }

    static class Coupe extends Car {

        Coupe(int enginePower, int maxVelocity, int trunkVolume) {
            super(Body.COUPE, enginePower, maxVelocity, trunkVolume);
        }

        @Override
        void drive() {
            System.out.println("Very fast");
        }
    }

    static class Suv extends Car {

        Suv(int enginePower, int maxVelocity, int trunkVolume) {
            super(Body.SUV, enginePower, maxVelocity, trunkVolume);
        }

        @Override
        void drive() {
            System.out.println("No roads needed");
        }
    }

    public static class CarFactory {

        public static Car getCar(Body body) {
            Car result;
            switch (body) {
                case SUV:
                    result = new Suv(200, 200, 500);
                    break;
                case WAGON:
                    result = new Wagon(150, 250, 800);
                    break;
                case COUPE:
                    result = new Coupe(350, 400, 100);
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported body type");
            }
            return result;
        }
    }

    @Test
    public void testFactory() {
        final List<Body> bodies = Arrays.asList(Body.SUV, Body.COUPE, Body.WAGON);
        final List<Car> garage = bodies.stream().map(CarFactory::getCar).collect(Collectors.toList());
        garage.forEach(Car::drive);
    }
}
