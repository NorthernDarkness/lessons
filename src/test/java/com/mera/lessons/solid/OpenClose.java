package com.mera.lessons.solid;

import java.util.Date;

public class OpenClose {

    public class Rectangle{
        public double length;
        public double width;
    }

    public class AreaCalculator{
        public double calculateRectangleArea(Rectangle rectangle){
            return rectangle.length *rectangle.width;
        }
    }













//   public class Circle{
//        public double radius;
//    }


//    public class AreaCalculator{
//        public double calculateRectangleArea(Rectangle rectangle){
//            return rectangle.length *rectangle.width;
//        }
//        public double calculateCircleArea(Circle circle){
//            return (22/7)*circle.radius*circle.radius;
//        }
//    }





    public interface Shape{
        public double calculateArea();
    }

//    public class Rectangle implements Shape{
//        double length;
//        double width;
//        public double calculateArea(){
//            return length * width;
//        }
//    }
//
//    public class Circle implements Shape{
//        public double radius;
//        public double calculateArea(){
//            return Math.PI*radius*radius;
//        }
//    }
}
