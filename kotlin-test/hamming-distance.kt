package hammingdistance

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HammingDistanceTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().hammingDistance(1, 4))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().hammingDistance(3, 1))
    }

    @Test
    fun sameNumber() {
        assertEquals(0, Solution().hammingDistance(0, 0))
    }

    @Test
    fun oneIsZero() {
        assertEquals(31, Solution().hammingDistance(0, Int.MAX_VALUE))
    }

    @Test
    fun allBitsDiffer() {
        assertEquals(32, Solution().hammingDistance(0, -1))
    }
}
