package maximumcandiesyoucangetfromboxes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumCandiesYouCanGetFromBoxesTest {
    @Test
    fun example() {
        assertEquals(
            16,
            Solution().maxCandies(
                intArrayOf(1, 0, 1, 0),
                intArrayOf(7, 5, 4, 100),
                listOf(emptyList(), emptyList(), listOf(1), emptyList()),
                listOf(listOf(1, 2), listOf(3), emptyList(), emptyList()),
                intArrayOf(0)
            )
        )
    }

    @Test
    fun allBoxesReachable() {
        assertEquals(
            6,
            Solution().maxCandies(
                intArrayOf(1, 0, 0, 0, 0, 0),
                intArrayOf(1, 1, 1, 1, 1, 1),
                listOf(listOf(1, 2, 3, 4, 5), emptyList(), emptyList(), emptyList(), emptyList(), emptyList()),
                listOf(listOf(1, 2, 3, 4, 5), emptyList(), emptyList(), emptyList(), emptyList(), emptyList()),
                intArrayOf(0)
            )
        )
    }

    @Test
    fun allInitiallyOpen() {
        assertEquals(
            7,
            Solution().maxCandies(
                intArrayOf(1, 1, 1),
                intArrayOf(2, 3, 2),
                listOf(emptyList(), emptyList(), emptyList()),
                listOf(emptyList(), emptyList(), emptyList()),
                intArrayOf(2, 1, 0)
            )
        )
    }

    @Test
    fun lockedBoxWithoutKey() {
        assertEquals(
            0,
            Solution().maxCandies(
                intArrayOf(0),
                intArrayOf(5),
                listOf(emptyList()),
                listOf(emptyList()),
                intArrayOf(0)
            )
        )
    }
}
