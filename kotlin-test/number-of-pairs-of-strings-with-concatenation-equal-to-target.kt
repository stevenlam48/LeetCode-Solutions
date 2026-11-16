package numberofpairsofstringswithconcatenationequaltotarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfPairsOfStringsWithConcatenationEqualToTargetTest {
    private val solution = Solution()

    @Test
    fun `counts repeated prefixes and suffixes`() {
        assertEquals(
            4,
            solution.numOfPairs(listOf("777", "7", "77", "777"), "7777")
        )
    }

    @Test
    fun `counts both orders of each pair`() {
        assertEquals(2, solution.numOfPairs(listOf("123", "4", "12", "34"), "1234"))
    }

    @Test
    fun `counts all distinct index pairs with duplicate strings`() {
        assertEquals(6, solution.numOfPairs(listOf("1", "1", "1"), "11"))
    }

    @Test
    fun `skips strings longer than the target`() {
        assertEquals(2, solution.numOfPairs(listOf("a", "bc", "oversized", "a"), "abc"))
    }
}
