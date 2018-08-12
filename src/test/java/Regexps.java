import org.testng.annotations.Test;

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
        Pattern pattern = Pattern.compile("\\w\\s-\\d");
        System.out.println(pattern.matcher("A -9").matches());
        System.out.println(pattern.matcher("B\n-2").matches());
        System.out.println(pattern.matcher("d\t-7").matches());
        System.out.println(pattern.matcher("_ -1").matches());
        System.out.println(pattern.matcher("9 -1").matches());
        System.out.println(pattern.matcher("BB -1").matches());
        System.out.println(pattern.matcher("& -1").matches());
    }
}
