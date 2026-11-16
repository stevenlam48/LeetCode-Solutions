package canmakearithmeticprogressionfromsequence

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CanMakeArithmeticProgressionFromSequenceTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.canMakeArithmeticProgression(intArrayOf(3, 5, 1)))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.canMakeArithmeticProgression(intArrayOf(1, 2, 4)))
    }

    @Test
    fun testAlreadyProgression() {
        assertTrue(solution.canMakeArithmeticProgression(intArrayOf(1, 2, 3, 4)))
        assertTrue(solution.canMakeArithmeticProgression(intArrayOf(1, 3, 5)))
    }

    @Test
    fun testAllEqual() {
        assertTrue(solution.canMakeArithmeticProgression(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testNegatives() {
        assertTrue(solution.canMakeArithmeticProgression(intArrayOf(-5, -1, 3)))
        assertFalse(solution.canMakeArithmeticProgression(intArrayOf(-5, -1, 4)))
    }
}
