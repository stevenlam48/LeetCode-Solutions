package containvirus

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ContainVirusTest {
    @Test
    fun leetCodeFirstExample() {
        val grid = arrayOf(
            intArrayOf(0, 1, 0, 0, 0, 0, 0, 1),
            intArrayOf(0, 1, 0, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0)
        )
        assertEquals(10, Solution().containVirus(grid))
    }

    @Test
    fun leetCodeSecondExample() {
        val grid = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1))
        assertEquals(4, Solution().containVirus(grid))
    }

    @Test
    fun fullyInfectedGridNeedsNoWalls() {
        val grid = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        assertEquals(0, Solution().containVirus(grid))
    }

    @Test
    fun singleVirusCellHasTwoInteriorEdges() {
        val grid = arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))
        assertEquals(2, Solution().containVirus(grid))
    }
}
