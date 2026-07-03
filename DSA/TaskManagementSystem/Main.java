public class Main {

    public static void main(String[] args) {

        TaskLinkedList tasks = new TaskLinkedList();

        tasks.addTask(101, "Design UI", "Pending");
        tasks.addTask(102, "Write Code", "In Progress");
        tasks.addTask(103, "Testing", "Pending");

        tasks.traverseTasks();

        tasks.searchTask(102);

        tasks.deleteTask(101);

        tasks.traverseTasks();
    }
}