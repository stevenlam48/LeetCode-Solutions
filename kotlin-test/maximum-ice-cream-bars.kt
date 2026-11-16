package maximumicecreambars

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumIceCreamBarsTest {
    private val solution = Solution()

    @Test
    fun `buys the cheapest bars first`() {
        assertEquals(4, solution.maxIceCream(intArrayOf(1, 3, 2, 4, 1), 7))
    }

    @Test
    fun `buys every bar when coins are sufficient`() {
        assertEquals(6, solution.maxIceCream(intArrayOf(1, 6, 3, 1, 2, 5), 20))
    }

    @Test
    fun `returns zero when no bar is affordable`() {
        assertEquals(0, solution.maxIceCream(intArrayOf(5, 7), 4))
    }

    @Test
    fun `handles empty costs`() {
        assertEquals(0, solution.maxIceCream(intArrayOf(), 10))
    }
}
