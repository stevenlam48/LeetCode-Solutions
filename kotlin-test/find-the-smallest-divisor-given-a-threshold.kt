package findthesmallestdivisorgivenathreshold

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheSmallestDivisorGivenAThresholdTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(5, solution.smallestDivisor(intArrayOf(1, 2, 5, 9), 6))
    }

    @Test
    fun testExample2() {
        assertEquals(44, solution.smallestDivisor(intArrayOf(44, 22, 33, 11, 1), 5))
    }

    @Test
    fun testLargeThreshold() {
        assertEquals(1, solution.smallestDivisor(intArrayOf(21212, 10101, 12121), 1000000))
    }

    @Test
    fun testSingleElement() {
        assertEquals(7, solution.smallestDivisor(intArrayOf(7), 1))
        assertEquals(1, solution.smallestDivisor(intArrayOf(7), 7))
    }

    @Test
    fun testDuplicates() {
        assertEquals(3, solution.smallestDivisor(intArrayOf(2, 3, 5, 7, 11), 11))
    }
}
