package smallestmissingintegergreaterthansequentialprefixsum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestMissingIntegerGreaterThanSequentialPrefixSumTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(6, solution.missingInteger(intArrayOf(1, 2, 3, 2, 5)))
    }

    @Test
    fun testExample2() {
        assertEquals(15, solution.missingInteger(intArrayOf(3, 4, 5, 1, 12, 14, 13)))
    }

    @Test
    fun testExample3() {
        assertEquals(15, solution.missingInteger(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(2, solution.missingInteger(intArrayOf(1)))
    }

    @Test
    fun testPrefixSumPresent() {
        assertEquals(3, solution.missingInteger(intArrayOf(1, 2, 4)))
    }
}
