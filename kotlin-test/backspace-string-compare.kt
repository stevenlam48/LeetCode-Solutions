package backspacestringcompare

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class BackspaceStringCompareTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.backspaceCompare("ab#c", "ad#c"))
    }

    @Test
    fun testExample2() {
        assertTrue(solution.backspaceCompare("ab##", "c#d#"))
    }

    @Test
    fun testExample3() {
        assertFalse(solution.backspaceCompare("a#c", "b"))
    }

    @Test
    fun testExample4() {
        assertTrue(solution.backspaceCompare("a##c", "#a#c"))
    }

    @Test
    fun testEmptyResults() {
        assertTrue(solution.backspaceCompare("a#", ""))
        assertTrue(solution.backspaceCompare("", ""))
        assertFalse(solution.backspaceCompare("ab", "a"))
    }
}
