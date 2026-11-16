package findtimerequiredtoeliminatebacterialstrains

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTimeRequiredToEliminateBacterialStrainsTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3L, solution.minEliminationTime(intArrayOf(1, 2), 1))
    }

    @Test
    fun testExample2() {
        assertEquals(4L, solution.minEliminationTime(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun testSingleStrain() {
        assertEquals(5L, solution.minEliminationTime(intArrayOf(5), 100))
    }

    @Test
    fun testZeroSplitTime() {
        assertEquals(9L, solution.minEliminationTime(intArrayOf(1, 4, 9), 0))
    }

    @Test
    fun testUnsortedInput() {
        assertEquals(8L, solution.minEliminationTime(intArrayOf(5, 1, 4, 2), 2))
    }
}
