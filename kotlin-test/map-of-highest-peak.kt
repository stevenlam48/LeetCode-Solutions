package mapofhighestpeak

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MapOfHighestPeakTest {
    private fun check(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun testExample1() {
        check(
            arrayOf(intArrayOf(1, 0), intArrayOf(2, 1)),
            Solution().highestPeak(arrayOf(intArrayOf(0, 1), intArrayOf(0, 0)))
        )
    }

    @Test
    fun testExample2() {
        check(
            arrayOf(intArrayOf(1, 1, 0), intArrayOf(0, 1, 1), intArrayOf(1, 2, 2)),
            Solution().highestPeak(
                arrayOf(
                    intArrayOf(0, 0, 1),
                    intArrayOf(1, 0, 0),
                    intArrayOf(0, 0, 0)
                )
            )
        )
    }

    @Test
    fun testAllWater() {
        check(
            arrayOf(intArrayOf(0, 0), intArrayOf(0, 0)),
            Solution().highestPeak(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1)))
        )
    }

    @Test
    fun testSingleCellWater() {
        check(arrayOf(intArrayOf(0)), Solution().highestPeak(arrayOf(intArrayOf(1))))
    }

    @Test
    fun testCornerWater() {
        check(
            arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 3)),
            Solution().highestPeak(
                arrayOf(
                    intArrayOf(1, 0, 0),
                    intArrayOf(0, 0, 0)
                )
            )
        )
    }
}
