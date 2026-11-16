package numberofsubarrayswithgcdequaltok

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSubarraysWithGcdEqualToKTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(4, solution.subarrayGCD(intArrayOf(9, 3, 1, 2, 6, 3), 3))
    }

    @Test
    fun gcdOne() {
        assertEquals(4, solution.subarrayGCD(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun nonMultipleInterruptsRun() {
        assertEquals(3, solution.subarrayGCD(intArrayOf(2, 4, 5, 6, 10), 2))
    }

    @Test
    fun empty() {
        assertEquals(0, solution.subarrayGCD(intArrayOf(), 2))
    }
}
