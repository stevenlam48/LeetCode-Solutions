package partitionarrayintokdistinctgroups

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PartitionArrayIntoKDistinctGroupsTest {
    @Test
    fun testAllDistinct() {
        assertTrue(Solution().partitionArray(intArrayOf(1, 2, 3, 4), 4))
    }

    @Test
    fun testThreeGroupsOfTwoDistinctValues() {
        assertTrue(Solution().partitionArray(intArrayOf(3, 2, 3, 2, 3, 2), 2))
    }

    @Test
    fun testNotDivisible() {
        assertFalse(Solution().partitionArray(intArrayOf(1, 2, 3), 2))
    }

    @Test
    fun testTooManyDuplicates() {
        assertFalse(Solution().partitionArray(intArrayOf(1, 1, 1, 2), 2))
    }

    @Test
    fun testGroupSizeOne() {
        assertFalse(Solution().partitionArray(intArrayOf(1, 1), 2))
        assertTrue(Solution().partitionArray(intArrayOf(1, 2), 2))
    }
}
