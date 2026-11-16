package minimumlimitofballsinabag

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumLimitOfBallsInABagTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.minimumSize(intArrayOf(9), 2))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.minimumSize(intArrayOf(2, 4, 8, 2), 4))
    }

    @Test
    fun testNoOperations() {
        assertEquals(7, solution.minimumSize(intArrayOf(7), 0))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, solution.minimumSize(intArrayOf(1), 0))
    }

    @Test
    fun testManyOperations() {
        assertEquals(1, solution.minimumSize(intArrayOf(5), 4))
    }

    @Test
    fun testMultipleBags() {
        assertEquals(4, solution.minimumSize(intArrayOf(4, 4), 0))
    }
}
