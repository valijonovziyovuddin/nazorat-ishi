import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskManager {
    private List<Employee> employees;
    private List<Task> tasks;


    public TaskManager() {
        this.employees = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
    public void assignTaskToEmployee(int employeeId, Task task) {
        if (employeeId >= 0 && employeeId < employees.size()) {
            employees.get(employeeId).assignTask(task);
        }
    }

    public List<Task> getOverdueTasks() {
        return tasks.stream()
                .filter(Task::isOverdue)
                .collect(Collectors.toList());
    }

    public void displayAllEmployees() {
        for (Employee employee : employees) {
            employee.displayInfo();
        }
    }

    public Map<String, Long> countTasksByRole() {
        return employees.stream()
                .flatMap(employee -> employee.getPendingTasks().stream()
                        .map(task -> employee.getRole()))
                .collect(Collectors.groupingBy(role -> role, Collectors.counting()));
    }
}
