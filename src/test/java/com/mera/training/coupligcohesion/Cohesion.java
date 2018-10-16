package com.mera.training.coupligcohesion;

public class Cohesion {

    class Cafe {
        Employee employee;
    }

    class Employee {
        void cook() {
        }

        void delover() {
        }

        void clean() {
        }
    }





















//    class Cafe {
//        Waiter waiter;
//        Janitor janitor;
//        Cook cook;
//    }
//
//    class Waiter {
//        void delover() {
//        }
//    }
//
//    class Janitor {
//        void clean() {
//        }
//    }
//
//    class Cook {
//        void cook() {
//        }
//    }
}
