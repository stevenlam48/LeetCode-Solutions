package findthemaximumachievablenumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMaximumAchievableNumberTest {
    @Test
    fun exampleOne() {
        assertEquals(6, Solution().theMaximumAchievableX(4, 1))
    }

    @Test
    fun exampleTwo() {
        assertEquals(7, Solution().theMaximumAchievableX(3, 2))
    }

    @Test
    fun zeroOperations() {
        assertEquals(9, Solution().theMaximumAchievableX(9, 0))
    }

    @Test
    fun negativeStartingNumber() {
        assertEquals(1, Solution().theMaximumAchievableX(-5, 3))
    }
}
