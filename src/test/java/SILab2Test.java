import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class SILab2Test {

    @Test
    void testMultipleConditions() {
        // Тест случај 1
        List<Item> items1 = new ArrayList<>();
        items1.add(new Item("item1", "012345", 400, 0.1f));
        assertTrue(SILab2.checkCart(items1, 370));

        // Тест случај 2
        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("item1", "112345", 400, 0.1f));
        assertTrue(SILab2.checkCart(items2, 40));

        // Тест случај 3
        List<Item> items3 = new ArrayList<>();
        items3.add(new Item("item1", "012345", 400, 0.0f));
        assertTrue(SILab2.checkCart(items3, 400));

        // Тест случај 4
        List<Item> items4 = new ArrayList<>();
        items4.add(new Item("item1", "112345", 400, 0.0f));
        assertTrue(SILab2.checkCart(items4, 400));

        // Тест случај 5
        List<Item> items5 = new ArrayList<>();
        items5.add(new Item("item1", "012345", 200, 0.1f));
        assertTrue(SILab2.checkCart(items5, 20));

        // Тест случај 6
        List<Item> items6 = new ArrayList<>();
        items6.add(new Item("item1", "112345", 200, 0.1f));
        assertTrue(SILab2.checkCart(items6, 20));

        // Тест случај 7
        List<Item> items7 = new ArrayList<>();
        items7.add(new Item("item1", "012345", 200, 0.0f));
        assertTrue(SILab2.checkCart(items7, 200));

        // Тест случај 8
        List<Item> items8 = new ArrayList<>();
        items8.add(new Item("item1", "112345", 200, 0.0f));
        assertTrue(SILab2.checkCart(items8, 200));
    }

    @Test
    void testBranchCoverage() {
        // Тест случај за Branch 1 (allItems == null)
        List<Item> items1 = null;
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items1, 100);
        });
        assertEquals("allItems list can't be null!", exception.getMessage());

        // Тест случај за Branch 2 (valid items list)
        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("item1", "123456", 100, 0.1f));
        items2.add(new Item("item2", "789012", 150, 0.2f));
        items2.add(new Item("item3", "345678", 200, 0.0f));
        assertTrue(SILab2.checkCart(items2, 65)); // 10 + 30 + 200 <= 65 should return true
    }
}
