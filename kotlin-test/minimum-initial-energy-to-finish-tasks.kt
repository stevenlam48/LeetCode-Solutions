package minimuminitialenergytofinishtasks

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumInitialEnergyToFinishTasksTest {
    @Test
    fun firstLeetCodeExample() {
        assertEquals(8, Solution().minimumEffort(arrayOf(intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(4, 8))))
    }

    @Test
    fun secondLeetCodeExample() {
        assertEquals(32, Solution().minimumEffort(arrayOf(intArrayOf(1, 3), intArrayOf(2, 4), intArrayOf(10, 11), intArrayOf(10, 12), intArrayOf(8, 9))))
    }

    @Test
    fun thirdLeetCodeExample() {
        assertEquals(27, Solution().minimumEffort(arrayOf(intArrayOf(1, 7), intArrayOf(2, 8), intArrayOf(3, 9), intArrayOf(4, 10), intArrayOf(5, 11), intArrayOf(6, 12))))
    }

    @Test
    fun singleTaskRequiresItsMinimumEnergy() {
        assertEquals(7, Solution().minimumEffort(arrayOf(intArrayOf(3, 7))))
    }
}
