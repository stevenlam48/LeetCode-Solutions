package fruitintobaskets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FruitIntoBasketsTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().totalFruit(intArrayOf(1, 2, 1)))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().totalFruit(intArrayOf(0, 1, 2, 2)))
    }

    @Test
    fun example3() {
        assertEquals(4, Solution().totalFruit(intArrayOf(1, 2, 3, 2, 2)))
    }

    @Test
    fun longArray() {
        assertEquals(
            5,
            Solution().totalFruit(intArrayOf(3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4))
        )
    }

    @Test
    fun singleTree() {
        assertEquals(1, Solution().totalFruit(intArrayOf(5)))
    }

    @Test
    fun twoKindsOnly() {
        assertEquals(2, Solution().totalFruit(intArrayOf(1, 2)))
    }
}
