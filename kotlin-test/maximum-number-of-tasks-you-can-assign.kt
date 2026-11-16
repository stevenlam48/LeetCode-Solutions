package maximumnumberoftasksyoucanassign

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberoftasksyoucanassignTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().maxTaskAssign(intArrayOf(3, 2, 1), intArrayOf(0, 3, 3), 1, 1))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().maxTaskAssign(intArrayOf(5, 4), intArrayOf(0, 0, 0), 1, 5))
    }

    @Test
    fun example3() {
        val tasks = intArrayOf(10, 15, 30)
        val workers = intArrayOf(0, 10, 10, 10, 10, 25, 25, 35, 35, 35)
        assertEquals(3, Solution().maxTaskAssign(tasks, workers, 1, 10))
    }

    @Test
    fun noPillsNeeded() {
        assertEquals(3, Solution().maxTaskAssign(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3), 0, 0))
    }

    @Test
    fun onePillBridgesGap() {
        assertEquals(1, Solution().maxTaskAssign(intArrayOf(2), intArrayOf(1), 1, 1))
    }
}
