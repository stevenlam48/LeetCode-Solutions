package findgreatestcommondivisorofarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindGreatestCommonDivisorOfArrayTest {
    @Test
    fun standardExample() {
        assertEquals(2, Solution().findGCD(intArrayOf(2, 5, 6, 9, 10)))
    }

    @Test
    fun secondExample() {
        assertEquals(1, Solution().findGCD(intArrayOf(7, 5, 6, 8, 3)))
    }

    @Test
    fun twoEqualElements() {
        assertEquals(3, Solution().findGCD(intArrayOf(3, 3)))
    }

    @Test
    fun minIsMultipleOfMax() {
        assertEquals(5, Solution().findGCD(intArrayOf(5, 10, 15)))
    }
}
