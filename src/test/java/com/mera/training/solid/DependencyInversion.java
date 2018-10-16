package com.mera.training.solid;

public class DependencyInversion {

    class Worker {
        public void work() {
            // ....working
        }
    }

    class Manager {
        Worker worker;

        public void setWorker(Worker w) {
            worker = w;
        }

        public void manage() {
            worker.work();
        }
    }

    class HardWorker {
        public void work() {
            //.... working hard
        }
    }








//    interface IWorker {
//        public void work();
//    }
//
//    class Worker implements IWorker{
//        public void work() {
//            // ....working
//        }
//    }
//
//    class HardWorker  implements IWorker{
//        public void work() {
//            //.... working hard
//        }
//    }
//
//    class Manager {
//        IWorker worker;
//
//        public void setWorker(IWorker w) {
//            worker = w;
//        }
//
//        public void manage() {
//            worker.work();
//        }
//    }

}


