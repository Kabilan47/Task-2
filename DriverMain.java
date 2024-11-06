import java.util.Scanner;

// Taxable interface with constants and an abstract method
interface Taxable {
    double SALES_TAX = 0.07; // 7% sales tax
    double INCOME_TAX = 0.105; // 10.5% income tax

    double calcTax();
}

// Employee class implementing the Taxable interface
class Employees implements Taxable {
    private int empId;
    private String name;
    private double salary;

    // Constructor
    public Employees(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    // Method to calculate income tax on yearly salary
    @Override
    public double calcTax() {
        return salary * INCOME_TAX;
    }

    // Method to display employee details and tax
    public void display() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Yearly Salary: " + salary);
        System.out.println("Income Tax: " + calcTax());
    }
}

// Product class implementing the Taxable interface
class Product implements Taxable {
    private int pid;
    private double price;
    private int quantity;

    // Constructor
    public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to calculate sales tax on unit price of the product
    @Override
    public double calcTax() {
        return price * SALES_TAX;
    }

    // Method to display product details and tax
    public void display() {
        System.out.println("Product ID: " + pid);
        System.out.println("Unit Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Sales Tax per Unit: " + calcTax());
    }
}

// Main class with main method to accept input and display results
public class DriverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Employee
        System.out.println("Enter Employee details:");
        System.out.print("Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Yearly Salary: ");
        double salary = scanner.nextDouble();
        Employees employee = new Employees(empId, name, salary);

        // Input for Product
        System.out.println("\nEnter Product details:");
        System.out.print("Product ID: ");
        int pid = scanner.nextInt();
        System.out.print("Unit Price: ");
        double price = scanner.nextDouble();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        Product product = new Product(pid, price, quantity);

        // Display results
        System.out.println("\n--- Tax Calculation Results ---");
        employee.display();
        System.out.println();
        product.display();

        scanner.close();
    }
}
