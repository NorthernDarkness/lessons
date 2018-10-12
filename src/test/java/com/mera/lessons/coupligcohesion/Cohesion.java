package com.mera.lessons.coupligcohesion;

import com.mera.lessons.solid.Test;

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
