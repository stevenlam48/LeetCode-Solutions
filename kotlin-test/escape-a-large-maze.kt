package escapealargemaze

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EscapeALargeMazeTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertFalse(
            solution.isEscapePossible(
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)),
                intArrayOf(0, 0),
                intArrayOf(0, 2)
            )
        )
    }

    @Test
    fun testExample2() {
        assertTrue(
            solution.isEscapePossible(
                arrayOf(),
                intArrayOf(0, 0),
                intArrayOf(999999, 999999)
            )
        )
    }

    @Test
    fun testExample3() {
        assertFalse(
            solution.isEscapePossible(
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)),
                intArrayOf(0, 0),
                intArrayOf(1, 1)
            )
        )
    }

    @Test
    fun testSmallBlockedArea() {
        assertTrue(
            solution.isEscapePossible(
                arrayOf(intArrayOf(0, 1)),
                intArrayOf(0, 0),
                intArrayOf(0, 2)
            )
        )
    }

    @Test
    fun testEnclosedSource() {
        assertFalse(
            solution.isEscapePossible(
                arrayOf(
                    intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(1, 1)
                ),
                intArrayOf(0, 0),
                intArrayOf(5, 5)
            )
        )
    }
}
