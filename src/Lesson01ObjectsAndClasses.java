import java.util.Scanner;

public interface Lesson01ObjectsAndClasses {
    public static void main(String[] args) {




    }

    public static void classes01() {
        Scanner one = new Scanner("one\ntwo\nthree\nfour");
        Scanner two = new Scanner("red\nyellow\nblue\ngreen");
        String result;
        while (one.hasNext()) {
            result = one.next();
            System.out.println(result);
        }
        while (two.hasNext()) {
            result = two.next();
            System.out.println(result);
        }
    }

    public static void classes02() {
        Scanner one = new Scanner("one!two!three!four");
        Scanner two = new Scanner("one!two!three!four");
        two.useDelimiter("!");
        String result;
        System.out.println("one's delimiter: " + one.delimiter());
        while (one.hasNext()) {
            result = one.next();
            System.out.println(result);
        }
        System.out.println("two's delimiter: " + two.delimiter());
        while (two.hasNext()) {
            result = two.next();
            System.out.println(result);
        }
    }

    public static void classes03() {
        // success is an instance of Color
        Color success = new Color("green");

        // failure is an instance of Color
        Color failure = new Color("blue");

        // warning is an instance of Color
        Color warning = new Color("yellow");

        // each color has its own state
        // the dot operator, `.`, looks "inside" the object
        System.out.println("Success color is: " + success.name); // Success color is: green
        System.out.println("Failure color is: " + failure.name); // Failure color is: blue
        System.out.println("Warning color is: " + warning.name); // Warning color is: yellow

        // the failure color doesn't seem right
        // change it to red
        failure.name = "red";
        System.out.println("Failure color is: " + failure.name);  // Failure color is: red
    }
}

// The template, blueprint, or recipe for a Color.
// It isn't a color, but it contains the rules which define
// what it means to be a color.
class Color {

    public String name;

    public Color(String name) {
        this.name = name;
    }
}
