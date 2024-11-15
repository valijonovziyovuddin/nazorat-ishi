import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    private String name;
    private String role;
    private List<Task> tasks;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
        this.tasks = new ArrayList<>();
    }

    public void assignTask(Task task) {
        tasks.add(task);
    }
    public List<Task> getPendingTasks() {
        return tasks.stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toList());
    }
    public void displayInfo() {
        System.out.println("Name: " + name + ", Role: " + role);
        System.out.println("Tasks:");
        for (Task task : tasks) {
            System.out.println("- " + task.getTitle() + " (Completed: " + task.isCompleted() + ")");
        }
    }

    public String getRole() {
        return role;
    }
}
