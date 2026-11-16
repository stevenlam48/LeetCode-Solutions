package minimumreplacementstosortthearray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumReplacementsToSortTheArrayTest {
    @Test
    fun example1() {
        assertEquals(2L, Solution().minimumReplacement(intArrayOf(3, 9, 3)))
    }

    @Test
    fun alreadySorted() {
        assertEquals(0L, Solution().minimumReplacement(intArrayOf(1, 2, 3, 4, 5)))
        assertEquals(0L, Solution().minimumReplacement(intArrayOf(5, 5, 5)))
    }

    @Test
    fun singleElement() {
        assertEquals(0L, Solution().minimumReplacement(intArrayOf(1)))
    }

    @Test
    fun twoDecreasingElements() {
        assertEquals(1L, Solution().minimumReplacement(intArrayOf(2, 1)))
    }

    @Test
    fun strictlyDecreasing() {
        assertEquals(10L, Solution().minimumReplacement(intArrayOf(5, 4, 3, 2, 1)))
    }
}
