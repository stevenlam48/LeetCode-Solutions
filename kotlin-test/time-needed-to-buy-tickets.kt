package timeneededtobuytickets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TimeNeededToBuyTicketsTest {
    private val solution = Solution()

    @Test
    fun standardShorterQueue() {
        assertEquals(6, solution.timeRequiredToBuy(intArrayOf(2, 3, 2), 2))
    }

    @Test
    fun standardLongerQueue() {
        assertEquals(8, solution.timeRequiredToBuy(intArrayOf(5, 1, 1, 1), 0))
    }

    @Test
    fun targetIsLastInLine() {
        assertEquals(9, solution.timeRequiredToBuy(intArrayOf(3, 2, 1, 3), 3))
    }

    @Test
    fun singlePerson() {
        assertEquals(4, solution.timeRequiredToBuy(intArrayOf(4), 0))
    }
}
