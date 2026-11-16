package countsquaresumtriples

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSquareSumTriplesTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(2, solution.countTriples(5))
    }

    @Test
    fun example2() {
        assertEquals(4, solution.countTriples(10))
    }

    @Test
    fun one() {
        assertEquals(0, solution.countTriples(1))
    }

    @Test
    fun two() {
        assertEquals(0, solution.countTriples(2))
    }

    @Test
    fun thirteen() {
        assertEquals(6, solution.countTriples(13))
    }
}
