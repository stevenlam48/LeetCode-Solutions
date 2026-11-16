package countwaystogroupoverlappingranges

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountWaysToGroupOverlappingRangesTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().countWays(arrayOf(intArrayOf(6, 10), intArrayOf(5, 15))))
    }

    @Test
    fun example2() {
        assertEquals(
            4,
            Solution().countWays(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(10, 20),
                    intArrayOf(2, 5),
                    intArrayOf(4, 8)
                )
            )
        )
    }

    @Test
    fun singleRange() {
        assertEquals(2, Solution().countWays(arrayOf(intArrayOf(1, 2))))
    }

    @Test
    fun twoGroups() {
        assertEquals(
            4,
            Solution().countWays(
                arrayOf(
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(4, 6),
                    intArrayOf(7, 8)
                )
            )
        )
    }

    @Test
    fun disjointRanges() {
        assertEquals(
            8,
            Solution().countWays(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(3, 3)
                )
            )
        )
    }
}
