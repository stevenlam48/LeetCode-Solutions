package maximumnumberofacceptedinvitations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfAcceptedInvitationsTest {
    private val solution = Solution()

    @Test
    fun fullGrid() {
        assertEquals(
            3,
            solution.maximumInvitations(
                arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 0, 1),
                    intArrayOf(1, 1, 1)
                )
            )
        )
    }

    @Test
    fun singleBoyTwoChoices() {
        assertEquals(
            1,
            solution.maximumInvitations(
                arrayOf(
                    intArrayOf(1, 0, 0, 1),
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0)
                )
            )
        )
    }

    @Test
    fun twoByTwo() {
        assertEquals(2, solution.maximumInvitations(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))))
    }

    @Test
    fun noEdges() {
        assertEquals(0, solution.maximumInvitations(arrayOf(intArrayOf(0))))
    }

    @Test
    fun singleEdge() {
        assertEquals(1, solution.maximumInvitations(arrayOf(intArrayOf(1))))
    }

    @Test
    fun moreGirlsThanBoys() {
        assertEquals(
            2,
            solution.maximumInvitations(arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1)))
        )
    }
}
