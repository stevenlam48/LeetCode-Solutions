package lexicographicallymaximummexarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LexicographicallyMaximumMEXArrayTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(1, 1), Solution().maximumMEX(intArrayOf(0, 0)))
    }

    @Test
    fun noZero() {
        assertArrayEquals(intArrayOf(0, 0), Solution().maximumMEX(intArrayOf(1, 1)))
    }

    @Test
    fun twoThenPadding() {
        assertArrayEquals(intArrayOf(2, 0), Solution().maximumMEX(intArrayOf(0, 1, 1)))
    }

    @Test
    fun wholeArray() {
        assertArrayEquals(intArrayOf(3), Solution().maximumMEX(intArrayOf(0, 1, 0, 2)))
    }
}
