package com.mera.training.hw;

public class test {

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
