
/*
 * The purpose of program is implementing a simple company system with the following OOP class hierarchy.
 * Name and Surname: Feyzullah Asıllıoğlu  
 * Student ID: 150121021
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Test {
    private static ArrayList<Person> persons = new ArrayList<>();
    private static ArrayList<Department> departments = new ArrayList<>();
    private static ArrayList<Project> projects = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        File file = new File("CSE1242_spring2022_homework_1_input.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            switch (line[0]) {
                case "Department": {
                    departments.add(new Department(Integer.parseInt(line[1]), line[2]));
                    break;
                }
                case "Project": {
                    projects.add(new Project(line[1], parseCalender(line[2]), line[3]));
                    break;
                }
                case "Product": {
                    products.add(new Product(line[1], parseCalender(line[2]), Double.parseDouble(line[3])));
                    break;
                }
                case "Person": {
                    persons.add(new Person(Integer.parseInt(line[3]), line[1], line[2], line[4], parseCalender(line[5]),
                            line[6], line[7]));
                    break;
                }
                case "Employee": {
                    int personId = Integer.parseInt(line[1]);
                    String departmentName = line[4];
                    Person person = null;
                    Department department = null;
                    for (Person p : persons) {
                        if (p.getId() == personId) {
                            person = p;
                            break;
                        }
                    }
                    if (person == null) {
                        throw new Exception("No employee with id = " + personId);
                    }
                    for (Department d : departments) {
                        if (d.getDepartmentName().equals(departmentName)) {
                            department = d;
                            break;
                        }
                    }
                    if (department == null) {
                        throw new Exception("No department with name = " + departmentName);
                    }
                    persons.set(persons.indexOf(person),
                            new Employee(person, Double.parseDouble(line[2]), parseCalender(line[3]), department));
                    break;
                }
                case "Manager": {
                    for (Person person : persons) {
                        if (person instanceof Employee employee && employee.getId() == Integer.parseInt(line[1])) {
                            persons.set(persons.indexOf(employee), new Manager(employee, Double.parseDouble(line[2])));
                            break;
                        }
                    }
                    break;
                }
                case "RegularEmployee": {
                    for (Person person : persons) {
                        if (person instanceof Employee employee && employee.getId() == Integer.parseInt(line[1])) {
                            persons.set(persons.indexOf(employee),
                                    new RegularEmployee(employee, Double.parseDouble(line[2])));
                            break;
                        }
                    }
                    break;
                }
                case "Developer": {
                    RegularEmployee regularEmployee = null;
                    int regularEmployeeId = Integer.parseInt(line[1]);
                    for (Person person : persons) {
                        if (person instanceof RegularEmployee && person.getId() == regularEmployeeId) {
                            regularEmployee = (RegularEmployee) person;
                            break;
                        }
                    }
                    if (regularEmployee == null) {
                        throw new Exception("No regular developer with id = " + line[1]);
                    }
                    ArrayList<Project> listOfProjects = new ArrayList<>();
                    for (int i = 2; i < line.length; i++) {
                        for (Project project : projects) {
                            if (line[i].equals(project.getProjectName())) {
                                listOfProjects.add(project);
                                break;
                            }
                        }
                    }
                    persons.set(persons.indexOf(regularEmployee), new Developer(regularEmployee, listOfProjects));
                    break;
                }
                case "SalesEmployee": {
                    RegularEmployee regularEmployee = null;
                    int regularEmployeeId = Integer.parseInt(line[1]);
                    for (Person person : persons) {
                        if (person instanceof RegularEmployee && person.getId() == regularEmployeeId) {
                            regularEmployee = (RegularEmployee) person;
                            break;
                        }
                    }
                    if (regularEmployee == null) {
                        throw new Exception("No sales employee with id = " + line[1]);
                    }
                    ArrayList<Product> listOfProducts = new ArrayList<>();
                    for (int i = 2; i < line.length; i++) {
                        for (Product product : products) {
                            if (line[i].equals(product.getProductName())) {
                                listOfProducts.add(product);
                                break;
                            }
                        }
                    }
                    persons.set(persons.indexOf(regularEmployee), new SalesEmployee(regularEmployee, listOfProducts));
                    break;
                }
                case "Customer": {
                    Person person = null;
                    int personId = Integer.parseInt(line[1]);
                    for (Person p : persons) {
                        if (p.getId() == personId) {
                            person = p;
                            break;
                        }
                    }
                    if (person == null) {
                        throw new Exception("No customer with id = " + line[1]);
                    }
                    ArrayList<Product> listOfProducts = new ArrayList<>();
                    for (int i = 2; i < line.length; i++) {
                        for (Product product : products) {
                            if (line[i].equals(product.getProductName())) {
                                listOfProducts.add(product);
                                break;
                            }
                        }
                    }
                    persons.set(persons.indexOf(person), new Customer(person, listOfProducts));
                    break;
                }
                default:
                    throw new Exception("Object type is not found " + line[0]);
            }
        }
        scanner.close();

        for (Department department : departments) {
            Manager manager = getManagerOfDepartment(department);
            for (Person person : persons) {
                if (person instanceof RegularEmployee regularEmployee
                        && regularEmployee.getDepartment().equals(department)) {
                    manager.addEmployee(regularEmployee);
                }
            }
        }
        //instructions
        for (Person person : persons) {
            if (person instanceof Manager manager) {
                manager.distributeBonusBudget();
                manager.raiseSalary(0.2);
            }
        }
        for (Person person : persons) {
            if (person instanceof RegularEmployee regularEmployee) {
                regularEmployee.raiseSalary(0.3);
            }
        }
        for (Person person : persons) {
            if (person instanceof Developer developer) {
                developer.raiseSalary(0.23);
            }
        }

        SalesEmployee manOfMonth = null;

        for (Person person : persons) {
            if (person instanceof SalesEmployee salesEmployee) {
                salesEmployee.raiseSalary(0.18);
                if (manOfMonth == null || salesEmployee.getTotalValuesFromSales() > manOfMonth.getTotalValuesFromSales()) {
                    manOfMonth = salesEmployee;
                }
            }
        }
        manOfMonth.raiseSalary(1000);

        for (Department department : departments) {
            System.out.println("************************************************");
            System.out.println(department.toString());
            for (Person person : persons) {
                if (person instanceof Manager manager) {
                    if (manager.getDepartment().equals(department)) {
                        System.out.println("\t" + manager.toString());
                        ArrayList<RegularEmployee> regularEmployees = manager.getRegularEmployees();
                        for (int i = 0; i < regularEmployees.size(); i++) {
                            System.out.println("\t\t\t" + (i + 1) + ". " + regularEmployees.get(i));
                        }
                    }
                }
            }
        }
        System.out.println("\n\n**********************CUSTOMERS************************");
        for (Person person : persons) {
            if (person instanceof Customer customer) {
                System.out.println(customer.toString());
            }
        }

        System.out.println("\n\n**********************PEOPLE************************");
        for (Person person : persons) {
            if (!(person instanceof Customer || person instanceof Employee)) {
                System.out.println(person.toString());
            }
        }
    }

    private static Manager getManagerOfDepartment(Department department) {
        for (Person person : persons) {
            if (person instanceof Manager manager && manager.getDepartment().equals(department)) {
                return manager;
            }
        }
        return null;
    }

    private static Calendar parseCalender(String date) {
        String[] splittedDate = date.split("/");
        int DAY = Integer.parseInt(splittedDate[0]);
        int MONTH = Integer.parseInt(splittedDate[1]) - 1;
        int YEAR = Integer.parseInt(splittedDate[2]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR, MONTH, DAY);
        return calendar;
    }
}