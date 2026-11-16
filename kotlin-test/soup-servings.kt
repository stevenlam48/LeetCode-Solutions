package soupservings

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SoupServingsTest {
    @Test
    fun exampleOne() {
        assertEquals(0.625, Solution().soupServings(50), 1e-5)
    }

    @Test
    fun exampleTwo() {
        assertEquals(0.71875, Solution().soupServings(100), 1e-5)
    }

    @Test
    fun zeroServings() {
        assertEquals(0.5, Solution().soupServings(0), 1e-5)
    }

    @Test
    fun largeInputSaturates() {
        assertEquals(1.0, Solution().soupServings(4801), 1e-5)
        assertEquals(1.0, Solution().soupServings(1000000000), 1e-5)
    }
}
