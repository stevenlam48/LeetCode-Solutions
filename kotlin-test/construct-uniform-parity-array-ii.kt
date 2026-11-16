package constructuniformparityarrayii

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ConstructUniformParityArrayIiTest {
    @Test
    fun oddMinimumMakesUniformArrayPossible() {
        assertTrue(Solution().uniformArray(intArrayOf(3, 4, 6)))
    }

    @Test
    fun allEvenValuesAreAlreadyUniform() {
        assertTrue(Solution().uniformArray(intArrayOf(2, 4, 8)))
    }

    @Test
    fun evenMinimumWithOddValueIsImpossible() {
        assertFalse(Solution().uniformArray(intArrayOf(2, 4, 5)))
    }

    @Test
    fun singleOddValueIsPossible() {
        assertTrue(Solution().uniformArray(intArrayOf(7)))
    }
}
