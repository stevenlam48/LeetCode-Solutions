package minimumoperationstoconvertnumber

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumOperationsToConvertNumberTest {

    @Test
    fun testExample1() {
        assertEquals(2, Solution().minimumOperations(intArrayOf(2, 4, 12), 2, 12))
    }

    @Test
    fun testExample2() {
        assertEquals(2, Solution().minimumOperations(intArrayOf(3, 5, 7), 0, -4))
    }

    @Test
    fun testExample3() {
        assertEquals(-1, Solution().minimumOperations(intArrayOf(2, 8, 16), 0, 1))
    }

    @Test
    fun testRepeatedAddition() {
        assertEquals(3, Solution().minimumOperations(intArrayOf(1), 0, 3))
    }

    @Test
    fun testTwoSteps() {
        assertEquals(2, Solution().minimumOperations(intArrayOf(1, 2), 0, 3))
    }

    @Test
    fun testZeroIgnored() {
        assertEquals(-1, Solution().minimumOperations(intArrayOf(0), 0, 5))
    }
}
