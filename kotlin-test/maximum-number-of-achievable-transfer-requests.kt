package maximumnumberofachievabletransferrequests

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfAchievableTransferRequestsTest {
    private val solution = Solution()

    @Test
    fun example() {
        assertEquals(
            5,
            solution.maximumRequests(
                5,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 0),
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(2, 0),
                    intArrayOf(3, 4)
                )
            )
        )
    }

    @Test
    fun allRequestsAchievable() {
        assertEquals(
            3,
            solution.maximumRequests(
                3,
                arrayOf(intArrayOf(0, 0), intArrayOf(1, 2), intArrayOf(2, 1))
            )
        )
    }

    @Test
    fun cycleOfFour() {
        assertEquals(
            4,
            solution.maximumRequests(
                4,
                arrayOf(
                    intArrayOf(0, 3),
                    intArrayOf(3, 1),
                    intArrayOf(1, 2),
                    intArrayOf(2, 0)
                )
            )
        )
    }

    @Test
    fun cycleOfThree() {
        assertEquals(
            3,
            solution.maximumRequests(
                3,
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 0))
            )
        )
    }

    @Test
    fun selfLoop() {
        assertEquals(1, solution.maximumRequests(1, arrayOf(intArrayOf(0, 0))))
    }

    @Test
    fun noAchievableRequest() {
        assertEquals(0, solution.maximumRequests(2, arrayOf(intArrayOf(0, 1))))
    }
}
