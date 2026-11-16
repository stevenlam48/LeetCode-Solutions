package orderlyqueue

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OrderlyQueueTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("acb", solution.orderlyQueue("cba", 1))
    }

    @Test
    fun testExample2() {
        assertEquals("aaabc", solution.orderlyQueue("baaca", 3))
    }

    @Test
    fun testSingleChar() {
        assertEquals("a", solution.orderlyQueue("a", 1))
    }

    @Test
    fun testAlreadySorted() {
        assertEquals("abc", solution.orderlyQueue("abc", 1))
    }
}
