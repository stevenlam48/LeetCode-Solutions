package bitwisexorofallpairings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BitwiseXorOfAllPairingsTest {
    @Test
    fun example1() {
        assertEquals(13, Solution().xorAllNums(intArrayOf(2, 1, 3), intArrayOf(10, 2, 5, 0)))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().xorAllNums(intArrayOf(1, 2), intArrayOf(3, 4)))
    }

    @Test
    fun singleElements() {
        assertEquals(0, Solution().xorAllNums(intArrayOf(1), intArrayOf(1)))
    }

    @Test
    fun singleVersusSingle() {
        assertEquals(3, Solution().xorAllNums(intArrayOf(1), intArrayOf(2)))
    }

    @Test
    fun evenFirstOddSecond() {
        assertEquals(3, Solution().xorAllNums(intArrayOf(1, 2), intArrayOf(3)))
    }
}
