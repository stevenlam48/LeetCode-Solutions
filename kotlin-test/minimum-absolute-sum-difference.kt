package minimumabsolutesumdifference

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAbsoluteSumDifferenceTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().minAbsoluteSumDiff(intArrayOf(1, 7, 5), intArrayOf(2, 3, 5)))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().minAbsoluteSumDiff(intArrayOf(2, 4, 6, 8, 10), intArrayOf(2, 4, 6, 8, 10)))
    }

    @Test
    fun example3() {
        assertEquals(
            20,
            Solution().minAbsoluteSumDiff(intArrayOf(1, 10, 4, 4, 2, 7), intArrayOf(9, 3, 5, 1, 7, 4))
        )
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().minAbsoluteSumDiff(intArrayOf(1), intArrayOf(1)))
    }

    @Test
    fun noImprovement() {
        assertEquals(2, Solution().minAbsoluteSumDiff(intArrayOf(1, 1), intArrayOf(2, 2)))
    }
}
