import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Integer> books;  // map of book titles to available copies
    private Map<String, Integer> reservations; // map of book titles to number of reservations

    public Library() {
        books = new HashMap<>();
        reservations = new HashMap<>();
    }

    public void addBook(String title, int copies) {
        books.put(title, books.getOrDefault(title, 0) + copies);
    }

    public void reserveBook(String title) {
        if (!books.containsKey(title) || books.get(title) == 0) {
            throw new IllegalArgumentException("Book not available");
        }
        reservations.put(title, reservations.getOrDefault(title, 0) + 1);
    }

    public boolean borrowBook(String title, boolean isReserved) {
        if (!books.containsKey(title) || books.get(title) == 0) {
            return false; // Book not available
        }

        if (isReserved) {
            if (reservations.getOrDefault(title, 0) == 0) {
                return false; // No reservations available
            }
            reservations.put(title, reservations.get(title) - 1);
        }

        books.put(title, books.get(title) - 1);
        return true;
    }

    public int getAvailableCopies(String title) {
        return books.getOrDefault(title, 0);
    }

    public int getReservations(String title) {
        return reservations.getOrDefault(title, 0);
    }
}
