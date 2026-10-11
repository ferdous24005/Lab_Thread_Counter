
class Student {
    int age = 20;

    void display() {
        int marks = 85;

        System.out.println("Object Identity Hash Code: "
                + System.identityHashCode(this));
        System.out.println("Instance Variable (age): " + age);
        System.out.println("Local Variable (marks): " + marks);
    }

    public static void main(String[] args) {
        Student s = new Student();

        System.out.println("Student Object Created");
        s.display();
    }
}