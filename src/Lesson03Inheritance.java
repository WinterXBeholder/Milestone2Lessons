public class Lesson03Inheritance {
    public static void main(String[] args) {

        Person p = new Person("Merilee", "Sheldrick");
        Student s = new Student("Bale", "Packmann", "100-A29-WER");
        Instructor i = new Instructor("Letisha", "Pursey", "INS-COMPSCI-123", "Dr.");

        printPerson(p);
        printPerson(s);
        printPerson(i);

        // ERROR:
        // p.getStudentId(); // The method getStudentId() is undefined for the type Person
        // p.getEmployeeId(); // The method getEmployeeId() is undefined for the type Person
        // <snip>...

        /* Liskov Substitution Principle. The principle states that if we require a parent type, in this case a Person,
        then all subclasses of that type should be adequate for the requirement without "sniffing" for a subclass and
        calling a subclass-specific behavior. Paraphrased: If you think you need a Person and you find yourself needing
        a Student, then you really need a Student. */
    }

    static void printPerson(Person p) {
        if (p instanceof Person) {
            System.out.println("I'm a Person.");
        }
        if (p instanceof Student) {
            System.out.println("I'm a Student.");
        }
        if (p instanceof Instructor) {
            System.out.println("I'm an Instructor.");
        }
        System.out.println("My name is: " + p.getFullName());
    }
}

class Person {

    // fields
    private String firstName;
    private String lastName;

    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // constructor
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // methods
    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}

// 1. `extends` pulls all non-private members from Person
// into Student.
class Student extends Person {

    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String getFullName() {
        // 2. Call the parent's `getFullName` method.
        String personFullName = super.getFullName();
        // append the student id to the person's full name
        return String.format("%s, ID: %s", personFullName, studentId);
    }

    public Student(String firstName, String lastName, String studentId) {
        // 2. call the constructor on the "super" (or parent) class
        super(firstName, lastName);
        this.studentId = studentId;
    }

}
class Instructor extends Person {

    private String employeeId;
    private String title;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getFullName() {
        String personFullName = super.getFullName();
        // prepend the title to the person's full name
        return String.format("%s %s", title, personFullName);
    }

    public Instructor(String firstName, String lastName, String employeeId, String title) {
        super(firstName, lastName); // satisfy the parent constructor requirements
        this.employeeId = employeeId;
        this.title = title;
    }

}