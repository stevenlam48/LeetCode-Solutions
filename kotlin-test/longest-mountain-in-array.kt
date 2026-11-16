package longestmountaininarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestMountainInArrayTest {
    @Test
    fun example1() {
        assertEquals(5, Solution().longestMountain(intArrayOf(2, 1, 4, 7, 3, 2, 5)))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().longestMountain(intArrayOf(2, 2, 2)))
    }

    @Test
    fun strictlyIncreasing() {
        assertEquals(0, Solution().longestMountain(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun simpleMountain() {
        assertEquals(5, Solution().longestMountain(intArrayOf(1, 2, 3, 2, 1)))
    }

    @Test
    fun longMountain() {
        assertEquals(11, Solution().longestMountain(intArrayOf(0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().longestMountain(intArrayOf(7)))
    }
}
