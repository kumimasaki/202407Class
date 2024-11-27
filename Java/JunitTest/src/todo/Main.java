package todo;

import java.util.Scanner;

public class Main {
	public static ToDoItem[] todoItems = new ToDoItem[10];
	public static int itemCount = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nChoose an option:");
			System.out.println("1. Add ToDo Item");
			System.out.println("2. Remove ToDo Item");
			System.out.println("3. Mark ToDo Item as Completed");
			System.out.println("4. Display ToDo List");
			System.out.println("5. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline character

			switch (choice) {
			case 1:
				if (itemCount < todoItems.length) {
					System.out.print("Enter title: ");
					String title = scanner.nextLine();
					System.out.print("Enter description: ");
					String description = scanner.nextLine();
					ToDoItem newItem = new ToDoItem(title, description);
					todoItems[itemCount] = newItem;
					itemCount++;
				} else {
					System.out.println("ToDo List is full!");
				}
				break;
			case 2:
				System.out.print("Enter index of item to remove: ");
				int removeIndex = scanner.nextInt();
				removeItem(removeIndex - 1); // Adjust index to 0-based
				break;
			case 3:
				System.out.print("Enter index of item to mark as completed: ");
				int completeIndex = scanner.nextInt();
				markItemAsCompleted(completeIndex - 1); // Adjust index to 0-based
				break;
			case 4:
				displayItems();
				break;
			case 5:
				System.out.println("Exiting program...");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice! Please enter a number between 1 and 5.");
			}
		}
	}

	public static void removeItem(int index) {
		if (index >= 0 && index < itemCount) {
			for (int i = index; i < itemCount - 1; i++) {
				todoItems[i] = todoItems[i + 1];
			}
			todoItems[itemCount - 1] = null;
			itemCount--;
		} else {
			System.out.println("Invalid index!");
		}
	}

	public static void markItemAsCompleted(int index) {
		if (index >= 0 && index < itemCount) {
			ToDoItem item = todoItems[index];
			item.markAsCompleted();
		} else {
			System.out.println("Invalid index!");
		}
	}

	public static void displayItems() {
		if (itemCount == 0) {
			System.out.println("ToDo List is empty.");
		} else {
			System.out.println("ToDo List:");
			for (int i = 0; i < itemCount; i++) {
				ToDoItem item = todoItems[i];
				System.out.println((i + 1) + ". " + item);
			}
		}
	}
}