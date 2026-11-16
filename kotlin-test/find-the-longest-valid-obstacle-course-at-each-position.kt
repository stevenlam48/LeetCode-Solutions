package findthelongestvalidobstaclecourseateachposition

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindTheLongestValidObstacleCourseAtEachPositionTest {
    @Test
    fun nonDecreaseAllowsEqualHeights() {
        assertArrayEquals(intArrayOf(1, 2, 3, 3), Solution().longestObstacleCourseAtEachPosition(intArrayOf(1, 2, 3, 2)))
    }

    @Test
    fun decreasingTail() {
        assertArrayEquals(intArrayOf(1, 2, 1), Solution().longestObstacleCourseAtEachPosition(intArrayOf(2, 2, 1)))
    }

    @Test
    fun mixedHeights() {
        assertArrayEquals(intArrayOf(1, 1, 2, 3, 2, 2), Solution().longestObstacleCourseAtEachPosition(intArrayOf(3, 1, 5, 6, 4, 2)))
    }

    @Test
    fun singleObstacle() {
        assertArrayEquals(intArrayOf(1), Solution().longestObstacleCourseAtEachPosition(intArrayOf(7)))
    }

    @Test
    fun emptyArray() {
        assertArrayEquals(intArrayOf(), Solution().longestObstacleCourseAtEachPosition(intArrayOf()))
    }
}
