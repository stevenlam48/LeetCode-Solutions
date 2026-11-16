package p4sumii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class P4sumiiTest {
    @Test
    fun example1() {
        assertEquals(
            2,
            Solution().fourSumCount(
                intArrayOf(1, 2),
                intArrayOf(-2, -1),
                intArrayOf(-1, 2),
                intArrayOf(0, 2)
            )
        )
    }

    @Test
    fun example2() {
        assertEquals(
            1,
            Solution().fourSumCount(
                intArrayOf(0),
                intArrayOf(0),
                intArrayOf(0),
                intArrayOf(0)
            )
        )
    }

    @Test
    fun noSolution() {
        assertEquals(
            0,
            Solution().fourSumCount(
                intArrayOf(1),
                intArrayOf(1),
                intArrayOf(1),
                intArrayOf(1)
            )
        )
    }

    @Test
    fun duplicates() {
        assertEquals(
            16,
            Solution().fourSumCount(
                intArrayOf(1, 1),
                intArrayOf(-1, -1),
                intArrayOf(0, 0),
                intArrayOf(0, 0)
            )
        )
    }
}
