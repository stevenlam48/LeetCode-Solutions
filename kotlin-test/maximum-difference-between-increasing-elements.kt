package maximumdifferencebetweenincreasingelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumDifferenceBetweenIncreasingElementsTest {
    @Test
    fun firstExample() {
        assertEquals(4, Solution().maximumDifference(intArrayOf(7, 1, 5, 4)))
    }

    @Test
    fun decreasingArray() {
        assertEquals(-1, Solution().maximumDifference(intArrayOf(9, 4, 3, 2)))
    }

    @Test
    fun laterLargerDifference() {
        assertEquals(9, Solution().maximumDifference(intArrayOf(1, 5, 2, 10)))
    }

    @Test
    fun singleElement() {
        assertEquals(-1, Solution().maximumDifference(intArrayOf(3)))
    }

    @Test
    fun duplicateMinimum() {
        assertEquals(1, Solution().maximumDifference(intArrayOf(2, 2, 3)))
    }
}
