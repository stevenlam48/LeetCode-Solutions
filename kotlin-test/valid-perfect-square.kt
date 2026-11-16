package validperfectsquare

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidPerfectSquareTest {
    @Test
    fun leetCodeSquareExamples() {
        assertTrue(Solution().isPerfectSquare(16))
        assertFalse(Solution().isPerfectSquare(14))
    }

    @Test
    fun oneAndSmallSquares() {
        assertTrue(Solution().isPerfectSquare(1))
        assertTrue(Solution().isPerfectSquare(4))
        assertTrue(Solution().isPerfectSquare(9))
        assertFalse(Solution().isPerfectSquare(2))
    }

    @Test
    fun largeSquares() {
        assertTrue(Solution().isPerfectSquare(808201))
        assertTrue(Solution().isPerfectSquare(2147395600))
    }

    @Test
    fun intMaxValueIsNotASquare() {
        assertFalse(Solution().isPerfectSquare(2147483647))
    }
}
