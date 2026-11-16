package numberofgoodbinarystrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfGoodBinaryStringsTest {
    @Test
    fun testMixedGroups() {
        assertEquals(5, Solution().goodBinaryStrings(2, 3, 1, 2))
    }

    @Test
    fun testSingleLength() {
        assertEquals(2, Solution().goodBinaryStrings(1, 1, 1, 1))
    }

    @Test
    fun testAllStrings() {
        assertEquals(6, Solution().goodBinaryStrings(1, 2, 1, 1))
    }

    @Test
    fun testGroupOfTwo() {
        assertEquals(2, Solution().goodBinaryStrings(2, 2, 2, 2))
    }
}
