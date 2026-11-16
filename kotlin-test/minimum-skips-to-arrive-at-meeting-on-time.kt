package minimumskipstoarriveatmeetingontime

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSkipsToArriveAtMeetingOnTimeTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().minSkips(intArrayOf(1, 3, 2), 4, 2))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().minSkips(intArrayOf(7, 3, 5, 5), 2, 10))
    }

    @Test
    fun example3() {
        assertEquals(-1, Solution().minSkips(intArrayOf(7, 3, 5, 5), 1, 10))
    }

    @Test
    fun singleRoadWithoutSkip() {
        assertEquals(0, Solution().minSkips(intArrayOf(5), 5, 1))
    }

    @Test
    fun singleRoadCannotArriveOnTime() {
        assertEquals(-1, Solution().minSkips(intArrayOf(5), 4, 1))
    }
}
