package minimumnumberofmovestoseateveryone

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfMovesToSeatEveryoneTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(
            4,
            solution.minMovesToSeat(intArrayOf(3, 1, 5), intArrayOf(2, 7, 4))
        )
    }

    @Test
    fun moreStudents() {
        assertEquals(
            7,
            solution.minMovesToSeat(intArrayOf(4, 1, 5, 9), intArrayOf(1, 3, 2, 6))
        )
    }

    @Test
    fun duplicates() {
        assertEquals(
            4,
            solution.minMovesToSeat(intArrayOf(2, 2, 6, 6), intArrayOf(1, 3, 2, 6))
        )
    }

    @Test
    fun singleSeat() {
        assertEquals(0, solution.minMovesToSeat(intArrayOf(1), intArrayOf(1)))
    }
}
