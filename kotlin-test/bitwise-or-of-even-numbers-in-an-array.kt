package bitwiseorofevennumbersinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BitwiseOrOfEvenNumbersInAnArrayTest {
    @Test
    fun example1() {
        assertEquals(6, Solution().evenNumberBitwiseORs(intArrayOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun allOdd() {
        assertEquals(0, Solution().evenNumberBitwiseORs(intArrayOf(1, 3, 5)))
    }

    @Test
    fun allEven() {
        assertEquals(6, Solution().evenNumberBitwiseORs(intArrayOf(2, 4)))
    }

    @Test
    fun singleZero() {
        assertEquals(0, Solution().evenNumberBitwiseORs(intArrayOf(0)))
    }

    @Test
    fun distinctBits() {
        assertEquals(10, Solution().evenNumberBitwiseORs(intArrayOf(8, 10)))
    }
}
