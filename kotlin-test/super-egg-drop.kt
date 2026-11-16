package supereggdrop

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SuperEggDropTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.superEggDrop(1, 2))
    }

    @Test
    fun testExample2() {
        assertEquals(3, solution.superEggDrop(2, 6))
    }

    @Test
    fun testExample3() {
        assertEquals(4, solution.superEggDrop(3, 14))
    }

    @Test
    fun testSingleFloor() {
        assertEquals(1, solution.superEggDrop(2, 1))
    }

    @Test
    fun testManyEggs() {
        assertEquals(4, solution.superEggDrop(10, 10))
    }
}
