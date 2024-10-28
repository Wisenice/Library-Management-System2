import java.util.ArrayList;
import java.util.List;

class Library {
    private List<LibraryItem> items;

    public Library() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
        System.out.println("Added: " + item);
    }

    public void removeItem(String id) {
        items.removeIf(item -> item.id.equals(id));
        System.out.println("Removed item with ID: " + id);
    }

    public LibraryItem findItemByTitle(String title) {
        for (LibraryItem item : items) {
            if (item.title.equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    public void listItems() {
        for (LibraryItem item : items) {
            System.out.println(item.getDetails());
        }
    }
}