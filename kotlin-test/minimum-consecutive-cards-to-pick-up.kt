package minimumconsecutivecardstopickup

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumConsecutiveCardsToPickUpTest {
    @Test
    fun standardExamples() {
        assertEquals(4, Solution().minimumCardPickup(intArrayOf(3, 4, 2, 3, 4, 7)))
        assertEquals(-1, Solution().minimumCardPickup(intArrayOf(1, 0, 5, 3)))
    }

    @Test
    fun adjacentPair() {
        assertEquals(2, Solution().minimumCardPickup(intArrayOf(1, 1)))
        assertEquals(3, Solution().minimumCardPickup(intArrayOf(1, 2, 1, 2)))
    }

    @Test
    fun repeatedValues() {
        assertEquals(2, Solution().minimumCardPickup(intArrayOf(95, 11, 5, 5, 95, 11, 7)))
    }
}
