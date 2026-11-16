package distributecandiestopeople

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DistributeCandiesToPeopleTest {
    private val solution = Solution()

    @Test
    fun partialFinalTurn() {
        assertArrayEquals(intArrayOf(1, 2, 3, 1), solution.distributeCandies(7, 4))
    }

    @Test
    fun multipleRows() {
        assertArrayEquals(intArrayOf(5, 2, 3), solution.distributeCandies(10, 3))
    }

    @Test
    fun noCandies() {
        assertArrayEquals(intArrayOf(0, 0, 0), solution.distributeCandies(0, 3))
    }

    @Test
    fun singlePerson() {
        assertArrayEquals(intArrayOf(1), solution.distributeCandies(1, 1))
    }
}
