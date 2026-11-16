package plusone

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PlusOneTest {
    @Test
    fun noCarry() {
        assertArrayEquals(intArrayOf(1, 2, 4), Solution().plusOne(intArrayOf(1, 2, 3)))
    }

    @Test
    fun trailingNine() {
        assertArrayEquals(intArrayOf(4, 3, 0, 0), Solution().plusOne(intArrayOf(4, 2, 9, 9)))
    }

    @Test
    fun singleNine() {
        assertArrayEquals(intArrayOf(1, 0), Solution().plusOne(intArrayOf(9)))
    }

    @Test
    fun allNines() {
        assertArrayEquals(intArrayOf(1, 0, 0, 0), Solution().plusOne(intArrayOf(9, 9, 9)))
    }
}
