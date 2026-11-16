package findkthsmallestpairdistance

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindKThSmallestPairDistanceTest {
    @Test
    fun findsSmallestDistanceAmongUnsortedValues() {
        assertEquals(0, Solution().smallestDistancePair(intArrayOf(1, 3, 1), 1))
    }

    @Test
    fun findsSecondAndThirdDistances() {
        assertEquals(5, Solution().smallestDistancePair(intArrayOf(1, 6, 1), 2))
        assertEquals(5, Solution().smallestDistancePair(intArrayOf(1, 6, 1), 3))
    }

    @Test
    fun handlesNegativeValues() {
        assertEquals(4, Solution().smallestDistancePair(intArrayOf(-5, -1, 3), 2))
    }

    @Test
    fun handlesAllDuplicateValues() {
        assertEquals(0, Solution().smallestDistancePair(intArrayOf(2, 2, 2, 2), 6))
    }
}
