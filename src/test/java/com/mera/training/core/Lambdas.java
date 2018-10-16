package com.mera.training.core;

import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BooleanSupplier;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

public class Lambdas {

    @Test
    public void testAnonimousClass() {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("running...");
            }
        }).start();

    }

    @Test
    public void testSimpleLambda() {
        new Thread(() -> System.out.println("running...")).start();
    }

    interface Action {
        int process(int a, int b);
    }

    class Processor {
        int a;
        int b;

        Processor(int a, int b) {
            this.a = a;
            this.b = b;
        }

        int doAction2(Action2 action) {
            return action.process(a, b);
        }

        int doAction(Action action) {
            return action.process(a, b);
        }

        int doActionConditionally(IntBinaryOperator action, Predicate<Integer> predicate) {
            return predicate.test(a) ? action.applyAsInt(a, b) : -1;
        }
    }

    @Test
    public void testCustomInterfaceLambda() {
        final Processor processor = new Processor(1, 2);
        final int i = processor.doAction((a, b) -> a - b);
        System.out.println(i);
    }

    @Test
    public void testFunctionalInterfaceLambda() {
        //$$$$$$$$$
        final Processor processor = new Processor(1, 2);
        final IntBinaryOperator action = (a, b) -> a + b;
        final Predicate<Integer> predicate = a -> a > 5;
        final int i = processor.doActionConditionally(action, predicate);
        System.out.println(i);
    }

    @Test
    public void testScopeLambda() {
        final Processor processor = new Processor(1, 2);
//        final int d = 6;
        int d = 6;
        final int i = processor.doAction((int a, int b) -> d - b);
//        d++;
        System.out.println(i);
    }

    final int f = 6;
    static final int g = 0;

    @Test
    public void testScopeThisLambda() {
        final Processor processor = new Processor(1, 2);
        final int i = processor.doAction((int a, int b) -> this.f - g);
        System.out.println(i);
    }

    public static boolean test(int b) {
        return b > 5;
    }

    @Test
    public void testMethodReference() {
        final Processor processor = new Processor(2, 4);
        final int result = processor.doActionConditionally(this::sum, Lambdas::test);
        System.out.println(result);
    }

    private int sum(int a, int b) {
        return a + b;
    }

    @Test
    public void testMethodReferenceVsLambda() {
        final Processor processor = new Processor(2, 4);
        final int result = processor.doAction2(this::sum);
//        final int result2 = processor.doAction2((int a, int b) -> a + b);
        System.out.println(result);
    }

    public void veryBadExample() {
//        doActionA();
//        sleep(90);
    }

    public void pollAExample() {
        boolean statusReached = false;
        long elapsedTime = 0;
        int i = 0;
        final long timeout = 10000;
        while (elapsedTime < timeout) {
            if (getA() != null) {
                statusReached = true;
                break;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("interation " + ++i);
            }
            elapsedTime += 1000;
        }
        if(statusReached){
            //dosmth
        }
    }

    public void pollBExample() {
        boolean statusReached = false;
        long elapsedTime = 0;
        int i = 0;
        final long timeout = 10000;
        while (elapsedTime < timeout) {
            if (getB() != null) {
                statusReached = true;
                break;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("interation " + ++i);
            }
            elapsedTime += 1000;
        }
        if(statusReached){
            //dosmth
        }
    }

    private String getA() {return null;}
    private String getB() {return null;}

    public static boolean waitFor(BooleanSupplier supplier, long timeout, int iterationTime) throws InterruptedException {
        boolean statusReached = false;
        long elapsedTime = 0;
        int i = 0;
        while (elapsedTime < timeout) {
            if (supplier.getAsBoolean()) {
                statusReached = true;
                break;
            } else {
                Thread.sleep(iterationTime * 1000);
                System.out.println("interation " + ++i);
            }
            elapsedTime += iterationTime;
        }
        return statusReached;
    }


    @Test
    public void testUsage() throws InterruptedException, ExecutionException {
        AtomicBoolean b = new AtomicBoolean(false);
        AtomicInteger i = new AtomicInteger(1);

        //No way to throws exception
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b.set(true);
        });
        executorService.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i.set(5);
        });
        Future<Boolean> future1 = executorService.submit(() -> waitFor(b::get, 10, 1));
        Future<Boolean> future2 = executorService.submit(() -> waitFor(() -> i.get() == 5, 10, 1));
        assert future1.get().booleanValue();
        assert future2.get().booleanValue();
    }

    interface Action2 {
        int process(Integer a, Integer b);
    }


}
