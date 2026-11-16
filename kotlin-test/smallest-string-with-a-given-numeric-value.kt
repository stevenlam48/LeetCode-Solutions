package smalleststringwithagivennumericvalue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestStringWithAGivenNumericValueTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals("aay", solution.getSmallestString(3, 27))
        assertEquals("aaszz", solution.getSmallestString(5, 73))
    }

    @Test
    fun allSmallLetters() {
        assertEquals("aaa", solution.getSmallestString(3, 3))
    }

    @Test
    fun allLargeLetters() {
        assertEquals("z", solution.getSmallestString(1, 26))
        assertEquals("zz", solution.getSmallestString(2, 52))
    }
}
