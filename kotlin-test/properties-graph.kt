package propertiesgraph

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PropertiesGraphTest {
    private val solution = Solution()

    @Test
    fun validCase1_connectedPairs() {
        val actual = solution.numberOfComponents(
            arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(4, 5)), 1
        )
        assertEquals(2, actual)
    }

    @Test
    fun validCase2_largerThreshold() {
        val actual = solution.numberOfComponents(
            arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(4, 5)), 2
        )
        assertEquals(3, actual)
    }

    @Test
    fun validCase3_duplicateValues() {
        val actual = solution.numberOfComponents(
            arrayOf(intArrayOf(1, 1, 2), intArrayOf(2, 1, 1)), 2
        )
        assertEquals(1, actual)
    }

    @Test
    fun validCase4_allIdentical() {
        val actual = solution.numberOfComponents(
            arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1)), 1
        )
        assertEquals(1, actual)
    }

    @Test
    fun validCase5_disconnectedVertices() {
        val actual = solution.numberOfComponents(
            arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3)), 1
        )
        assertEquals(3, actual)
    }

    @Test
    fun validCase6_transitivelyConnected() {
        val actual = solution.numberOfComponents(
            arrayOf(intArrayOf(1, 2, 3), intArrayOf(2, 3, 4), intArrayOf(3, 4, 5)), 2
        )
        assertEquals(1, actual)
    }
}
