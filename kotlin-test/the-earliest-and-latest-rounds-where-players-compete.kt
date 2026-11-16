package theearliestandlatestroundswhereplayerscompete

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TheEarliestAndLatestRoundsWherePlayersCompeteTest {
    @Test
    fun standardExample() {
        assertArrayEquals(intArrayOf(3, 4), Solution().earliestAndLatest(11, 2, 4))
    }

    @Test
    fun playersMeetImmediately() {
        assertArrayEquals(intArrayOf(1, 1), Solution().earliestAndLatest(5, 1, 5))
        assertArrayEquals(intArrayOf(1, 1), Solution().earliestAndLatest(6, 3, 4))
    }

    @Test
    fun fourPlayerFinal() {
        assertArrayEquals(intArrayOf(2, 2), Solution().earliestAndLatest(4, 1, 2))
    }
}
