package frogpositionaftertseconds

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FrogPositionAfterTSecondsTest {
    private val edges = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(1, 3),
        intArrayOf(1, 7),
        intArrayOf(2, 4),
        intArrayOf(2, 6),
        intArrayOf(3, 5)
    )

    @Test
    fun example1() {
        assertEquals(
            1.0 / 6.0,
            Solution().frogPosition(7, edges, 2, 4),
            1e-9
        )
    }

    @Test
    fun example2() {
        assertEquals(
            1.0 / 3.0,
            Solution().frogPosition(7, edges, 1, 7),
            1e-9
        )
    }

    @Test
    fun example3LeafStays() {
        assertEquals(
            1.0 / 3.0,
            Solution().frogPosition(7, edges, 2, 7),
            1e-9
        )
    }

    @Test
    fun zeroSeconds() {
        assertEquals(1.0, Solution().frogPosition(7, edges, 0, 1), 1e-9)
    }

    @Test
    fun unreachableAfterTooFewSeconds() {
        assertEquals(0.0, Solution().frogPosition(7, edges, 1, 4), 1e-9)
    }

    @Test
    fun simpleTree() {
        assertEquals(
            0.5,
            Solution().frogPosition(3, arrayOf(intArrayOf(1, 2), intArrayOf(1, 3)), 1, 2),
            1e-9
        )
    }
}
