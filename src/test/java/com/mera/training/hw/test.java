package com.mera.training.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

    public static void main(String[] args) {
        System.out.print("First sequense: \n");
        System.out.print(test("System Configuration: \n Blades: 0-0 | 0-26 | 0-1 | 0-28 | 0-25 | 1-0 | 1-25 \n"));
        System.out.print("\n\nSecond sequense: \n");
        System.out.print(test("System Configuration: \n Blades: \n"));
    }

    private static List<String> test(String testString){
        List<String> result = new ArrayList<String>();
        Pattern p = Pattern.compile("(\\d-\\d{1,})");
        Matcher m = p.matcher(testString);

        while(m.find()){
            result.add(m.group());
        }
        System.out.print("Size of sequense: " + result.size() + "\n");
        return result;
    }


    enum Bridge{
        BRIDGE_0_1(0,1),
        BRIDGE_0_25(0,25),
        BRIDGE_0_26(0,26),
        BRIDGE_0_28(0,28),
        BRIDGE_1_1(1,1),
        BRIDGE_1_25(1,25),
        BRIDGE_1_26(1,26),
        BRIDGE_1_28(1,28);

        private final int shelf;
        private final int slot;

        Bridge(int shelf, int slot){
            this.shelf = shelf;
            this.slot = slot;
        }

        public int getShelf() {
            return shelf;
        }

        public int getSlot() {
            return slot;
        }
    }
}
