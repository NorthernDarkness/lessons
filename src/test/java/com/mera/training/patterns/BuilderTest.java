package com.mera.training.patterns;

import org.testng.annotations.Test;

public class BuilderTest {

    @Test
    public void testBuilder() {
        Person person = new Person.Builder("Name", "Surname")
                .setAddress("Cityname")
                .setAge(35)
                .build();
    }

    static class Person {
        String name;
        String surname;
        int age;
        String address;

        private Person(Builder builder) {
            this.name = builder.name;
            this.surname = builder.surname;
            this.address = builder.address;
            this.age = builder.age;
        }

        static class Builder {
            String name;
            String surname;
            int age = 18;
            String address = "";

            Builder(String name, String surname) {
                this.name = name;
                this.surname = surname;
            }

            public Builder setAge(int age) {
                this.age = age;
                return this;
            }

            public Builder setAddress(String address) {
                this.address = address;
                return this;
            }

            public Person build() {
                return new Person(this);
            }
        }
    }
}
