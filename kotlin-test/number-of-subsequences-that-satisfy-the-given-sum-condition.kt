package numberofsubsequencesthatsatisfythegivensumcondition

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSubsequencesThatSatisfyTheGivenSumConditionTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(4, solution.numSubseq(intArrayOf(3, 5, 6, 7), 9))
    }

    @Test
    fun exampleTwo() {
        assertEquals(6, solution.numSubseq(intArrayOf(3, 3, 6, 8), 10))
    }

    @Test
    fun exampleThree() {
        assertEquals(61, solution.numSubseq(intArrayOf(2, 3, 3, 4, 6, 7), 12))
    }

    @Test
    fun empty() {
        assertEquals(0, solution.numSubseq(intArrayOf(), 0))
    }
}
