package findgooddaystorobthebank

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindGoodDaysToRobTheBankTest {
    @Test
    fun standardExample() {
        assertEquals(
            listOf(2, 3),
            Solution().goodDaysToRobBank(intArrayOf(5, 3, 3, 3, 5, 6, 2), 2)
        )
    }

    @Test
    fun timeZero() {
        assertEquals(
            listOf(0, 1, 2, 3, 4),
            Solution().goodDaysToRobBank(intArrayOf(1, 1, 1, 1, 1), 0)
        )
    }

    @Test
    fun strictlyIncreasing() {
        assertEquals(
            emptyList<Int>(),
            Solution().goodDaysToRobBank(intArrayOf(1, 2, 3, 4, 5, 6), 2)
        )
    }

    @Test
    fun singleDay() {
        assertEquals(listOf(0), Solution().goodDaysToRobBank(intArrayOf(1), 0))
    }

    @Test
    fun strictlyDecreasing() {
        assertEquals(
            emptyList<Int>(),
            Solution().goodDaysToRobBank(intArrayOf(6, 5, 4, 3, 2, 1), 2)
        )
    }
}
