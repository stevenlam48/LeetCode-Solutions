package primeindiagonal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrimeInDiagonalTest {
    @Test
    fun exampleOne() {
        val nums = arrayOf(intArrayOf(1, 2, 3), intArrayOf(5, 6, 7), intArrayOf(9, 10, 11))
        assertEquals(11, Solution().diagonalPrime(nums))
    }

    @Test
    fun exampleTwo() {
        val nums = arrayOf(intArrayOf(1, 2, 3), intArrayOf(5, 17, 7), intArrayOf(9, 11, 10))
        assertEquals(17, Solution().diagonalPrime(nums))
    }

    @Test
    fun noPrimes() {
        val nums = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        assertEquals(0, Solution().diagonalPrime(nums))
    }

    @Test
    fun singlePrime() {
        val nums = arrayOf(intArrayOf(2))
        assertEquals(2, Solution().diagonalPrime(nums))
    }

    @Test
    fun compositeDiagonal() {
        val nums = arrayOf(intArrayOf(4, 1), intArrayOf(1, 9))
        assertEquals(0, Solution().diagonalPrime(nums))
    }
}
