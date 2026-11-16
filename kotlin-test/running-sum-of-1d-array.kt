package runningsumof1darray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RunningSumOf1dArrayTest {
    @Test
    fun leetCodeExample() {
        assertArrayEquals(
            intArrayOf(1, 3, 6, 10),
            Solution().runningSum(intArrayOf(1, 2, 3, 4))
        )
    }

    @Test
    fun allOnes() {
        assertArrayEquals(
            intArrayOf(1, 2, 3, 4, 5),
            Solution().runningSum(intArrayOf(1, 1, 1, 1, 1))
        )
    }

    @Test
    fun mixedValues() {
        assertArrayEquals(
            intArrayOf(3, 4, 6, 16, 17),
            Solution().runningSum(intArrayOf(3, 1, 2, 10, 1))
        )
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(42), Solution().runningSum(intArrayOf(42)))
    }

    @Test
    fun emptyArray() {
        assertArrayEquals(IntArray(0), Solution().runningSum(IntArray(0)))
    }

    @Test
    fun negativeValues() {
        assertArrayEquals(
            intArrayOf(5, 3, 6, 0),
            Solution().runningSum(intArrayOf(5, -2, 3, -6))
        )
    }
}
