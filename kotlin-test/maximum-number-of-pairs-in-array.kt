package maximumnumberofpairsinarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximumnumberofpairsinarrayTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(3, 1), Solution().numberOfPairs(intArrayOf(1, 3, 2, 1, 3, 2, 2)))
    }

    @Test
    fun example2() {
        assertArrayEquals(intArrayOf(1, 0), Solution().numberOfPairs(intArrayOf(1, 1)))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(0, 1), Solution().numberOfPairs(intArrayOf(0)))
    }

    @Test
    fun oddCount() {
        assertArrayEquals(intArrayOf(1, 1), Solution().numberOfPairs(intArrayOf(5, 5, 5)))
    }
}
