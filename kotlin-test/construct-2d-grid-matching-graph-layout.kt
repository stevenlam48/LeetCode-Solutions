package construct2dgridmatchinggraphlayout

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Construct2dGridMatchingGraphLayoutTest {
    @Test
    fun constructsSquareLayout() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(2, 3))
        assertGridEquals(arrayOf(intArrayOf(0, 1), intArrayOf(2, 3)), Solution().constructGridLayout(4, edges))
    }

    @Test
    fun constructsRectangularLayout() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(0, 3),
            intArrayOf(1, 4),
            intArrayOf(2, 5),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
        )
        assertGridEquals(arrayOf(intArrayOf(0, 3), intArrayOf(1, 4), intArrayOf(2, 5)), Solution().constructGridLayout(6, edges))
    }

    @Test
    fun constructsSingleRowLayout() {
        assertGridEquals(arrayOf(intArrayOf(0, 1)), Solution().constructGridLayout(2, arrayOf(intArrayOf(0, 1))))
    }
}

private fun assertGridEquals(expected: Array<IntArray>, actual: Array<IntArray>) {
    assertEquals(expected.map { it.toList() }, actual.map { it.toList() })
}
