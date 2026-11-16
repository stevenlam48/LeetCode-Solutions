package sorttransformedarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortTransformedArrayTest {
    @Test
    fun upwardOpeningParabola() {
        assertArrayEquals(
            intArrayOf(3, 9, 15, 33),
            Solution().sortTransformedArray(intArrayOf(-4, -2, 2, 4), 1, 3, 5)
        )
    }

    @Test
    fun downwardOpeningParabola() {
        assertArrayEquals(
            intArrayOf(-23, -5, 1, 7),
            Solution().sortTransformedArray(intArrayOf(-4, -2, 2, 4), -1, 3, 5)
        )
    }

    @Test
    fun decreasingLinearTransform() {
        assertArrayEquals(
            intArrayOf(-1, 0, 1, 2),
            Solution().sortTransformedArray(intArrayOf(-2, -1, 0, 1), 0, -1, 0)
        )
    }

    @Test
    fun constantTransformAndDuplicates() {
        assertArrayEquals(
            intArrayOf(4, 4, 4),
            Solution().sortTransformedArray(intArrayOf(-1, 0, 1), 0, 0, 4)
        )
        assertArrayEquals(
            intArrayOf(0, 4, 4),
            Solution().sortTransformedArray(intArrayOf(-2, 0, 2), 1, 0, 0)
        )
    }

    @Test
    fun emptyAndSingleElement() {
        assertArrayEquals(intArrayOf(), Solution().sortTransformedArray(intArrayOf(), 1, 2, 3))
        assertArrayEquals(
            intArrayOf(6),
            Solution().sortTransformedArray(intArrayOf(1), 1, 2, 3)
        )
    }
}
