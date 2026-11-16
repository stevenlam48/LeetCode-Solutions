package smallestuniquesubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestUniqueSubarrayTest {
    @Test
    fun allElementsDistinct() {
        assertEquals(1, Solution().smallestUniqueSubarray(intArrayOf(1, 2, 3)))
    }

    @Test
    fun needsLengthTwo() {
        assertEquals(2, Solution().smallestUniqueSubarray(intArrayOf(1, 2, 1, 2)))
    }

    @Test
    fun onlyWholeArrayIsUnique() {
        assertEquals(3, Solution().smallestUniqueSubarray(intArrayOf(3, 3, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().smallestUniqueSubarray(intArrayOf(5)))
    }

    @Test
    fun repeatedValuePlusUnique() {
        assertEquals(1, Solution().smallestUniqueSubarray(intArrayOf(1, 1, 1, 2)))
    }
}
