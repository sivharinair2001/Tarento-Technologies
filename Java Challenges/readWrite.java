import java.io.*;

class Employee {
    int id;
    String name;
    String position;

    public Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + position;
    }
}

public class readWrite {
    public static void readEmployee(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("ID")) {
                    continue;
                }
                String[] details = line.split(",");
                int id = Integer.parseInt(details[0]);
                String name = details[1];
                String position = details[2];
                Employee employee = new Employee(id, name, position);
                System.out.println("Read Employee: " + employee);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file");
            e.printStackTrace();
        }
    }

    public static void writeEmployee(String fileName, Employee[] employees) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
//            bw.write("ID,Name,Position");
//            bw.newLine();
            for (Employee employee : employees) {
                bw.write(employee.toString());
                bw.newLine();
            }
            System.out.println("Employee details written");
        } catch (IOException e) {
            System.out.println("An error occurred during writing");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String inputFileName = "Java Challenges/employee.txt";
        String outputFileName = "Java Challenges/employee.txt";

        readEmployee(inputFileName);

        Employee[] newEmployees = {
                new Employee(4, "Virat", "Director"),
                new Employee(5, "Dhoni", "Cleaner")
        };

        writeEmployee(outputFileName, newEmployees);
    }
}
