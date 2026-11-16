package findcommonelementsbetweentwoarrays

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindCommonElementsBetweenTwoArraysTest {
    @Test
    fun standardExample() {
        assertArrayEquals(
            intArrayOf(2, 1),
            Solution().findIntersectionValues(intArrayOf(2, 3, 2), intArrayOf(1, 2))
        )
    }

    @Test
    fun secondExample() {
        assertArrayEquals(
            intArrayOf(3, 4),
            Solution().findIntersectionValues(intArrayOf(4, 3, 2, 3, 1), intArrayOf(2, 2, 5, 2, 3, 6))
        )
    }

    @Test
    fun noCommonElements() {
        assertArrayEquals(
            intArrayOf(0, 0),
            Solution().findIntersectionValues(intArrayOf(3, 4, 2, 3), intArrayOf(1, 5))
        )
    }

    @Test
    fun duplicatesCounted() {
        assertArrayEquals(
            intArrayOf(3, 2),
            Solution().findIntersectionValues(intArrayOf(1, 1, 1), intArrayOf(1, 1))
        )
    }
}
