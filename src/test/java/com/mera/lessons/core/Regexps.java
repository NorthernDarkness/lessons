package com.mera.lessons.core;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexps {

    @Test
    public void testSimpleRegexp() {
        Pattern pattern = Pattern.compile("[A-Za-z]-[0-9]");
        System.out.println(pattern.matcher("As-9").matches());
        System.out.println(pattern.matcher("Bd-2").matches());
        System.out.println(pattern.matcher("TT-7").matches());
        System.out.println(pattern.matcher("Gh-89").matches());
    }

    @Test
    public void testStringMathches() {
        System.out.println("As-9".matches("[A-Za-z]-[0-9]"));
        System.out.println("Bd-2".matches("[A-Za-z]-[0-9]"));
        System.out.println("TT-7".matches("[A-Za-z]-[0-9]"));
        System.out.println("Gh-89".matches("[A-Za-z]-[0-9]"));
    }

    @Test
    public void testSimpleClasses() {
        Pattern pattern = Pattern.compile("\\w\\s-\\d");
        System.out.println(pattern.matcher("A -9").matches());
        System.out.println(pattern.matcher("B\n-2").matches());
        System.out.println(pattern.matcher("d\t-7").matches());
        System.out.println(pattern.matcher("_ -1").matches());
        System.out.println(pattern.matcher("9 -1").matches());
        System.out.println(pattern.matcher("BB -1").matches());
        System.out.println(pattern.matcher("& -1").matches());
    }

    @Test
    public void testDot() {
        Pattern pattern = Pattern.compile(".*");
//        Pattern pattern = Pattern.compile("(?s).*");
        System.out.println(pattern.matcher("78HJKsd_@&%").matches());
        System.out.println(pattern.matcher("78HJKsd_@&%\n").matches());
    }

    @Test
    public void testSimpleQuantifiers() {
//        Pattern pattern = Pattern.compile("a*");
//        Pattern pattern = Pattern.compile("a+");
        Pattern pattern = Pattern.compile("a{2}");
        System.out.println(pattern.matcher("a").matches());
        System.out.println(pattern.matcher("aa").matches());
        System.out.println(pattern.matcher("aba").matches());
        System.out.println(pattern.matcher("").matches());
    }

    @Test
    public void testCapturingGroups() {
        Pattern pattern = Pattern.compile("<tag>(.+)</tag>");
        Matcher matcher = pattern.matcher("<tag>value1</tag>");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }

    @Test
    public void testPassiveGroups() {
        Pattern pattern = Pattern.compile("<tag>(?:.+)</tag>");
        Matcher matcher = pattern.matcher("<tag>value</tag>");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }

    @Test
    public void testAdvancedGroups() {
        Pattern pattern = Pattern.compile("(<tag>(.+)</tag>)+");
        Matcher matcher = pattern.matcher("<tag>value1</tag>\n" +
                "<tag>value2</tag>\n" +
                "<tag>value3</tag>");
        while (matcher.find()) {
            System.out.println(matcher.group(2));
        }
    }

    @Test
    public void testNonGreedyQuantifiers() {
//        aab
//        Pattern pattern = Pattern.compile("\"(.*)\"");
//        Pattern pattern = Pattern.compile(".*\"(.*)\"");
        Pattern pattern = Pattern.compile("\"(.*?)\"");
        Matcher matcher = pattern.matcher("\"value1\"something\"value2\"something");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
