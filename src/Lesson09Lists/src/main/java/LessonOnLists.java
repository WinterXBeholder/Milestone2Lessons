import java.util.ArrayList;
import java.util.Arrays;

public class LessonOnLists {
    public static void main(String[] args) {
        /* The `E` is replaced by a type.
        ArrayList<E> identifier = new ArrayList<E>(); */
        /*
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<SoccerPlayer> usa = new ArrayList<SoccerPlayer>();

        GenericType<String> one = new GenericType<String>();
        one.value = "one's value is a String";

        GenericType<SoccerPlayer> two = new GenericType<SoccerPlayer>();
        // two's value is a SoccerPlayer
        two.value = new SoccerPlayer(2, "Dallas", "Texas", "FW");
        GenericType<int[]> three = new GenericType<int[]>();
        // Generic types are truly generic. They can use any type.
        // Here, value is an int[].
        three.value = new int[] { 1, 3, 5, 7, 9 };
        // Don't worry too much about generic types. We'll cover them thoroughly later in the course. For now, just be
        // sure that each instantiated ArrayList<E> is given a type. Once the list is instantiated, it can only store
        // elements of that type.
        */

        // [data type] [name] = new [data type]();

        // create an ArrayList with a default capacity
        ArrayList<SoccerPlayer> one = new ArrayList<SoccerPlayer>();
        // create an ArrayList with an explicit capacity
        ArrayList<SoccerPlayer> two = new ArrayList<SoccerPlayer>(23);
        // create an ArrayList based on another collection
        ArrayList<SoccerPlayer> three = new ArrayList<SoccerPlayer>(two);

        // ArrayList can only track reference types. Therefore:
        // rather than using "int", use "Integer", the reference-type wrapper class for integers.
        ArrayList<Integer> integers = new ArrayList<Integer>();
        ArrayList<Double> doubles = new ArrayList<Double>();
        ArrayList<Boolean> booleans = new ArrayList<Boolean>();

        // if you omit the class on the right and simly use <>, it will infer class from the left
        ArrayList<SoccerPlayer> players = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        // collections such as ArrayList do not have square bracket syntax. They use methods instead.
        ArrayList<SoccerPlayer> goalKeepers = new ArrayList<>();
        goalKeepers.add(new SoccerPlayer(1, "Alyssa", "Naeher", "GK"));
        goalKeepers.add(new SoccerPlayer(18, "Ashlyn", "Harris", "GK"));
        goalKeepers.add(new SoccerPlayer(21, "Adrianna", "Franch", "GK"));
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        // Primitive types can be used, but they're automatically "boxed"
        // into their wrapper type.
        evenNumbers.add(2);
        evenNumbers.add(4);
        evenNumbers.add(6);
        // The .add method is overloaded. It can also insert an element at a specific index.
        SoccerPlayer franch = new SoccerPlayer(21, "Adrianna", "Franch", "GK");
        // Add Adrianna Franch to index 0.
        // She's now the first element.
        goalKeepers.add(0, franch);
        evenNumbers.add(2);
        evenNumbers.add(6);
        // Add 4 in between 2 and 6, at index 1.
        evenNumbers.add(1, 4);

        // .addAll method appends the elements from a collection to the end of the list.
        ArrayList<SoccerPlayer> defense = new ArrayList<>();
        defense.add(new SoccerPlayer(14, "Emily", "Sonnett", "DF"));
        defense.add(new SoccerPlayer(19, "Crystal", "Dunn", "DF"));
        defense.add(new SoccerPlayer(20, "Casey", "Short", "DF"));
        // ArrayList<SoccerPlayer> players = new ArrayList<>();
        players.addAll(goalKeepers);
        players.addAll(defense);

        /* // There is no syntax for initializing with known data. But you could pass the "Arrays.asList" method:
        ArrayList<SoccerPlayer> defense = new ArrayList<>(Arrays.asList(
                new SoccerPlayer(14, "Emily", "Sonnett", "DF"),
                new SoccerPlayer(19, "Crystal", "Dunn", "DF"),
                new SoccerPlayer(20, "Casey", "Short", "DF")
        ));
        ArrayList<Integer> oddNumbers = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        */

        defense.add(new SoccerPlayer(4, "Becky", "Sauerbrunn", "DF"));
        defense.add(new SoccerPlayer(5, "Kelley", "O'Hara", "DF"));
        defense.add(new SoccerPlayer(7, "Abby", "Dahlkemper", "DF"));
        defense.add(new SoccerPlayer(11, "Ali", "Krieger", "DF"));
        defense.add(new SoccerPlayer(12, "Tierna", "Davidson", "DF"));
        SoccerPlayer fifth = defense.get(4); // the fifth player is index 4
        System.out.println(fifth.getLastName()); // O'Hara
        System.out.println(defense.get(6).getLastName()); //Krieger
        ArrayList<Integer> evens = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        System.out.println(evens.get(0)); // 2
        System.out.println(evens.get(1)); // 4
        System.out.println(evens.get(2)); // 6

        // .size method does not return the capacity, it returns the number of elements in the list.
        ArrayList<String> cityAnimals = new ArrayList<>();
        System.out.println(cityAnimals.size()); // 0
        cityAnimals.add("Raccoon");
        cityAnimals.add("Possum");
        System.out.println(cityAnimals.size()); // 2
        cityAnimals.add("Turkey");
        System.out.println(cityAnimals.size()); // 3
        cityAnimals.add("Red-tailed Hawk");
        System.out.println(cityAnimals.size()); // 4

        // With .size and a for loop, we can access each element via the .get method.
        for (int i = 0; i < defense.size(); i++) {
            SoccerPlayer sp = defense.get(i);
            System.out.printf("%s: %s %s, %s%n", sp.getNumber(), sp.getFirstName(), sp.getLastName(), sp.getPosition());
        }
        /* Syntax
        for ([data type] [name] : [collection]) {
        }

        [data type] is the data type for an element in the [collection].
        [name] is a variable name that is valid only inside the code block.
        [collection] is an iterable collection like lists and arrays.
        */
        for (SoccerPlayer sp : defense) {
            System.out.printf("%s: %s %s, %s%n", sp.getNumber(), sp.getFirstName(), sp.getLastName(), sp.getPosition());
        }
        String[] colors = {"red", "orange", "yellow", "green", "blue", "purple"};
        for (String color : colors) {
            System.out.println(color);
        }
        ArrayList<String> colorList = new ArrayList<>(Arrays.asList(colors));
        for (String c : colorList) {
            System.out.println(c);
        }
        for (SoccerPlayer sp : defense) {
            // this doesn't change anything in the `defense` list
            // it only affects the current block
            sp = new SoccerPlayer(18, "Ashlyn", "Harris", "GK");
            System.out.printf("%s: %s %s, %s%n", sp.getNumber(), sp.getFirstName(), sp.getLastName(), sp.getPosition());
        }


        // .remove method to remove elements from the list. There are two forms. The first removes an element at a
        // given index. The second removes a value.
        ArrayList<SoccerPlayer> forwards = new ArrayList<>();
        forwards.add(new SoccerPlayer(2, "Mallory", "Pugh", "FW"));
        forwards.add(new SoccerPlayer(10, "Carli", "Lloyd", "FW"));
        forwards.add(new SoccerPlayer(13, "Lynn", "Williams", "FW"));
        forwards.add(new SoccerPlayer(15, "Megan", "Rapinoe", "FW"));
        forwards.add(new SoccerPlayer(17, "Tobin", "Heath", "FW"));
        forwards.add(new SoccerPlayer(22, "Jessica", "McDonald", "FW"));
        forwards.add(new SoccerPlayer(23, "Christen", "Press", "FW"));
        System.out.println(forwards.size());
        SoccerPlayer removed = forwards.remove(3);
        System.out.printf("%s: %s, %s%n", removed.getNumber(), removed.getLastName(), removed.getPosition());
        removed = forwards.remove(3);
        System.out.printf("%s: %s, %s%n", removed.getNumber(), removed.getLastName(), removed.getPosition());
        removed = forwards.remove(3);
        System.out.printf("%s: %s, %s%n", removed.getNumber(), removed.getLastName(), removed.getPosition());
        System.out.println(forwards.size());
        /* When elements are removed, all other elements shift so there are no index gaps. The code above removes the
        element at index 3 three times. Each time it is a different player. Removing an element also reduces the size
        by one */
        // list stores Strings
        ArrayList<String> rivers = new ArrayList<>(
                Arrays.asList("Mississippi", "Amazon", "Nile", "Volga", "Zambezi", "Mekong"));
        rivers.remove("Nile"); // value is a String
        for (String name : rivers) {
            System.out.println(name);
        }


        // Value removal may lead to confusing behavior. Consider the following code.
        ArrayList<SoccerPlayer> newForwards = getForwards();
        SoccerPlayer rapinoe = getRapinoe();
        newForwards.remove(rapinoe); // <-- This doesn't work.
        for (SoccerPlayer player : newForwards) {
            System.out.println(player.getLastName());
        }
        /* Walking through the code we:

        Start with an ArrayList<SoccerPlayer> that contains the player, Megan Rapinoe.
        Generate a second Megan Rapinoe object.
        The values in both objects are the same, but when we try to remove by value, it fails.
        Given a value, the .remove method removes the first element that is equal to the value. The method fails here
        because of how Java evaluates equality. With reference types, the default is reference equality. Two objects are
        considered equal if and only if they reference the same spot in memory. It doesn't matter if two objects have
        identical field values.

        Sometimes that's what we want, but often it's not. To fix the problem, we override equality behavior in
        SoccerPlayer. We override the Object super-class's equals method in the SoccerPlayer class.*/
    }

    static ArrayList<SoccerPlayer> getForwards() {
        ArrayList<SoccerPlayer> forwards = new ArrayList<>();
        forwards.add(new SoccerPlayer(2, "Mallory", "Pugh", "FW"));
        forwards.add(new SoccerPlayer(10, "Carli", "Lloyd", "FW"));
        forwards.add(new SoccerPlayer(13, "Lynn", "Williams", "FW"));
        forwards.add(new SoccerPlayer(15, "Megan", "Rapinoe", "FW")); // <-- Rapinoe
        forwards.add(new SoccerPlayer(17, "Tobin", "Heath", "FW"));
        forwards.add(new SoccerPlayer(22, "Jessica", "McDonald", "FW"));
        forwards.add(new SoccerPlayer(23, "Christen", "Press", "FW"));
        return forwards;
    }
    static SoccerPlayer getRapinoe() {
        return new SoccerPlayer(15, "Megan", "Rapinoe", "FW"); // <-- Rapinoe
    }





































}
