package maximumnestingdepthoftheparentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNestingDepthOfTheParenthesesTest {
    private val solution = Solution()

    @Test
    fun exampleWithArithmetic() {
        assertEquals(3, solution.maxDepth("(1+(2*3)+((8)/4))+1"))
    }

    @Test
    fun nestedGroups() {
        assertEquals(3, solution.maxDepth("(1)+((2))+(((3)))"))
    }

    @Test
    fun mixedSequence() {
        assertEquals(3, solution.maxDepth("()(())((()()))"))
    }

    @Test
    fun noParentheses() {
        assertEquals(0, solution.maxDepth("1"))
    }

    @Test
    fun emptyString() {
        assertEquals(0, solution.maxDepth(""))
    }
}
