package kthsymbolingrammar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthSymbolInGrammarTest {
    private val solution = Solution()

    @Test
    fun firstRow() {
        assertEquals(0, solution.kthGrammar(1, 1))
    }

    @Test
    fun secondRowFirst() {
        assertEquals(0, solution.kthGrammar(2, 1))
    }

    @Test
    fun secondRowSecond() {
        assertEquals(1, solution.kthGrammar(2, 2))
    }

    @Test
    fun example() {
        assertEquals(1, solution.kthGrammar(4, 5))
    }

    @Test
    fun thirdRowThird() {
        assertEquals(1, solution.kthGrammar(3, 3))
    }

    @Test
    fun fourthRowLast() {
        assertEquals(1, solution.kthGrammar(4, 8))
    }
}
