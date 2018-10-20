package com.mera.training.patterns;

import org.testng.annotations.Test;

public class FactoryTest {

    @Test
    public void testFactory() {
        Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
        Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");
        System.out.println("Factory PC Config:" + pc);
        System.out.println("Factory Server Config:" + server);
    }


    public static abstract class Computer {
        public abstract String getRAM();

        public abstract String getHDD();

        public abstract String getCPU();

        @Override
        public String toString() {
            return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ", CPU=" + this.getCPU();
        }

        public static class PC extends Computer {

            private String ram;
            private String hdd;
            private String cpu;

            public PC(String ram, String hdd, String cpu) {
                this.ram = ram;
                this.hdd = hdd;
                this.cpu = cpu;
            }

            @Override
            public String getRAM() {
                return this.ram;
            }

            @Override
            public String getHDD() {
                return this.hdd;
            }

            @Override
            public String getCPU() {
                return this.cpu;
            }
        }

        public static class Server extends Computer {

            private String ram;
            private String hdd;
            private String cpu;

            public Server(String ram, String hdd, String cpu) {
                this.ram = ram;
                this.hdd = hdd;
                this.cpu = cpu;
            }

            @Override
            public String getRAM() {
                return this.ram;
            }

            @Override
            public String getHDD() {
                return this.hdd;
            }

            @Override
            public String getCPU() {
                return this.cpu;
            }

        }
    }

    public static class ComputerFactory {

        public static Computer getComputer(String type, String ram, String hdd, String cpu) {
            if ("PC".equalsIgnoreCase(type)) return new Computer.PC(ram, hdd, cpu);
            else if ("Server".equalsIgnoreCase(type)) return new Computer.Server(ram, hdd, cpu);

            return null;
        }
    }

}