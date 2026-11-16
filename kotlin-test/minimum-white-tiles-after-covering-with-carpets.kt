package minimumwhitetilesaftercoveringwithcarpets

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumWhiteTilesAfterCoveringWithCarpetsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.minimumWhiteTiles("10110101", 2, 2))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.minimumWhiteTiles("11111", 2, 3))
    }

    @Test
    fun testExample3() {
        assertEquals(0, solution.minimumWhiteTiles("0000", 2, 2))
    }

    @Test
    fun testNoCarpets() {
        assertEquals(3, solution.minimumWhiteTiles("10101", 0, 2))
    }

    @Test
    fun testCarpetLongerThanFloor() {
        assertEquals(0, solution.minimumWhiteTiles("111", 1, 10))
    }
}
