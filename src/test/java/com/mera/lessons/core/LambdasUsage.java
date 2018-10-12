package com.mera.lessons.core;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.function.Function;

public class LambdasUsage {

    public void compare(Metric m1, Metric m2) {
        String oilTemperature = Objects.equals(m1.getOilTemperature(), m2.getOilTemperature()) ? m1.getOilTemperature() : "Unexpected value";
        String airConsumption = Objects.equals(m1.getAirConsumption(), m2.getAirConsumption()) ? m1.getAirEnrichment() : "Unexpected value";
        String ignitionDwellAngle = Objects.equals(m1.getIgnitionDwellAngle(), m2.getIgnitionDwellAngle()) ? m1.getIgnitionDwellAngle() : "Unexpected value";
        String chainTensioner = Objects.equals(m1.getChainTensioner(), m2.getChainTensioner()) ? m1.getChainTensioner() : "Unexpected value";
        String sparkMisses = Objects.equals(m1.getSparkMisses(), m2.getSparkMisses()) ? m1.getSparkMisses() : "Unexpected value";
        String airEnrichment = Objects.equals(m1.getAirEnrichment(), m2.getAirConsumption()) ? m1.getAirEnrichment() : "Unexpected value";
        String voltage = Objects.equals(m1.getVoltage(), m2.getVoltage()) ? m1.getVoltage() : "Unexpected value";
        String current = Objects.equals(m1.getCurrent(), m1.getCurrent()) ? m1.getCurrent() : "Unexpected value";
        String power = Objects.equals(m1.getPower(), m2.getPower()) ? m1.getPower() : "Unexpected value";
    }

    public void compare1(Metric m1, Metric m2) {
        Function<Function<Metric, String>, String> folder = g -> Objects.equals(g.apply(m1), g.apply(m2)) ? g.apply(m1) : "Unexpected value";

        String oilTemperature = folder.apply(Metric::getOilTemperature);
        String airConsumption = folder.apply(Metric::getAirConsumption);
        String ignitionDwellAngle = folder.apply(Metric::getIgnitionDwellAngle);
        String chainTensioner = folder.apply(Metric::getChainTensioner);
        String sparkMisses = folder.apply(Metric::getSparkMisses);
        String airEnrichment = folder.apply(Metric::getAirEnrichment);
        String voltage = folder.apply(Metric::getVoltage);
        String current = folder.apply(Metric::getCurrent);
        String power = folder.apply(Metric::getPower);
    }


    @Getter
    @Setter
    class Metric {
        String oilTemperature;
        String airConsumption;
        String ignitionDwellAngle;
        String chainTensioner;
        String sparkMisses;
        String airEnrichment;
        String voltage;
        String current;
        String power;
    }
}
