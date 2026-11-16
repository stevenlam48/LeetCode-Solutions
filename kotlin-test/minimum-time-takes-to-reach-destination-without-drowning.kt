package minimumtimetakestoreachdestinationwithoutdrowning

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumTimeTakesToReachDestinationWithoutDrowningTest {
    private val solution = Solution()

    @Test
    fun testStraightLine() {
        assertEquals(2, solution.minimumSeconds(arrayOf(arrayOf("S", ".", "D"))))
    }

    @Test
    fun testWaterBlocksTheOnlyPath() {
        assertEquals(-1, solution.minimumSeconds(arrayOf(arrayOf("S", "*", "D"))))
    }

    @Test
    fun testDetourAroundWalls() {
        val land = arrayOf(
            arrayOf("D", ".", "."),
            arrayOf(".", "X", "."),
            arrayOf(".", ".", "S")
        )
        assertEquals(4, solution.minimumSeconds(land))
    }

    @Test
    fun testSurroundedByWater() {
        val land = arrayOf(
            arrayOf(".", ".", "."),
            arrayOf(".", "*", "."),
            arrayOf(".", ".", "S")
        )
        assertEquals(-1, solution.minimumSeconds(land))
    }

    @Test
    fun testDistantWater() {
        val land = arrayOf(
            arrayOf("D", "S", ".", ".", "."),
            arrayOf(".", ".", ".", ".", "."),
            arrayOf(".", ".", ".", ".", "."),
            arrayOf(".", ".", ".", ".", "."),
            arrayOf(".", ".", ".", ".", "*")
        )
        assertEquals(1, solution.minimumSeconds(land))
    }
}
