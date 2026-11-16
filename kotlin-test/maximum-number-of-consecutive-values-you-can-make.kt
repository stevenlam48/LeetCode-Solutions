package maximumnumberofconsecutivevaluesyoucanmake

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfConsecutiveValuesYouCanMakeTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(2, solution.getMaximumConsecutive(intArrayOf(1, 3)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(8, solution.getMaximumConsecutive(intArrayOf(1, 1, 1, 4)))
    }

    @Test
    fun exampleThree() {
        assertEquals(20, solution.getMaximumConsecutive(intArrayOf(1, 4, 10, 3, 1)))
    }

    @Test
    fun singleOne() {
        assertEquals(2, solution.getMaximumConsecutive(intArrayOf(1)))
    }

    @Test
    fun gapAtStart() {
        assertEquals(1, solution.getMaximumConsecutive(intArrayOf(2)))
    }

    @Test
    fun allOnes() {
        assertEquals(5, solution.getMaximumConsecutive(intArrayOf(1, 1, 1, 1)))
    }
}
