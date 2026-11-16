package findminimumoperationstomakeallelementsdivisiblebythree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMinimumOperationsToMakeAllElementsDivisibleByThreeTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().minimumOperations(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().minimumOperations(intArrayOf(3, 6, 9)))
    }

    @Test
    fun example3() {
        assertEquals(4, Solution().minimumOperations(intArrayOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun emptyArray() {
        assertEquals(0, Solution().minimumOperations(intArrayOf()))
    }

    @Test
    fun negatives() {
        assertEquals(2, Solution().minimumOperations(intArrayOf(-1, -3, -2)))
    }

    @Test
    fun singleNonDivisible() {
        assertEquals(1, Solution().minimumOperations(intArrayOf(1)))
    }
}
