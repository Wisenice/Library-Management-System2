import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("Library Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. List Items");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Enter Book ID, Title, Author, ISBN: ");
                    String[] bookDetails = scanner.nextLine().split(", ");
                    library.addItem(new Book(bookDetails[0], bookDetails[1], bookDetails[2], bookDetails[3]));
                    break;
                case "2":
                    System.out.print("Enter Magazine ID, Title, Issue Date: ");
                    String[] magazineDetails = scanner.nextLine().split(", ");
                    library.addItem(new Magazine(magazineDetails[0], magazineDetails[1], magazineDetails[2]));
                    break;
                case "3":
                    library.listItems();
                    break;
                case "4":
                    System.out.print("Enter Book ID to borrow: ");
                    String borrowId = scanner.nextLine();
                    LibraryItem itemToBorrow = library.findItemByTitle(borrowId);
                    if (itemToBorrow instanceof Borrowable) {
                        ((Borrowable) itemToBorrow).borrow();
                    } else {
                        System.out.println("Item not found or not borrowable.");
                    }
                    break;
                case "5":
                    System.out.print("Enter Book ID to return: ");
                    String returnId = scanner.nextLine();
                    LibraryItem itemToReturn = library.findItemByTitle(returnId);
                    if (itemToReturn instanceof Borrowable) {
                        ((Borrowable) itemToReturn).returnItem();
                    } else {
                        System.out.println("Item not found or not borrowable.");
                    }
                    break;
                case "6":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!command.equals("6"));

        scanner.close();
    }
}
