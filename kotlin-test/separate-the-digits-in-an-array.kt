package separatethedigitsinanarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SeparateTheDigitsInAnArrayTest {
    @Test
    fun exampleMixedNumbers() {
        assertArrayEquals(
            intArrayOf(1, 3, 2, 5, 8, 3, 7, 7),
            Solution().separateDigits(intArrayOf(13, 25, 83, 77)),
        )
    }

    @Test
    fun exampleSingleDigits() {
        assertArrayEquals(intArrayOf(7, 1, 3, 9), Solution().separateDigits(intArrayOf(7, 1, 3, 9)))
    }

    @Test
    fun numberWithZero() {
        assertArrayEquals(intArrayOf(1, 0), Solution().separateDigits(intArrayOf(10)))
    }

    @Test
    fun numberWithTrailingZeros() {
        assertArrayEquals(intArrayOf(1, 0, 0), Solution().separateDigits(intArrayOf(100)))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(9), Solution().separateDigits(intArrayOf(9)))
    }
}
