package cardflippinggame

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CardFlippingGameTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.flipgame(intArrayOf(1, 2, 4, 4, 7), intArrayOf(1, 3, 4, 1, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.flipgame(intArrayOf(1), intArrayOf(1)))
    }

    @Test
    fun testAllSame() {
        assertEquals(0, solution.flipgame(intArrayOf(2, 2), intArrayOf(2, 2)))
    }

    @Test
    fun testOnlyBacksGood() {
        assertEquals(1, solution.flipgame(intArrayOf(2, 2), intArrayOf(1, 1)))
    }
}
