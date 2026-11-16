package countpathsthatcanformapalindromeinatree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountPathsThatCanFormAPalindromeInATreeTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(
            8L,
            solution.countPalindromePaths(intArrayOf(-1, 0, 0, 1, 1, 2), "acaabc")
        )
    }

    @Test
    fun exampleTwo() {
        assertEquals(
            10L,
            solution.countPalindromePaths(intArrayOf(-1, 0, 0, 0, 0), "aaaaa")
        )
    }

    @Test
    fun rootOnly() {
        assertEquals(0L, solution.countPalindromePaths(intArrayOf(-1), "a"))
    }

    @Test
    fun onlySingleEdgePalindromePaths() {
        assertEquals(
            3L,
            solution.countPalindromePaths(intArrayOf(-1, 0, 1, 2), "abcd")
        )
    }
}
