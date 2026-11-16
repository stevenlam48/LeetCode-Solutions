package findthepeaks

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindThePeaksTest {
    private val solution = Solution()

    @Test
    fun mountainHasNoPeaks() {
        assertArrayEquals(intArrayOf(), solution.findPeaks(intArrayOf(2, 4, 4)))
    }

    @Test
    fun findsMultiplePeaks() {
        assertArrayEquals(intArrayOf(1, 3), solution.findPeaks(intArrayOf(1, 4, 3, 8, 5)))
    }

    @Test
    fun endpointsAreNotPeaks() {
        assertArrayEquals(intArrayOf(), solution.findPeaks(intArrayOf(3, 1, 2)))
        assertArrayEquals(intArrayOf(), solution.findPeaks(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun ignoresPlateausAndHandlesNegativeValues() {
        assertArrayEquals(
            intArrayOf(4),
            solution.findPeaks(intArrayOf(-3, -1, -1, -2, 0, -1)),
        )
    }
}
