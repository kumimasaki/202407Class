package todo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

    @BeforeEach
    void setUp() {
        // ToDoアイテムの配列とカウントをリセット
        Main.todoItems = new ToDoItem[10];
        Main.itemCount = 0;
    }

    @Test
    void testAddToDoItem() {
        ToDoItem newItem = new ToDoItem("Test Title", "Test Description");
        Main.todoItems[0] = newItem;
        Main.itemCount++;

        assertEquals(1, Main.itemCount, "Item count should be 1 after adding an item");
        assertEquals("Test Title", Main.todoItems[0].getTitle(), "Title of the first item should match");
        assertEquals("Test Description", Main.todoItems[0].getDescription(), "Description of the first item should match");
    }

    @Test
    void testRemoveItem() {
        // ToDoアイテムを追加して削除
        ToDoItem newItem = new ToDoItem("Test Title", "Test Description");
        Main.todoItems[0] = newItem;
        Main.itemCount++;

        // 最初のアイテムを削除
        Main.removeItem(0);

        assertEquals(0, Main.itemCount, "Item count should be 0 after removing the item");
        assertNull(Main.todoItems[0], "First item should be null after removal");
    }

    @Test
    void testMarkItemAsCompleted() {
        // ToDoアイテムを追加して完了としてマーク
        ToDoItem newItem = new ToDoItem("Test Title", "Test Description");
        Main.todoItems[0] = newItem;
        Main.itemCount++;

        // 最初のアイテムを完了としてマーク
        Main.markItemAsCompleted(0);

        assertTrue(Main.todoItems[0].isCompleted(), "First item should be marked as completed");
    }

//    @Test
//    void testDisplayItems_emptyList() {
//        // ToDoリストが空の場合
//        assertEquals("ToDo List is empty.", Main.displayItems(), "Display should show empty message when list is empty");
//    }

//    @Test
//    void testDisplayItems_withItems() {
//        // ToDoアイテムを複数追加
//        ToDoItem newItem1 = new ToDoItem("Title 1", "Description 1");
//        ToDoItem newItem2 = new ToDoItem("Title 2", "Description 2");
//        Main.todoItems[0] = newItem1;
//        Main.todoItems[1] = newItem2;
//        Main.itemCount = 2;
//
//        String expectedOutput = "ToDo List:\n1. " + newItem1.toString() + "\n2. " + newItem2.toString();
//        assertEquals(expectedOutput, Main.displayItems(), "Display should show all items in the list");
//    }
}
