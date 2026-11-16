package maximumtotalareaoccupiedbypistons

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalAreaOccupiedByPistonsTest {
    private val solution = Solution()

    @Test
    fun twoUpwardPistons() {
        assertEquals(8L, solution.maxArea(5, intArrayOf(2, 4), "UU"))
    }

    @Test
    fun singleUpwardPiston() {
        assertEquals(3L, solution.maxArea(3, intArrayOf(1), "U"))
    }

    @Test
    fun oppositeDirections() {
        assertEquals(3L, solution.maxArea(2, intArrayOf(0, 1), "UD"))
    }

    @Test
    fun singleDownwardPiston() {
        assertEquals(2L, solution.maxArea(2, intArrayOf(2), "D"))
    }
}
