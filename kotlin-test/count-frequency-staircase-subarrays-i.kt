package countfrequencystaircasesubarraysi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountFrequencyStaircaseSubarraysITest {
    @Test
    fun duplicates() {
        assertEquals(2, Solution().countStaircase(intArrayOf(1, 1)))
    }

    @Test
    fun twoDistinct() {
        assertEquals(2, Solution().countStaircase(intArrayOf(1, 2)))
    }

    @Test
    fun staircasePair() {
        assertEquals(4, Solution().countStaircase(intArrayOf(1, 2, 2)))
    }

    @Test
    fun oneDuplicate() {
        assertEquals(3, Solution().countStaircase(intArrayOf(1, 1, 2)))
        assertEquals(3, Solution().countStaircase(intArrayOf(3, 1, 2)))
    }

    @Test
    fun allSame() {
        assertEquals(3, Solution().countStaircase(intArrayOf(1, 1, 1)))
    }

    @Test
    fun mixed() {
        assertEquals(6, Solution().countStaircase(intArrayOf(1, 1, 2, 2, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().countStaircase(intArrayOf(5)))
    }
}
