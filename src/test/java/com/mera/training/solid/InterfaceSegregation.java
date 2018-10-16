package com.mera.training.solid;

public class InterfaceSegregation {
    interface IWorker {
        public void work();
        public void eat();
    }

    class Worker implements IWorker{
        public void work() {
            // ....working
        }
        public void eat() {
            // ...... eating in launch break
        }
    }

    class Robot implements IWorker{
        public void work() {
            //.... working much more
        }

        public void eat() {
            //.... do nothing
        }
    }




//    interface IWorker extends Feedable, Workable {
//    }
//
//    interface IWorkable {
//        public void work();
//    }
//
//    interface IFeedable{
//        public void eat();
//    }
//
//    class Worker implements IWorkable, IFeedable{
//        public void work() {
//            // ....working
//        }
//
//        public void eat() {
//            //.... eating in launch break
//        }
//    }
//
//    class Robot implements IWorkable{
//        public void work() {
//            // ....working
//        }
//    }
}


