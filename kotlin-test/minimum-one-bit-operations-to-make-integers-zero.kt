package minimumonebitoperationstomakeintegerszero

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumOneBitOperationsToMakeIntegersZeroTest {

    @Test
    fun testExample1() {
        assertEquals(2, Solution().minimumOneBitOperations(3))
    }

    @Test
    fun testExample2() {
        assertEquals(4, Solution().minimumOneBitOperations(6))
    }

    @Test
    fun testZero() {
        assertEquals(0, Solution().minimumOneBitOperations(0))
    }

    @Test
    fun testOne() {
        assertEquals(1, Solution().minimumOneBitOperations(1))
    }

    @Test
    fun testSmallValues() {
        val solution = Solution()
        assertEquals(3, solution.minimumOneBitOperations(2))
        assertEquals(7, solution.minimumOneBitOperations(4))
        assertEquals(6, solution.minimumOneBitOperations(5))
    }

    @Test
    fun testLargerValue() {
        assertEquals(14, Solution().minimumOneBitOperations(9))
    }
}
