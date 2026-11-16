package finalvalueofvariableafterperformingoperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FinalValueOfVariableAfterPerformingOperationsTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().finalValueAfterOperations(arrayOf("--X", "X++", "X++")))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().finalValueAfterOperations(arrayOf("++X", "++X", "X++")))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().finalValueAfterOperations(arrayOf("X++", "++X", "--X", "X--")))
    }

    @Test
    fun singleDecrement() {
        assertEquals(-1, Solution().finalValueAfterOperations(arrayOf("--X")))
    }

    @Test
    fun singleIncrement() {
        assertEquals(1, Solution().finalValueAfterOperations(arrayOf("X++")))
    }
}
