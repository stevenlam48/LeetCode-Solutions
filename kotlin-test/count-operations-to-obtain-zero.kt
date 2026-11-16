package countoperationstoobtainzero

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountOperationsToObtainZeroTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.countOperations(2, 3))
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.countOperations(10, 10))
    }

    @Test
    fun testZeroFirst() {
        assertEquals(0, solution.countOperations(0, 5))
    }

    @Test
    fun testZeroSecond() {
        assertEquals(0, solution.countOperations(5, 0))
    }

    @Test
    fun testOneAndOne() {
        assertEquals(1, solution.countOperations(1, 1))
    }
}
