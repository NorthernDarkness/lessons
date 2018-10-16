package com.mera.training.solid;

import java.util.Date;

public class SingleResponsibility {

    class Employee {
        private String employeeId;
        private String name;
        private String address;
        private Date dateOfJoining;

        public boolean isPromotionDueThisYear() {
            //promotion logic implementation
            return true;
        }

        public Double calcIncomeTaxForCurrentYear() {
            //income tax  logic implementation
            return 0.0;
        }
        //Getters & Setters for all the private attributes
    }








    public class HRPromotions{
        public boolean isPromotionDueThisYear(Employee emp){
            //promotion logic implementation using the employee information passed
            return true;
        }
    }

    public class FinITCalculations{
        public Double calcIncomeTaxForCurrentYear(Employee emp){
            //income tax logic implementation using the employee information passed
            return 0.0;
        }
    }
}
