package numberofsubstringswithonly1s

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSubstringsWithOnly1sTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(9, solution.numSub("0110111"))
    }

    @Test
    fun exampleTwo() {
        assertEquals(2, solution.numSub("101"))
    }

    @Test
    fun exampleThree() {
        assertEquals(21, solution.numSub("111111"))
    }

    @Test
    fun emptyAndNoOnes() {
        assertEquals(0, solution.numSub(""))
        assertEquals(0, solution.numSub("000"))
    }
}
