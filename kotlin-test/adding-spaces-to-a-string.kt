package addingspacestoastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddingSpacesToAStringTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(
            "Leetcode Helps Me Learn",
            solution.addSpaces("LeetcodeHelpsMeLearn", intArrayOf(8, 13, 15))
        )
    }

    @Test
    fun secondExample() {
        assertEquals("i code in py thon", solution.addSpaces("icodeinpython", intArrayOf(1, 5, 7, 9)))
    }

    @Test
    fun spaceAfterEveryCharacterBoundary() {
        assertEquals(" s p a c i n g", solution.addSpaces("spacing", intArrayOf(0, 1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun noSpaces() {
        assertEquals("unchanged", solution.addSpaces("unchanged", intArrayOf()))
    }
}
