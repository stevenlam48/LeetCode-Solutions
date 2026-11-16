package maximumtotalimportanceofroads

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalImportanceOfRoadsTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(
            43L,
            solution.maximumImportance(
                5,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(0, 2),
                    intArrayOf(1, 3),
                    intArrayOf(2, 4)
                )
            )
        )
    }

    @Test
    fun sparseGraph() {
        assertEquals(
            20L,
            solution.maximumImportance(
                5,
                arrayOf(intArrayOf(0, 3), intArrayOf(2, 4), intArrayOf(1, 3))
            )
        )
    }

    @Test
    fun singleRoad() {
        assertEquals(3L, solution.maximumImportance(2, arrayOf(intArrayOf(0, 1))))
    }

    @Test
    fun noRoads() {
        assertEquals(0L, solution.maximumImportance(1, emptyArray()))
    }
}
