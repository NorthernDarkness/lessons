package com.mera.training.core;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Regexps {

    final static Logger logger = org.apache.log4j.Logger.getLogger(Regexps.class);

    private void testRegexp(String text, String regexp, int... groups) {
        final String r = StringEscapeUtils.escapeJava(regexp);
        final String t = StringEscapeUtils.escapeJava(text);
        logger.debug("Text    : \"" + t + "\"");
        logger.debug("Pattern : \"" + r + "\"");
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(text);
        int i = 0;
        while (m.find()) {
            logger.debug("Hit from " + m.start() + " to " + m.end() + " \"" + StringEscapeUtils.escapeJava(m.group()) + "\"");
        }
        m.reset();
        logger.debug("Matches : " + text.matches(regexp));
        logger.debug("Find    : " + m.find());
        if (groups.length > 0) {
            logger.debug("Groups  : " + m.groupCount());
        }
        IntStream.of(groups).forEach(g -> logger.debug("Group " + g + " : " + m.group(g)));
        logger.debug("\n");
    }

    @Test
    public void testLiterals() {
        testRegexp("asd", "asd");
        testRegexp("456asd465", "asd");
        testRegexp("\nasd\n", "asd");
    }

    @Test
    public void testSet() {
        testRegexp("s-9", "[A-Za-z]-[0-9]");
        testRegexp("B-2", "[A-Za-z]-[0-9]");
        testRegexp("TT-7", "[A-Za-z]-[0-9]");
        testRegexp("Gh-899", "[A-Za-z]-[0-9]");
        testRegexp("As-9", "[A-Za-z]-[0-9]");
    }

    @Test
    public void testNegativeSets() {
        testRegexp("9", "[^0-9]");
        testRegexp("D", "[^0-9]");
        testRegexp("%", "[^0-9]");
        testRegexp(" ", "[^0-9]");
        testRegexp("\n", "[^0-9]");
    }

    @Test
    public void testAdvancedSets() {
        testRegexp("j", "[a-z&&[^m-p]]");
        testRegexp("z", "[a-z&&[^m-p]]");
        testRegexp("n", "[a-z&&[^m-p]]");
    }

    @Test
    public void testClasses() {
        testRegexp("A -9", "\\w\\s-\\d");
        testRegexp("B\n-2", "\\w\\s-\\d");
        testRegexp("d\t-7", "\\w\\s-\\d");
        testRegexp("_ -1", "\\w\\s-\\d");
        testRegexp("9 -1", "\\w\\s-\\d");
        testRegexp("BB -1", "\\w\\s-\\d");
        testRegexp("& -1", "\\w\\s-\\d");
    }

    @Test
    public void testNegativeClasses() {
        testRegexp(" ", "\\W");
        testRegexp("_", "\\W");
        testRegexp("\n", "\\W");
        testRegexp("A", "\\S");
        testRegexp("\n", "\\S");
    }

    @Test
    public void testAnchors() {
        testRegexp("A -9", "^A");
        testRegexp("af dgf", "f$");
        testRegexp("ddddy", "^d\\w+y$");
        testRegexp("dd\nddy", "^d\\w+y$");
        testRegexp("dd\nddy", "(?m)^d\\w+y$");
    }

    @Test
    public void testStringOr() {
        testRegexp("z", "a|z");
        testRegexp("a", "a|z");
        testRegexp("c", "a|z");
        testRegexp("az", "[az]");
        testRegexp("a", "[az]");
        testRegexp("z", "[az]");
    }

    @Test
    public void testCaseSensitivity() {
        testRegexp("a", "a");
        testRegexp("A", "a");
        testRegexp("A", "(?i)a");
    }

    @Test
    public void testDot() {
        testRegexp("z", ".");
        testRegexp("$", ".");
        testRegexp(" ", ".");
        testRegexp("\n", ".");
        testRegexp("\n", "(?s).");
    }

    @Test
    public void testSimpleQuantifiers() {
        Pattern pattern = Pattern.compile("a{2}");
        testRegexp("a", "a{2}");
        testRegexp("aa", "a{2}");
        testRegexp("aaa", "a{2}");
        testRegexp("aaa", "a{2,4}");
        testRegexp("aaa", "a{2,}");
    }

    @Test
    public void testQuantifiers() {
        testRegexp("d", "w?");
        testRegexp("", "w?");
        testRegexp("dd", "w?");
        testRegexp("da", "\\w*");
        testRegexp("321", "\\W*");
        testRegexp("432", "\\d+");
        testRegexp("das", "\\d+");
    }

    @Test
    public void testRegexpMisc() {
        logger.debug("123".matches("\\d{3}"));
        String[] parts = "123-234_456 ".split("[-_ ]");
        logger.debug(Arrays.asList(parts));
        String format = String.format("Result is %s", 123);
        logger.debug(format);
        final Predicate<String> predicate = Pattern.compile("\\w{2}").asPredicate();
        logger.debug(predicate.test("123"));
    }

    @Test
    public void testCapturingGroups() {
        testRegexp("<tag>value1</tag>", "<tag>(.+)</tag>", 1);
    }

    @Test
    public void testPassiveGroups() {
        testRegexp("<tag>value1</tag>", "<tag>(?:.+)</tag>", 1);
    }

    @Test
    public void testAdvancedGroups() {
        final String text = "<tag>value1</tag>\n"
                + "<tag>value2</tag>\n"
                + "<tag>value3</tag>";
        testRegexp(text, "(<tag>(.+)</tag>)+", 1, 2);
        testRegexp(text, "(?m)^<tag>(.+)</tag>$", 1);
    }

    @Test
    public void testReluctantQuantifiers() {
        testRegexp("\"value1\"something\"value2\"something", "\"(.*)\"", 1);
        testRegexp("\"value1\"something\"value2\"something", ".*\"(.*)\"", 1);
        testRegexp("\"value1\"something\"value2\"something", "\"(.*?)\"", 1);
        testRegexp("\"value1\"something\"value2\"something", "\"([^\"]*)\"", 1);
    }

    @Test
    public void testPossessiveQuantifiers() {
//        testRegexp("\"value1\"something\"value2\"something", "\"(.*+)\"", 1);
        final String string = Stream.generate(() -> "JavaJar").limit(2).collect(Collectors.joining());
//        testRegexp(string, "(Java|Jar)+", 1);
//        testRegexp(string, "(Java|Jar)+?", 1);
        testRegexp(string, "(Java|Jar)++", 1);
        testRegexp(string, "(:>Java|Jar)+", 1);
    }

    @Test
    public void testBackReference() {
        final String regexp = "(?is)(?:\\b(\\w+)\\b)(?:\\s+\\b\\1\\b)+";
        testRegexp("word word", regexp);
        testRegexp("word word word word word", regexp);
        testRegexp("word", regexp);
        testRegexp("word word1", regexp);
    }

    @Test
    public void testLookAround() {
        testRegexp("\"va\\\"lue1\"something\"value2\"something", "\"([^\"]*)\"", 1);
        testRegexp("\"va\\\"lue1\"something\"value2\"something", "\"(.*?)(?<!\\\\)\"");
    }


}
