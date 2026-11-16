package threeconsecutiveodds

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ThreeConsecutiveOddsTest {
    private val solution = Solution()

    @Test
    fun interruptedByEvenNumber() {
        assertFalse(solution.threeConsecutiveOdds(intArrayOf(2, 6, 4, 1)))
    }

    @Test
    fun containsThreeConsecutiveOdds() {
        assertTrue(solution.threeConsecutiveOdds(intArrayOf(1, 2, 34, 3, 4, 5, 7, 23, 12)))
    }

    @Test
    fun onlyThreeElements() {
        assertTrue(solution.threeConsecutiveOdds(intArrayOf(1, 3, 5)))
    }

    @Test
    fun emptyInput() {
        assertFalse(solution.threeConsecutiveOdds(intArrayOf()))
    }
}
