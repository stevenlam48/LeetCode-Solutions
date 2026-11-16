package checkifanarrayisconsecutive

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfAnArrayIsConsecutiveTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.isConsecutive(intArrayOf(1, 3, 4, 2)))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.isConsecutive(intArrayOf(1, 3)))
    }

    @Test
    fun testDuplicates() {
        assertFalse(solution.isConsecutive(intArrayOf(1, 2, 2, 3)))
    }

    @Test
    fun testSingleElement() {
        assertTrue(solution.isConsecutive(intArrayOf(5)))
    }

    @Test
    fun testNegatives() {
        assertTrue(solution.isConsecutive(intArrayOf(-2, -1, 0)))
    }

    @Test
    fun testUnsortedConsecutive() {
        assertTrue(solution.isConsecutive(intArrayOf(4, 2, 5, 3, 6)))
    }
}
