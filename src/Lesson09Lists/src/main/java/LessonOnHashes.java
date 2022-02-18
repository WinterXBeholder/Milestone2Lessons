import java.util.HashMap;
import java.util.Map.Entry;
import java.util.HashSet;

public class LessonOnHashes {
    public static void main(String[] args) {
        // All objects include a .hashCode method which returns their integer hash value.
        // It's what hash-based data structures use for mapping.
        System.out.println("cspacey0@myspace.com".hashCode());
        System.out.println("sbretherick1@va.gov".hashCode());
        System.out.println("zcripwell2@dot.gov".hashCode());
        System.out.println("spyatt3@marketwatch.com".hashCode());
        System.out.println("oranahan4@bing.com".hashCode());

        // All keys should map to unique values.
        HashMap<Integer, Character> numberToLetter = new HashMap<>();
        HashMap<Integer, Character> numberToAB = new HashMap<>();
        HashMap<Character, String> letterToFruit = new HashMap<>();
        HashMap<String, Login> emailToLogin = new HashMap<>();

        // Using the jersey number as a key is dangerous. Depending on the players,
        // jersey numbers are likely to be duplicated.
        HashMap<Integer, SoccerPlayer> jerseyNumberToPlayer = new HashMap<>();
        // Using the last name as a key is dangerous. Again, last name are seldom unique.
        HashMap<String, SoccerPlayer> lastNameToPlayer = new HashMap<>();

        letterToFruit.put('A', "Apple");
        letterToFruit.put('B', "Banana");
        letterToFruit.put('C', "Cherry");
        letterToFruit.put('D', "Durian");

        Login one = new Login("cspacey0@myspace.com", "Carita", "Spacey");
        Login two = new Login("sbretherick1@va.gov", "Sammy", "Bretherick");
        emailToLogin.put(one.getEmailAddress(), one);
        emailToLogin.put(two.getEmailAddress(), two);

        String fruit = letterToFruit.get('B');
        System.out.println(fruit); // Banana
        fruit = letterToFruit.get('X');
        System.out.println(fruit); // null
        Login login = emailToLogin.get("cspacey0@myspace.com");
        System.out.println(login.getFirstName() + " " + login.getLastName()); // Carita Spacey
        login = emailToLogin.get("invalid@email.com");
        System.out.println(login); // null

        /* Visiting each element in a loop can be accomplished in three different ways: using the .values method,
        .keySet, or .entrySet. There are no order guarantees when looping. A HashMap<K, V> is an unordered collection*/
        emailToLogin.put("zcripwell2@dot.gov", new Login("zcripwell2@dot.gov", "Zia", "Cripwell"));
        emailToLogin.put("spyatt3@marketwatch.com", new Login("spyatt3@marketwatch.com", "Sianna", "Pyatt"));
        emailToLogin.put("oranahan4@bing.com", new Login("oranahan4@bing.com", "Odelinda", "Ranahan"));

        System.out.println("Loop over values:");
        System.out.println("=====================");
        for (Login l : emailToLogin.values()) {
            System.out.printf("%s %s%n", l.getFirstName(), l.getLastName());
        }

        System.out.println("Loop over keySet:");
        System.out.println("=====================");
        for (String key : emailToLogin.keySet()) {
            Login l = emailToLogin.get(key);
            System.out.printf("%s %s%n", l.getFirstName(), l.getLastName());
        }
        for (char key : letterToFruit.keySet()) {
            System.out.printf("Key: %s, Value: %s%n", key, letterToFruit.get(key));
        }

        System.out.println("Loop over entrySet:");
        System.out.println("=====================");
        for (Entry<String, Login> entry : emailToLogin.entrySet()) {
            System.out.printf("Key: %s, Value: %s %s%n",
                    entry.getKey(),
                    entry.getValue().getFirstName(),
                    entry.getValue().getLastName());
        }

        // Using the jersey number as a key is dangerous. Depending on the players stored,
        // jersey numbers are likely to be duplicated and cause collisions, therefore values will be overwritten
        HashMap<Integer, SoccerPlayer> jerseyNumberToPlayer = new HashMap<>();
        jerseyNumberToPlayer.put(20, new SoccerPlayer(20, "Casey", "Short", "DF"));

        SoccerPlayer player = jerseyNumberToPlayer.get(20);
        System.out.println(player.getFirstName() + " " + player.getLastName()); // Casey Short

        jerseyNumberToPlayer.put(20, new SoccerPlayer(20, "Zhang", "Rui", "MF"));
        player = jerseyNumberToPlayer.get(20);
        System.out.println(player.getFirstName() + " " + player.getLastName()); // Zhang Rui

        // .remove to remove a k:value pair and reduce length. If a key doesn't exist, method does nothing.
        letterToFruit.put('E', "Elderberry");
        letterToFruit.remove('B');
        letterToFruit.remove('C');
        letterToFruit.remove('X'); // no effect
        for (char key : letterToFruit.keySet()) {
            System.out.printf("Key: %s, Value: %s%n", key, letterToFruit.get(key));
        }


        /*The size method returns the number of values in the map.
          containsKey returns true if a key is present in the map, false if it isn't.*/
        System.out.println(emailToLogin.size());                            // 5
        System.out.println(emailToLogin.containsKey("zcripwell2@dot.gov")); // true
        System.out.println(emailToLogin.containsKey("invalid@email.com"));  // false

        emailToLogin.remove("zcripwell2@dot.gov");
        System.out.println(emailToLogin.size());                            // 4
        System.out.println(emailToLogin.containsKey("zcripwell2@dot.gov")); // false

        // HashSet<E> is a similar data structure that has no keys and ensures the set cannot duplicate values:
        System.out.println(emailToLogin.size());                            // 5
        System.out.println(emailToLogin.containsKey("zcripwell2@dot.gov")); // true
        System.out.println(emailToLogin.containsKey("invalid@email.com"));  // false
        emailToLogin.remove("zcripwell2@dot.gov");
        System.out.println(emailToLogin.size());                            // 4
        System.out.println(emailToLogin.containsKey("zcripwell2@dot.gov")); // false
        HashSet<String> uniqueColors = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            uniqueColors.add("red");
            uniqueColors.add("blue");
            uniqueColors.add("yellow");
        }
        System.out.println("size: " + uniqueColors.size());
        for (String color : uniqueColors) {
            System.out.println(color);
        }

        // But when we try adding Logins, something isn't right. We get 30 logins:
        HashSet<Login> uniqueLogins = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            uniqueLogins.add(new Login("cspacey0@myspace.com", "Carita", "Spacey"));
            uniqueLogins.add(new Login("sbretherick1@va.gov", "Sammy", "Bretherick"));
            uniqueLogins.add(new Login("zcripwell2@dot.gov", "Zia", "Cripwell"));
        }
        System.out.println("size: " + uniqueLogins.size());
        for (Login L : uniqueLogins) {
            System.out.println(L.getEmailAddress());
        }
        /* That's because Login uses the .hashCode method inherited from Object. Both Integer and String define their
        own .hashCode methods, but Login doesn't. That means it gets the default behavior. The default behavior is
        reference equality. If an object is a unique reference, it is a unique value. That means that each new Login()
        is treated as a unique value even though the fields inside are the same.

        To remedy the situation, we can override both .hashCode and .equals to compare values inside a login, not the
        reference.*/


    }

}
