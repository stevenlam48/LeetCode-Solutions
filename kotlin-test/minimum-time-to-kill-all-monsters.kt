package minimumtimetokillallmonsters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeToKillAllMonstersTest {
    @Test
    fun increasingGain() {
        assertEquals(4L, Solution().minimumTime(intArrayOf(3, 2, 2)))
    }

    @Test
    fun differentPowers() {
        assertEquals(4L, Solution().minimumTime(intArrayOf(1, 2, 4, 3)))
    }

    @Test
    fun oneMonster() {
        assertEquals(7L, Solution().minimumTime(intArrayOf(7)))
    }

    @Test
    fun equalPowers() {
        assertEquals(3L, Solution().minimumTime(intArrayOf(1, 1, 1)))
    }
}
