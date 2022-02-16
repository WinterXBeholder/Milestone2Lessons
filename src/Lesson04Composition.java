public class Lesson04Composition {
    public static void main(String[] args) {
        Person2 p = new Person2("Merilee", "Sheldrick");

        Person2 s = new Person2("Bale", "Packmann");
        s.setStudentRecord(new Student2("100-A29-WER"));

        Person2 i = new Person2("Letisha", "Pursey");
        i.setInstructorRecord(new Instructor2("INS-COMPSCI-123", "Dr."));

        Person2 both = new Person2("Pembroke", "Andrewartha");
        both.setStudentRecord(new Student2("245-GZ4-KLA"));
        both.setInstructorRecord(new Instructor2("INS-LIT-532", "Prof."));

        System.out.println(p.getFullName());
        System.out.println(s.getFullName());
        System.out.println(i.getFullName());
        System.out.println(both.getFullName());

        Empty nothing = new Empty();
        System.out.println(nothing.toString()); //  returns the class name and a hexidecimal representation of the
            // hashCode. That's not very useful, so it's common to override this method.
        System.out.println(nothing.hashCode()); // int code for storing object in hashed data structures
        System.out.println(nothing.getClass().getName()); // meta data
        System.out.println(nothing.equals(null)); // reference equality
    }
}

class Person2 {

    private String firstName;
    private String lastName;
    // NEW CODE: composition
    private Student2 studentRecord;
    private Instructor2 instructorRecord;

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

    // NEW CODE
    public Student2 getStudentRecord() {
        return studentRecord;
    }

    public void setStudentRecord(Student2 studentRecord) {
        this.studentRecord = studentRecord;
    }

    public Instructor2 getInstructorRecord() {
        return instructorRecord;
    }

    public void setInstructorRecord(Instructor2 instructorRecord) {
        this.instructorRecord = instructorRecord;
    }

    // constructor
    public Person2(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {

        StringBuilder buffer = new StringBuilder(100);

        // am I an instructor?
        if (instructorRecord != null) {
            buffer.append(instructorRecord.getTitle());
            buffer.append(" ");
        }

        // plain old person
        buffer.append(firstName);
        buffer.append(" ");
        buffer.append(lastName);

        // am I a student?
        if (studentRecord != null) {
            buffer.append(", ID: ");
            buffer.append(studentRecord.getStudentId());
        }
        return buffer.toString();
    }
}

class Student2 {

    // make studentId read-only by omitted the setter
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public Student2(String studentId) {
        this.studentId = studentId;
    }
}
class Instructor2 {

    // employeeId and title are read-only
    private String employeeId;
    private String title;

    public String getEmployeeId() {
        return employeeId;
    }

    public String getTitle() {
        return title;
    }

    public Instructor2(String employeeId, String title) {
        this.employeeId = employeeId;
        this.title = title;
    }
}

class Empty {
}