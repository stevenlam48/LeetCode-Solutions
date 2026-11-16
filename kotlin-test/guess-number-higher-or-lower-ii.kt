package guessnumberhigherorlowerii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GuessNumberHigherOrLowerIiTest {
    @Test
    fun oneNumber() {
        assertEquals(0, Solution().getMoneyAmount(1))
    }

    @Test
    fun twoNumbers() {
        assertEquals(1, Solution().getMoneyAmount(2))
    }

    @Test
    fun threeNumbers() {
        assertEquals(2, Solution().getMoneyAmount(3))
    }

    @Test
    fun fourNumbers() {
        assertEquals(4, Solution().getMoneyAmount(4))
    }

    @Test
    fun tenNumbers() {
        assertEquals(16, Solution().getMoneyAmount(10))
    }
}
