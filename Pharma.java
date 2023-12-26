import java.util.ArrayList;
import java.util.Scanner;

class Medicine {
    String name;
    int quantity;
    double price;

    public Medicine(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}

class PharmacyStore {
    private ArrayList<Medicine> stock;

    public PharmacyStore() {
        this.stock = new ArrayList<>();
    }

    public void addMedicine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter medicine name: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        Medicine medicine = new Medicine(name, quantity, price);
        stock.add(medicine);

        System.out.println("Medicine added successfully.\n");
    }

    public void displayStock() {
        if (stock.isEmpty()) {
            System.out.println("Stock is empty.\n");
        } else {
            System.out.println("\n*************************** Pharmacy Stock ***************************");
            System.out.printf("%-20s%-20s%-20s\n", "Medicine Name", "Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------");
            for (Medicine medicine : stock) {
                System.out.printf("%-20s%-20d%-20.2f\n", medicine.name, medicine.quantity, medicine.price);
            }
            System.out.println("-----------------------------------------------------------------------\n");
        }
    }

    public void generateInvoice() {
        if (stock.isEmpty()) {
            System.out.println("Cannot generate invoice. Stock is empty.\n");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of medicines you want to purchase: ");
        int num = scanner.nextInt();

        double totalAmount = 0;

        System.out.println("\n*************************** Invoice ***************************");
        System.out.printf("%-20s%-20s%-20s%-20s\n", "Medicine Name", "Quantity", "Price", "Total");
        System.out.println("-----------------------------------------------------------------------");

        for (int i = 0; i < num; i++) {
            System.out.print("Enter medicine name: ");
            String medicineName = scanner.next();
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            Medicine medicine = findMedicine(medicineName);
            if (medicine != null && medicine.quantity >= quantity) {
                double total = quantity * medicine.price;
                System.out.printf("%-20s%-20d%-20.2f%-20.2f\n", medicine.name, quantity, medicine.price, total);
                totalAmount += total;
                medicine.quantity -= quantity;
            } else {
                System.out.println("Medicine not found or insufficient stock.\n");
                return;
            }
        }

        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-60s%.2f\n", "Total Amount =", totalAmount);
        System.out.println("-----------------------------------------------------------------------\n");
    }

    private Medicine findMedicine(String name) {
        for (Medicine medicine : stock) {
            if (medicine.name.equalsIgnoreCase(name)) {
                return medicine;
            }
        }
        return null;
    }
}

public class Pharma{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Login as:\n1. Admin\n2. User");
        int userTypeChoice = scanner.nextInt();

        switch (userTypeChoice) {
            case 1:
                // Admin operations
                adminOperations();
                break;
            case 2:
                // User operations
                userOperations();
                break;
            default:
                System.out.println("Invalid choice. Exiting the Pharmacy Store Management System. Goodbye!");
                break;
        }
    }

    private static void adminOperations() {
        PharmacyStore pharmacyStore = new PharmacyStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Medicine");
            System.out.println("2. Display Stock");
            System.out.println("3. Generate Invoice");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    pharmacyStore.addMedicine();
                    break;
                case 2:
                    pharmacyStore.displayStock();
                    break;
                case 3:
                    pharmacyStore.generateInvoice();
                    break;
                case 4:
                    System.out.println("Exiting the Pharmacy Store Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        }
    }

    private static void userOperations() {
        PharmacyStore pharmacyStore = new PharmacyStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("User Menu:");
            System.out.println("1. Display Stock");
            System.out.println("2. Generate Invoice");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    pharmacyStore.displayStock();
                    break;
                case 2:
                    pharmacyStore.generateInvoice();
                    break;
                case 3:
                    System.out.println("Exiting the Pharmacy Store Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        }
    }
}
