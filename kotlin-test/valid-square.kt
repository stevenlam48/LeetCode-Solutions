package validsquare

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidSquareTest {
    @Test
    fun leetCodeSquareExample() {
        assertTrue(
            Solution().validSquare(
                intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(1, 0), intArrayOf(0, 1)
            )
        )
    }

    @Test
    fun leetCodeNonSquareExample() {
        assertFalse(
            Solution().validSquare(
                intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(1, 0), intArrayOf(0, 12)
            )
        )
    }

    @Test
    fun diamondOrientedSquare() {
        assertTrue(
            Solution().validSquare(
                intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1)
            )
        )
    }

    @Test
    fun translatedSquare() {
        assertTrue(
            Solution().validSquare(
                intArrayOf(1, 1), intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 2)
            )
        )
    }

    @Test
    fun duplicatePoints() {
        assertFalse(
            Solution().validSquare(
                intArrayOf(0, 0), intArrayOf(0, 0), intArrayOf(0, 0), intArrayOf(0, 0)
            )
        )
    }
}
