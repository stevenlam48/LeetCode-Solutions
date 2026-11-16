package cinemaseatallocation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CinemaSeatAllocationTest {
    private val solution = Solution()

    @Test
    fun leetCodeExample() {
        val reserved = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 8),
            intArrayOf(2, 6),
            intArrayOf(3, 1),
            intArrayOf(3, 10)
        )
        assertEquals(4, solution.maxNumberOfFamilies(3, reserved))
    }

    @Test
    fun noReservedSeats() {
        assertEquals(4, solution.maxNumberOfFamilies(2, emptyArray()))
    }

    @Test
    fun aisleSeatsDoNotBlockFamilyGroups() {
        val reserved = arrayOf(intArrayOf(1, 1), intArrayOf(1, 10))
        assertEquals(2, solution.maxNumberOfFamilies(1, reserved))
    }

    @Test
    fun allThreeGroupsCanBeBlocked() {
        val reserved = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 4),
            intArrayOf(1, 6)
        )
        assertEquals(0, solution.maxNumberOfFamilies(1, reserved))
    }
}
