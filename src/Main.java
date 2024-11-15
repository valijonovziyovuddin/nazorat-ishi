import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Employee emp1 = new Employee("Ali", "Developer");
        Employee emp2 = new Employee("Sara", "Designer");

        taskManager.addEmployee(emp1);
        taskManager.addEmployee(emp2);

        Task task1 = new Task("Dasturlash", "Java dasturi yozish", LocalDate.of(2024, 11, 15));
        Task task2 = new Task("Dizayn", "Sayt dizaynini tayyorlash", LocalDate.of(2024, 11, 10));
        Task task3 = new Task("Test", "Dastur testini o'tkazish", LocalDate.of(2024, 11, 20));

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);

        taskManager.assignTaskToEmployee(0, task1);
        taskManager.assignTaskToEmployee(1, task2);
        taskManager.displayAllEmployees();

        task1.markAsComplete();

        List<Task> overdueTasks = taskManager.getOverdueTasks();
        System.out.println("Overdue Tasks:");
        for (Task task : overdueTasks) {
            System.out.println("- " + task.getTitle());
        }

        Map<String, Long> tasksByRole = taskManager.countTasksByRole();
        System.out.println("Tasks count by role: " + tasksByRole);
    }
}
