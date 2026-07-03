public class MVCPatternTest {

    public static void main(String[] args) {

        Student student = new Student("Dinesh", "23BCE20293", "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        System.out.println("Initial Student Details");
        controller.updateView();

        controller.setStudentName("John Wesly");
        controller.setStudentGrade("A+");

        System.out.println("Updated Student Details");
        controller.updateView();

    }
}