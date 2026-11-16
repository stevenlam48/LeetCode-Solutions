package numberofsegmentsinastring

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfSegmentsInAStringTest {
    @Test
    fun testExample1() {
        assertEquals(5, Solution().countSegments("Hello, my name is John"))
    }

    @Test
    fun testExample2() {
        assertEquals(1, Solution().countSegments("Hello"))
    }

    @Test
    fun testEmpty() {
        assertEquals(0, Solution().countSegments(""))
    }

    @Test
    fun testOnlySpaces() {
        assertEquals(0, Solution().countSegments("   "))
    }

    @Test
    fun testLeadingAndTrailingSpaces() {
        assertEquals(2, Solution().countSegments("  a  b  "))
    }
}
