package executionofallsuffixinstructionsstayinginagrid

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ExecutionOfAllSuffixInstructionsStayingInAGridTest {
    @Test
    fun firstLeetCodeExample() {
        val actual = Solution().executeInstructions(3, intArrayOf(0, 1), "RRDDLU")
        assertArrayEquals(intArrayOf(1, 5, 4, 3, 1, 0), actual)
    }

    @Test
    fun secondLeetCodeExample() {
        val actual = Solution().executeInstructions(2, intArrayOf(1, 1), "LURD")
        assertArrayEquals(intArrayOf(4, 1, 0, 0), actual)
    }

    @Test
    fun thirdLeetCodeExample() {
        val actual = Solution().executeInstructions(1, intArrayOf(0, 0), "LRUD")
        assertArrayEquals(intArrayOf(0, 0, 0, 0), actual)
    }

    @Test
    fun immediateExitsAndLaterValidSuffixes() {
        val actual = Solution().executeInstructions(2, intArrayOf(0, 0), "ULRD")
        assertArrayEquals(intArrayOf(0, 0, 2, 1), actual)
    }

    @Test
    fun emptyInstructionString() {
        val actual = Solution().executeInstructions(3, intArrayOf(1, 1), "")
        assertArrayEquals(intArrayOf(), actual)
    }
}
