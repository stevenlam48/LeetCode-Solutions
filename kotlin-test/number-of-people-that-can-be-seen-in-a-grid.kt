package numberofpeoplethatcanbeseeninagrid

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfPeopleThatCanBeSeenInAGridTest {
    private val solution = Solution()

    @Test
    fun `counts visible people in one row`() {
        assertGridEquals(
            arrayOf(intArrayOf(2, 1, 2, 1, 0)),
            solution.seePeople(arrayOf(intArrayOf(3, 1, 4, 2, 5)))
        )
    }

    @Test
    fun `combines horizontal and vertical visibility`() {
        assertGridEquals(
            arrayOf(intArrayOf(3, 1), intArrayOf(2, 1), intArrayOf(1, 0)),
            solution.seePeople(
                arrayOf(intArrayOf(5, 1), intArrayOf(3, 2), intArrayOf(4, 1))
            )
        )
    }

    @Test
    fun `handles equal heights without counting hidden duplicates`() {
        assertGridEquals(
            arrayOf(intArrayOf(1, 1, 0)),
            solution.seePeople(arrayOf(intArrayOf(2, 2, 2)))
        )
    }

    @Test
    fun `handles crossing views in a small grid`() {
        assertGridEquals(
            arrayOf(intArrayOf(2, 1), intArrayOf(1, 0)),
            solution.seePeople(arrayOf(intArrayOf(1, 2), intArrayOf(2, 1)))
        )
    }

    @Test
    fun `handles a single person`() {
        assertGridEquals(
            arrayOf(intArrayOf(0)),
            solution.seePeople(arrayOf(intArrayOf(7)))
        )
    }

    private fun assertGridEquals(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }
}
