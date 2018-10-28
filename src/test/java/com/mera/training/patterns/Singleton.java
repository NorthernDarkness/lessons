package com.mera.training.patterns;

import org.testng.Assert;
import org.testng.annotations.Test;

class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        Assert.assertTrue(getInstance() == getInstance());
    }

}
