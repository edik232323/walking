import java.util.Scanner;

public class Edify {
    static String[] titles = new String[100];
    static String[] authors = new String[100];
    static double[] prices = new double[100];
    static int[] stocks = new int[100];
    static int songCount = 0;
// создал массивы для харнения
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nEdify Menu:");
            System.out.println("1. Add Song");
            System.out.println("2. Display Songs");
            System.out.println("3. Search For Song");
            System.out.println("4. Update Number Of Views");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();  // сохранить выбор в choice
            scanner.nextLine();

            if (choice == 1) {
                addSong(scanner);
            } else if (choice == 2) {
                displaySongs();
            } else if (choice == 3) {
                searchSongs(scanner);
            } else if (choice == 4) {
                updateViews(scanner);
            } else if (choice == 5) {
                running = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // создание
    public static void addSong(Scanner scanner) {
        if (songCount >= titles.length) {
            System.out.println("No more space to add songs.");
            return;
        }

        System.out.print("Enter song title: ");
        titles[songCount] = scanner.nextLine();
        System.out.print("Enter author: ");
        authors[songCount] = scanner.nextLine();
        System.out.print("Enter price: ");
        prices[songCount] = scanner.nextDouble();
        System.out.print("Enter views: ");
        stocks[songCount] = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Song added successfully.");
        songCount++;
    }

    // показать
   public static void displaySongs() {
        for (int i = 0; i < songCount; i++) {
            System.out.println("\n title: " + titles[i] + "\n author: " + authors[i] + "\n price: " + prices[i] + "\n views: " + stocks[i]);

        }
   }
    // поиск
    public static void searchSongs(Scanner scanner) {
        System.out.print("Enter title to search: ");
        String searchTitle = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < songCount; i++) {
            if (titles[i].equalsIgnoreCase(searchTitle)) {
                System.out.println("Song found: Title: " + titles[i] + ", Author: " + authors[i] +
                        ", Price: $" + prices[i] + ", Views: " + stocks[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Song not found.");
        }
    }

    // обновить количество просмотров
    public static void updateViews(Scanner scanner) {
        System.out.print("Enter title to update views: ");
        String updateTitle = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < songCount; i++) {
            if (titles[i].equalsIgnoreCase(updateTitle)) {
                System.out.print("Enter new views amount: ");
                stocks[i] = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                System.out.println("Views updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Song not found.");
        }
    }
}
