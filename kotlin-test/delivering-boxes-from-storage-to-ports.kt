package deliveringboxesfromstoragetoports

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DeliveringBoxesFromStorageToPortsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val boxes = arrayOf(intArrayOf(1, 1), intArrayOf(2, 1), intArrayOf(1, 1))
        assertEquals(4, solution.boxDelivering(boxes, 2, 3, 3))
    }

    @Test
    fun testExample2() {
        val boxes = arrayOf(
            intArrayOf(1, 2), intArrayOf(3, 3), intArrayOf(3, 1), intArrayOf(3, 1), intArrayOf(2, 4)
        )
        assertEquals(6, solution.boxDelivering(boxes, 3, 3, 6))
    }

    @Test
    fun testExample3() {
        val boxes = arrayOf(
            intArrayOf(1, 4), intArrayOf(1, 2), intArrayOf(2, 1),
            intArrayOf(2, 1), intArrayOf(3, 2), intArrayOf(3, 4)
        )
        assertEquals(6, solution.boxDelivering(boxes, 3, 6, 7))
    }

    @Test
    fun testSingleBox() {
        val boxes = arrayOf(intArrayOf(1, 1))
        assertEquals(2, solution.boxDelivering(boxes, 1, 1, 1))
    }

    @Test
    fun testSamePort() {
        val boxes = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1), intArrayOf(1, 1))
        assertEquals(2, solution.boxDelivering(boxes, 1, 3, 3))
    }
}
