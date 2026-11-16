package circularpermutationinbinaryrepresentation

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CircularPermutationInBinaryRepresentationTest {
    private val solution = Solution()

    @Test
    fun twoBitsStartingAtThree() {
        assertArrayEquals(
            intArrayOf(3, 2, 0, 1),
            solution.circularPermutation(2, 3)
        )
    }

    @Test
    fun threeBitsStartingAtTwo() {
        assertArrayEquals(
            intArrayOf(2, 3, 1, 0, 4, 5, 7, 6),
            solution.circularPermutation(3, 2)
        )
    }

    @Test
    fun oneBitStartingAtZero() {
        assertArrayEquals(intArrayOf(0, 1), solution.circularPermutation(1, 0))
    }

    @Test
    fun oneBitStartingAtOne() {
        assertArrayEquals(intArrayOf(1, 0), solution.circularPermutation(1, 1))
    }
}
