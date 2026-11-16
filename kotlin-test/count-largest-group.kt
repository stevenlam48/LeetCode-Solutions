package countlargestgroup

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountLargestGroupTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(4, solution.countLargestGroup(13))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.countLargestGroup(2))
    }

    @Test
    fun testSingle() {
        assertEquals(1, solution.countLargestGroup(1))
    }

    @Test
    fun testSingleDigits() {
        assertEquals(9, solution.countLargestGroup(9))
    }
}
