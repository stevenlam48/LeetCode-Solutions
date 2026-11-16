package thekthfactorofn

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TheKthFactorOfNTest {

    @Test
    fun testExample1() {
        assertEquals(3, Solution().kthFactor(12, 3))
    }

    @Test
    fun testExample2() {
        assertEquals(7, Solution().kthFactor(7, 2))
    }

    @Test
    fun testExample3() {
        assertEquals(-1, Solution().kthFactor(4, 4))
    }

    @Test
    fun testOne() {
        assertEquals(1, Solution().kthFactor(1, 1))
    }

    @Test
    fun testPerfectSquare() {
        assertEquals(2, Solution().kthFactor(4, 2))
        assertEquals(4, Solution().kthFactor(4, 3))
    }

    @Test
    fun testLargeComposite() {
        assertEquals(4, Solution().kthFactor(1000, 3))
        assertEquals(1000, Solution().kthFactor(1000, 16))
    }
}
