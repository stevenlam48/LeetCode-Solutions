package maximizethenumberofpartitionsafteroperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeTheNumberOfPartitionsAfterOperationsTest {
    @Test
    fun exampleOne() {
        assertEquals(3, Solution().maxPartitionsAfterOperations("accca", 2))
    }

    @Test
    fun exampleTwo() {
        assertEquals(1, Solution().maxPartitionsAfterOperations("aabaab", 3))
    }

    @Test
    fun exampleThree() {
        assertEquals(2, Solution().maxPartitionsAfterOperations("xxyz", 2))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().maxPartitionsAfterOperations("a", 1))
    }
}
