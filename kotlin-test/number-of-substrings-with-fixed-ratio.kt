package numberofsubstringswithfixedratio

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSubstringsWithFixedRatioTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(1L, solution.fixedRatio("0011", 1, 2))
    }

    @Test
    fun exampleTwo() {
        assertEquals(6L, solution.fixedRatio("10101", 1, 1))
    }

    @Test
    fun reducibleRatio() {
        assertEquals(1L, solution.fixedRatio("011", 2, 4))
    }

    @Test
    fun empty() {
        assertEquals(0L, solution.fixedRatio("", 1, 1))
    }
}
