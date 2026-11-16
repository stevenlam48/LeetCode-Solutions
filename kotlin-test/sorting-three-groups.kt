package sortingthreegroups

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortingThreeGroupsTest {
    @Test
    fun exampleOne() {
        assertEquals(3, Solution().minimumOperations(intArrayOf(2, 1, 3, 2, 1)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(2, Solution().minimumOperations(intArrayOf(1, 3, 2, 1, 3, 3)))
    }

    @Test
    fun alreadyGrouped() {
        assertEquals(0, Solution().minimumOperations(intArrayOf(2, 2, 2, 2, 3, 3)))
    }

    @Test
    fun allSameGroup() {
        assertEquals(0, Solution().minimumOperations(intArrayOf(1, 1, 1)))
    }
}
