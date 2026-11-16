package displaytableoffoodordersinarestaurant

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DisplayTableOfFoodOrdersInARestaurantTest {
    @Test
    fun testExample1() {
        val orders = listOf(
            listOf("David", "3", "Ceviche"),
            listOf("Corina", "10", "Beef Burrito"),
            listOf("David", "3", "Fried Chicken"),
            listOf("Carla", "5", "Water"),
            listOf("Carla", "5", "Ceviche"),
            listOf("Rous", "3", "Ceviche")
        )
        val expected = listOf(
            listOf("Table", "Beef Burrito", "Ceviche", "Fried Chicken", "Water"),
            listOf("3", "0", "2", "1", "0"),
            listOf("5", "0", "1", "0", "1"),
            listOf("10", "1", "0", "0", "0")
        )
        assertEquals(expected, Solution().displayTable(orders))
    }

    @Test
    fun testExample2() {
        val orders = listOf(
            listOf("James", "12", "Fried Chicken"),
            listOf("Ratesh", "12", "Fried Chicken"),
            listOf("Amadeus", "12", "Fried Chicken"),
            listOf("Adam", "1", "Canadian Waffles"),
            listOf("Brianna", "1", "Canadian Waffles")
        )
        val expected = listOf(
            listOf("Table", "Canadian Waffles", "Fried Chicken"),
            listOf("1", "2", "0"),
            listOf("12", "0", "3")
        )
        assertEquals(expected, Solution().displayTable(orders))
    }

    @Test
    fun testSingleOrder() {
        val orders = listOf(listOf("A", "2", "Pizza"))
        val expected = listOf(
            listOf("Table", "Pizza"),
            listOf("2", "1")
        )
        assertEquals(expected, Solution().displayTable(orders))
    }

    @Test
    fun testTableOrdering() {
        val orders = listOf(
            listOf("A", "10", "X"),
            listOf("B", "2", "X"),
            listOf("C", "1", "X")
        )
        val expected = listOf(
            listOf("Table", "X"),
            listOf("1", "1"),
            listOf("2", "1"),
            listOf("10", "1")
        )
        assertEquals(expected, Solution().displayTable(orders))
    }
}
