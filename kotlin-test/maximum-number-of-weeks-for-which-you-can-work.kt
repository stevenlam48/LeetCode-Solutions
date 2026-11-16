package maximumnumberofweeksforwhichyoucanwork

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberofweeksforwhichyoucanworkTest {
    @Test
    fun example1() {
        assertEquals(6L, Solution().numberOfWeeks(intArrayOf(1, 2, 3)))
    }

    @Test
    fun example2() {
        assertEquals(7L, Solution().numberOfWeeks(intArrayOf(5, 2, 1)))
    }

    @Test
    fun singleMilestone() {
        assertEquals(1L, Solution().numberOfWeeks(intArrayOf(1)))
    }

    @Test
    fun balancedMilestones() {
        assertEquals(6L, Solution().numberOfWeeks(intArrayOf(3, 3)))
    }
}
