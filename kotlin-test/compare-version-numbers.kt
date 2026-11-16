package compareversionnumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CompareVersionNumbersTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(0, solution.compareVersion("1.01", "1.001"))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.compareVersion("1.0", "1.0.0"))
    }

    @Test
    fun testExample3() {
        assertEquals(-1, solution.compareVersion("0.1", "1.0"))
    }

    @Test
    fun testLongerVersionIsGreater() {
        assertEquals(1, solution.compareVersion("1.0.1", "1"))
    }

    @Test
    fun testNumericNotLexicographic() {
        assertEquals(-1, solution.compareVersion("1.2", "1.10"))
    }

    @Test
    fun testEqualSingleNumbers() {
        assertEquals(0, solution.compareVersion("1", "1"))
    }
}
