package transformedarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TransformedArrayTest {
    @Test
    fun mixedDirectionsExample() {
        assertArrayEquals(intArrayOf(1, 1, 1, 3), Solution().constructTransformedArray(intArrayOf(3, -2, 1, 1)))
    }

    @Test
    fun wrapsBackwardAndForward() {
        assertArrayEquals(intArrayOf(-1, -1, 4), Solution().constructTransformedArray(intArrayOf(-1, 4, -1)))
    }

    @Test
    fun zeroAndSingleElement() {
        assertArrayEquals(intArrayOf(0, 0, 0), Solution().constructTransformedArray(IntArray(3)))
        assertArrayEquals(intArrayOf(7), Solution().constructTransformedArray(intArrayOf(7)))
    }
}
