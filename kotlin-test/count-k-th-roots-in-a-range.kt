package countkthrootsinarange

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountKthRootsInARangeTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.countKthRoots(1, 9, 3))
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.countKthRoots(2, 9, 3))
    }

    @Test
    fun testSingleValue() {
        assertEquals(1, solution.countKthRoots(1, 1, 1))
    }

    @Test
    fun testFourthRoots() {
        assertEquals(2, solution.countKthRoots(1, 16, 4))
    }

    @Test
    fun testNoRoots() {
        assertEquals(0, solution.countKthRoots(2, 3, 2))
    }
}
