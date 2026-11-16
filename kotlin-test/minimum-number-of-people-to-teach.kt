package minimumnumberofpeopletoteach

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfPeopleToTeachTest {
    private val solution = Solution()

    @Test
    fun firstLeetCodeExample() {
        assertEquals(
            1,
            solution.minimumTeachings(
                2,
                arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(1, 2)),
                arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 3))
            )
        )
    }

    @Test
    fun secondLeetCodeExample() {
        assertEquals(
            2,
            solution.minimumTeachings(
                3,
                arrayOf(intArrayOf(2), intArrayOf(1, 3), intArrayOf(1, 2), intArrayOf(3)),
                arrayOf(intArrayOf(1, 4), intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(2, 3))
            )
        )
    }

    @Test
    fun returnsZeroWhenEveryFriendshipSharesALanguage() {
        assertEquals(
            0,
            solution.minimumTeachings(
                3,
                arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(1, 3)),
                arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(1, 3))
            )
        )
    }

    @Test
    fun teachesOnePersonForSingleDisconnectedFriendship() {
        assertEquals(
            1,
            solution.minimumTeachings(
                2,
                arrayOf(intArrayOf(1), intArrayOf(2)),
                arrayOf(intArrayOf(1, 2))
            )
        )
    }

    @Test
    fun usesLanguageKnownByMostCandidates() {
        assertEquals(
            1,
            solution.minimumTeachings(
                3,
                arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(1, 3), intArrayOf(1)),
                arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(1, 4))
            )
        )
    }
}
