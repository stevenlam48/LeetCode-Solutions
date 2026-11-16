package designordermanagementsystem

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DesignOrderManagementSystemTest {
    @Test
    fun testExample() {
        val system = OrderManagementSystem()
        system.addOrder(1, "A", 100)
        system.addOrder(2, "A", 100)
        system.addOrder(3, "B", 200)
        assertArrayEquals(intArrayOf(1, 2), system.getOrdersAtPrice("A", 100))
        system.cancelOrder(1)
        assertArrayEquals(intArrayOf(2), system.getOrdersAtPrice("A", 100))
        system.modifyOrder(2, 300)
        assertArrayEquals(intArrayOf(), system.getOrdersAtPrice("A", 100))
        assertArrayEquals(intArrayOf(2), system.getOrdersAtPrice("A", 300))
        assertArrayEquals(intArrayOf(3), system.getOrdersAtPrice("B", 200))
        system.cancelOrder(3)
        assertArrayEquals(intArrayOf(), system.getOrdersAtPrice("B", 200))
    }

    @Test
    fun testCancelMiddleOrderKeepsOthers() {
        val system = OrderManagementSystem()
        system.addOrder(1, "A", 10)
        system.addOrder(2, "A", 10)
        system.addOrder(3, "A", 10)
        assertArrayEquals(intArrayOf(1, 2, 3), system.getOrdersAtPrice("A", 10))
        system.cancelOrder(2)
        assertArrayEquals(intArrayOf(1, 3), system.getOrdersAtPrice("A", 10))
        system.cancelOrder(1)
        assertArrayEquals(intArrayOf(3), system.getOrdersAtPrice("A", 10))
        system.cancelOrder(3)
        assertArrayEquals(intArrayOf(), system.getOrdersAtPrice("A", 10))
    }

    @Test
    fun testUnknownTypeOrPrice() {
        val system = OrderManagementSystem()
        system.addOrder(1, "A", 10)
        assertArrayEquals(intArrayOf(), system.getOrdersAtPrice("X", 10))
        assertArrayEquals(intArrayOf(), system.getOrdersAtPrice("A", 20))
    }

    @Test
    fun testModifyToSamePrice() {
        val system = OrderManagementSystem()
        system.addOrder(1, "A", 10)
        system.addOrder(2, "A", 10)
        system.modifyOrder(1, 10)
        assertArrayEquals(intArrayOf(2, 1), system.getOrdersAtPrice("A", 10))
    }

    @Test
    fun testModifyChangesTypePreserved() {
        val system = OrderManagementSystem()
        system.addOrder(7, "B", 5)
        system.modifyOrder(7, 50)
        assertArrayEquals(intArrayOf(), system.getOrdersAtPrice("B", 5))
        assertArrayEquals(intArrayOf(7), system.getOrdersAtPrice("B", 50))
    }
}
