//public class Lesson02CreatingClasses {
//    public static void main(String[] args) {
//
//        // instantiation:
//        NationalForest one = new NationalForest();
//        // set a public field
//        one.name = "Allegheny";
//        NationalForest two = new NationalForest();
//        two.name = "Angeles";
//        NationalForest three = new NationalForest();
//        three.name = "Angeina";
//        String format = "name: %s, location: %s, acres: %s%n";
//        // 3. read each `public` field
//        // each object's fields have different values
//        System.out.printf(format, one.name, one.location, one.acres);
//        System.out.printf(format, two.name, two.location, two.acres);
//        System.out.printf(format, three.name, three.location, three.acres);
//        one.location = "Pennsylvania";
//        one.acres = 513655;
//    }
//
//
//
//
//
//
//
//
//}
//
//class NationalForest {
//    // classes can have three things: Fields, Method Definitions, and Constructors. None are required.
//
//    // class-level variables called Fields:
//    // can be accessed by any method.
//    public String name; // default null
//    public String location;
//    public int acres; // default 0
//    public boolean test; // default false
//
//    // constructors ensure objects are instantiated with valid states (valid data)
//    public NationalForest(String name, String location, int acres) {
//        this.name = name;
//        this.location = location;
//        this.acres = acres;
//    }
//
//
//}
