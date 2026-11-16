package new21game

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class New21GameTest {
    @Test
    fun `computes probability for standard examples`() {
        assertEquals(1.0, Solution().new21Game(10, 1, 10), 1e-9)
        assertEquals(0.6, Solution().new21Game(6, 1, 10), 1e-9)
    }

    @Test
    fun `computes probability across multiple draws`() {
        assertEquals(0.7327777870686075, Solution().new21Game(21, 17, 10), 1e-9)
    }

    @Test
    fun `returns one when no points are required`() {
        assertEquals(1.0, Solution().new21Game(0, 0, 10), 1e-9)
        assertEquals(1.0, Solution().new21Game(5, 0, 3), 1e-9)
    }

    @Test
    fun `returns one when every reachable score wins`() {
        assertEquals(1.0, Solution().new21Game(20, 11, 10), 1e-9)
    }
}
