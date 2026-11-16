package numberofsingledivisortriplets

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfSingleDivisorTripletsTest {
    @Test
    fun testExample1() {
        assertEquals(6L, Solution().singleDivisorTriplet(intArrayOf(1, 2, 4)))
    }

    @Test
    fun testNoTriplets() {
        assertEquals(0L, Solution().singleDivisorTriplet(intArrayOf(1, 2, 3)))
        assertEquals(0L, Solution().singleDivisorTriplet(intArrayOf(4, 6, 7)))
    }

    @Test
    fun testDuplicates() {
        assertEquals(0L, Solution().singleDivisorTriplet(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testMixed() {
        assertEquals(6L, Solution().singleDivisorTriplet(intArrayOf(2, 3, 4, 6)))
    }
}
