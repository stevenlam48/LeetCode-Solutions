package sumgame

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumGameTest {
    @Test
    fun exampleOne() {
        assertFalse(Solution().sumGame("5023"))
    }

    @Test
    fun exampleTwo() {
        assertTrue(Solution().sumGame("25??"))
    }

    @Test
    fun exampleThree() {
        assertFalse(Solution().sumGame("?3295???"))
    }

    @Test
    fun equalAndEmptyInputs() {
        assertFalse(Solution().sumGame("1212"))
        assertFalse(Solution().sumGame(""))
    }
}
