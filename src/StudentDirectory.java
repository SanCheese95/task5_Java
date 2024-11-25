import java.util.ArrayList;
import java.util.HashMap;

class StudentDirectory {
    private HashMap<String, ArrayList<Integer>> studentMap = new
            HashMap<>();

    public void addStudent(String name, Integer grade) {
        studentMap.computeIfAbsent(name, k -> new
                ArrayList<>()).add(grade);
    }

    public ArrayList<Integer> findStudent(String name) {
        return studentMap.getOrDefault(name, new ArrayList<>());
    }

    public HashMap<String, ArrayList<Integer>> getAllStudents() {
        return studentMap;
    }

    public void removeStudent(String name) {
        studentMap.remove(name);
    }
}

class Printer {
    public static void main(String[] args) {
        StudentDirectory directory = new StudentDirectory();
        directory.addStudent("Alice", 90);
        directory.addStudent("Bob", 85);
        directory.addStudent("Alice", 95);
        System.out.println("Before removal:");
        System.out.println(directory.findStudent("Alice"));
        System.out.println(directory.getAllStudents());
        directory.removeStudent("Alice");
        System.out.println("After removal:");
        System.out.println(directory.findStudent("Alice"));
        System.out.println(directory.getAllStudents());
    }
}