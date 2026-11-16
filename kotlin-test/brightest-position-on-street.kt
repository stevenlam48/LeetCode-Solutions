package brightestpositiononstreet

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BrightestPositionOnStreetTest {
    @Test
    fun example1() {
        val lights = arrayOf(
            intArrayOf(-3, 2),
            intArrayOf(1, 2),
            intArrayOf(3, 3)
        )
        assertEquals(-1, Solution().brightestPosition(lights))
    }

    @Test
    fun example2() {
        val lights = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1)
        )
        assertEquals(1, Solution().brightestPosition(lights))
    }

    @Test
    fun singleLight() {
        assertEquals(-1, Solution().brightestPosition(arrayOf(intArrayOf(1, 2))))
    }

    @Test
    fun zeroRange() {
        assertEquals(0, Solution().brightestPosition(arrayOf(intArrayOf(0, 0))))
    }
}
