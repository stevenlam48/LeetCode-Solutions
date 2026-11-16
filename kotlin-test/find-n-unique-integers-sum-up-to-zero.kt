package findnuniqueintegerssumuptozero

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindNUniqueIntegersSumUpToZeroTest {
    private val solution = Solution()

    @Test
    fun oddCount() {
        assertArrayEquals(intArrayOf(-2, -1, 0, 1, 2), solution.sumZero(5))
    }

    @Test
    fun evenCount() {
        assertArrayEquals(intArrayOf(-2, -1, 1, 2), solution.sumZero(4))
    }

    @Test
    fun smallestOddCount() {
        assertArrayEquals(intArrayOf(0), solution.sumZero(1))
    }

    @Test
    fun smallestEvenCount() {
        assertArrayEquals(intArrayOf(-1, 1), solution.sumZero(2))
    }
}
