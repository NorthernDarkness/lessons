package com.mera.training.solid;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LiskovSubstitution {

    class Bird {
        public void fly() {
        }

        public void eat() {
        }
    }

    class Crow extends Bird {
    }

    class Ostrich extends Bird {
        public void fly() {
            throw new UnsupportedOperationException();
        }
    }




    void letTheBirdsFly(List<Bird> birdList) {
        for (Bird b : birdList) {
            b.fly();
        }
    }

//    @Test
//    public void testBird() {
//        List<Bird> birdList = new ArrayList<Bird>();
//        birdList.add(new Bird());
//        birdList.add(new Crow());
//        birdList.add(new Ostrich());
//        letTheBirdsFly(birdList);
//    }
//
//
//
//    class Bird{
//        public void eat(){}
//    }
//    class FlightBird extends Bird{
//        public void fly(){}
//    }
//
//    class NonFlight extends Bird{}
}


