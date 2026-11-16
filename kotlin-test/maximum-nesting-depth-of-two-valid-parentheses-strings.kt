package maximumnestingdepthoftwovalidparenthesesstrings

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximumNestingDepthOfTwoValidParenthesesStringsTest {
    private val solution = Solution()

    @Test
    fun example() {
        assertArrayEquals(intArrayOf(1, 0, 0, 0, 0, 1), solution.maxDepthAfterSplit("(()())"))
    }

    @Test
    fun secondExample() {
        assertArrayEquals(intArrayOf(1, 1, 1, 0, 0, 1), solution.maxDepthAfterSplit("()(())"))
    }

    @Test
    fun singlePair() {
        assertArrayEquals(intArrayOf(1, 1), solution.maxDepthAfterSplit("()"))
    }

    @Test
    fun deeplyNested() {
        assertArrayEquals(intArrayOf(1, 0, 1, 1, 0, 1), solution.maxDepthAfterSplit("((()))"))
    }
}
