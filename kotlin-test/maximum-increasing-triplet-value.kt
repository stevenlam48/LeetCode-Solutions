package maximumincreasingtripletvalue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumIncreasingTripletValueTest {
    private val solution = Solution()

    @Test
    fun `finds the maximum ordered triplet value`() {
        assertEquals(6, solution.maximumTripletValue(intArrayOf(12, 6, 1, 2, 7)))
    }

    @Test
    fun `uses distinct increasing positions`() {
        assertEquals(18, solution.maximumTripletValue(intArrayOf(1, 10, 3, 4, 19)))
    }

    @Test
    fun `returns zero without an increasing triplet`() {
        assertEquals(0, solution.maximumTripletValue(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun `handles fewer than three elements`() {
        assertEquals(0, solution.maximumTripletValue(intArrayOf(1, 2)))
    }
}
