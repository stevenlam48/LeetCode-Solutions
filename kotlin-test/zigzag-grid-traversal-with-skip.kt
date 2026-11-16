package zigzaggridtraversalwithskip

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ZigzagGridTraversalWithSkipTest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(1, 4),
            Solution().zigzagTraversal(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))),
        )
    }

    @Test
    fun example2() {
        assertArrayEquals(
            intArrayOf(1, 3, 5, 7, 9),
            Solution().zigzagTraversal(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9),
                ),
            ),
        )
    }

    @Test
    fun evenNumberOfColumns() {
        assertArrayEquals(
            intArrayOf(1, 3, 8, 6),
            Solution().zigzagTraversal(
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                ),
            ),
        )
    }

    @Test
    fun singleRow() {
        assertArrayEquals(
            intArrayOf(1, 3),
            Solution().zigzagTraversal(arrayOf(intArrayOf(1, 2, 3))),
        )
    }

    @Test
    fun singleColumn() {
        assertArrayEquals(
            intArrayOf(1, 3),
            Solution().zigzagTraversal(
                arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3)),
            ),
        )
    }
}
