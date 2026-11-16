package calculatemoneyinleetcodebank

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculateMoneyInLeetcodeBankTest {
    @Test
    fun partialFirstWeek() {
        assertEquals(10, Solution().totalMoney(4))
    }

    @Test
    fun oneWeekAndThreeDays() {
        assertEquals(37, Solution().totalMoney(10))
    }

    @Test
    fun nearlyThreeWeeks() {
        assertEquals(96, Solution().totalMoney(20))
    }

    @Test
    fun firstDayOnly() {
        assertEquals(1, Solution().totalMoney(1))
    }
}
