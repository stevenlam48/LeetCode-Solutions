package intersectionoftwoarraysii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class IntersectionOfTwoArraysIiTest {
    @Test
    fun preservesRequiredMultiplicity() {
        assertArrayEquals(intArrayOf(2, 2), Solution().intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)))
    }

    @Test
    fun solvesLeetCodeExample() {
        assertArrayEquals(intArrayOf(9, 4), Solution().intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)))
    }

    @Test
    fun limitsDuplicatesToSmallerCount() {
        assertArrayEquals(
            intArrayOf(1, 1, -3),
            Solution().intersect(intArrayOf(1, 1, 1, -3), intArrayOf(1, -3, 1))
        )
    }

    @Test
    fun handlesEmptyAndDisjointArrays() {
        assertArrayEquals(IntArray(0), Solution().intersect(IntArray(0), intArrayOf(1)))
        assertArrayEquals(IntArray(0), Solution().intersect(intArrayOf(1, 2), intArrayOf(3, 4)))
    }
}
