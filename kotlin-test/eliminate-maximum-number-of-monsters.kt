package eliminatemaximumnumberofmonsters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EliminateMaximumNumberOfMonstersTest {
    @Test
    fun allMonstersCanBeEliminated() {
        assertEquals(
            3,
            Solution().eliminateMaximum(intArrayOf(1, 3, 4), intArrayOf(1, 1, 1))
        )
    }

    @Test
    fun simultaneousArrivalsStopElimination() {
        assertEquals(
            1,
            Solution().eliminateMaximum(intArrayOf(1, 1, 2, 3), intArrayOf(1, 1, 1, 1))
        )
    }

    @Test
    fun differentSpeeds() {
        assertEquals(
            1,
            Solution().eliminateMaximum(intArrayOf(3, 2, 4), intArrayOf(5, 3, 2))
        )
    }

    @Test
    fun emptyInput() {
        assertEquals(0, Solution().eliminateMaximum(intArrayOf(), intArrayOf()))
    }

    @Test
    fun fractionalArrivalTimes() {
        assertEquals(
            2,
            Solution().eliminateMaximum(intArrayOf(4, 6), intArrayOf(3, 2))
        )
    }
}
