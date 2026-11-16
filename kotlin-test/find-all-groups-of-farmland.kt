package findallgroupsoffarmland

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindAllGroupsOfFarmlandTest {
    private fun check(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun example1() {
        val land = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 1),
            intArrayOf(0, 1, 1)
        )
        check(
            arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(1, 1, 2, 2)),
            Solution().findFarmland(land)
        )
    }

    @Test
    fun example2() {
        val land = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        check(arrayOf(intArrayOf(0, 0, 1, 1)), Solution().findFarmland(land))
    }

    @Test
    fun example3() {
        check(emptyArray(), Solution().findFarmland(arrayOf(intArrayOf(0))))
    }

    @Test
    fun twoSeparateGroupsInOneRow() {
        val land = arrayOf(intArrayOf(1, 0, 1))
        check(
            arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 2, 0, 2)),
            Solution().findFarmland(land)
        )
    }

    @Test
    fun singleCellFarmland() {
        check(arrayOf(intArrayOf(0, 0, 0, 0)), Solution().findFarmland(arrayOf(intArrayOf(1))))
    }
}
