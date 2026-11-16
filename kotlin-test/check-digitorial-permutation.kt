package checkdigitorialpermutation

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckDigitorialPermutationTest {
    private val solution = Solution()

    @Test
    fun digitorialNumber() {
        assertTrue(solution.isDigitorialPermutation(145))
    }

    @Test
    fun permutedDigitorialDigits() {
        assertTrue(solution.isDigitorialPermutation(415))
    }

    @Test
    fun largerDigitorialNumber() {
        assertTrue(solution.isDigitorialPermutation(40585))
    }

    @Test
    fun differentDigitsAfterSumming() {
        assertFalse(solution.isDigitorialPermutation(123))
        assertFalse(solution.isDigitorialPermutation(540))
    }

    @Test
    fun singleDigits() {
        assertTrue(solution.isDigitorialPermutation(0))
        assertTrue(solution.isDigitorialPermutation(1))
        assertTrue(solution.isDigitorialPermutation(2))
        assertFalse(solution.isDigitorialPermutation(3))
    }
}
