package numberofuniquexortripletsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfUniqueXorTripletsIITest {
    @Test
    fun example1() {
        assertEquals(4, Solution().uniqueXorTriplets(intArrayOf(1, 2, 3)))
    }

    @Test
    fun allEqual() {
        assertEquals(1, Solution().uniqueXorTriplets(intArrayOf(1, 1, 1)))
    }

    @Test
    fun twoElements() {
        assertEquals(2, Solution().uniqueXorTriplets(intArrayOf(1, 2)))
    }

    @Test
    fun singleZero() {
        assertEquals(1, Solution().uniqueXorTriplets(intArrayOf(0)))
    }

    @Test
    fun powersOfTwo() {
        assertEquals(4, Solution().uniqueXorTriplets(intArrayOf(1, 2, 4)))
    }
}
