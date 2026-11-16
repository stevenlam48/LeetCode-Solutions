package sortitemsbygroupsrespectingdependencies

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortItemsByGroupsRespectingDependenciesTest {
    @Test
    fun standardExample() {
        val groups = intArrayOf(-1, -1, 1, 0, 0, 1, 0, -1)
        val before = arrayOf(
            intArrayOf(), intArrayOf(6), intArrayOf(5), intArrayOf(6),
            intArrayOf(3, 6), intArrayOf(), intArrayOf(), intArrayOf()
        )
        val result = Solution().sortItems(8, 2, groups, before)
        assertValidOrdering(result, groups, before)
    }

    @Test
    fun dependenciesInsideAndAcrossGroups() {
        val groups = intArrayOf(0, 0, 1, 1)
        val before = arrayOf(intArrayOf(), intArrayOf(), intArrayOf(0), intArrayOf(2))
        val result = Solution().sortItems(4, 2, groups, before)
        assertValidOrdering(result, groups, before)
    }

    @Test
    fun noDependenciesAndEmptyInput() {
        val groups = intArrayOf(-1, -1, -1)
        val before = arrayOf(intArrayOf(), intArrayOf(), intArrayOf())
        assertValidOrdering(Solution().sortItems(3, 0, groups, before), groups, before)
        assertArrayEquals(
            intArrayOf(),
            Solution().sortItems(0, 0, intArrayOf(), arrayOf())
        )
    }

    @Test
    fun cycleInsideOneGroup() {
        val groups = intArrayOf(0, 0)
        val before = arrayOf(intArrayOf(1), intArrayOf(0))
        assertArrayEquals(intArrayOf(), Solution().sortItems(2, 1, groups, before))
    }

    @Test
    fun cycleBetweenGroups() {
        val groups = intArrayOf(0, 1)
        val before = arrayOf(intArrayOf(1), intArrayOf(0))
        assertArrayEquals(intArrayOf(), Solution().sortItems(2, 2, groups, before))
    }

    private fun assertValidOrdering(result: IntArray, assignedGroups: IntArray, before: Array<IntArray>) {
        assertEquals(assignedGroups.size, result.size)
        assertEquals(result.size, result.toSet().size)
        assertTrue(result.all { it in result.indices })
        val positions = IntArray(result.size)
        for (i in result.indices) {
            positions[result[i]] = i
        }
        for (item in before.indices) {
            for (dependency in before[item]) {
                assertTrue(positions[dependency] < positions[item])
            }
        }
        val groupedPositions = assignedGroups.indices.groupBy { assignedGroups[it] }
        for ((_, items) in groupedPositions) {
            val indices = items.map { positions[it] }
            assertEquals(items.size, indices.max() - indices.min() + 1)
        }
    }
}
