package com.mera.lessons.coupligcohesion;

public class Coupling {

    class Driver {
        void drive(){
            System.out.println(new Car().engine);
        }
    }

    class Car {
        String engine;
        void drive(){};
    }


}
