package maximumgeneticdifferencequery

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximumGeneticDifferenceQueryTest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(2, 3, 7),
            Solution().maxGeneticDifference(
                intArrayOf(-1, 0, 1, 1),
                arrayOf(intArrayOf(0, 2), intArrayOf(3, 2), intArrayOf(2, 5))
            )
        )
    }

    @Test
    fun example2() {
        assertArrayEquals(
            intArrayOf(6, 14, 7),
            Solution().maxGeneticDifference(
                intArrayOf(3, 7, -1, 2, 0, 7, 0, 2),
                arrayOf(intArrayOf(4, 6), intArrayOf(1, 15), intArrayOf(0, 5))
            )
        )
    }

    @Test
    fun rootOnly() {
        assertArrayEquals(
            intArrayOf(0),
            Solution().maxGeneticDifference(intArrayOf(-1, 0), arrayOf(intArrayOf(0, 0)))
        )
    }

    @Test
    fun queryAtLeaf() {
        assertArrayEquals(
            intArrayOf(2),
            Solution().maxGeneticDifference(intArrayOf(-1, 0, 1), arrayOf(intArrayOf(2, 0)))
        )
    }
}
