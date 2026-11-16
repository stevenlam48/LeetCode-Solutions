package mostpopularvideocreator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MostPopularVideoCreatorTest {
    private val solution = Solution()

    @Test
    fun findsCreatorWithHighestTotalViews() {
        val result = solution.mostPopularCreator(
            arrayOf("alice", "bob", "alice", "chris"),
            arrayOf("one", "two", "three", "four"),
            intArrayOf(5, 10, 5, 15)
        )
        assertEquals(listOf(listOf("chris", "four")), result)
    }

    @Test
    fun includesEveryCreatorTiedForMaximum() {
        val result = solution.mostPopularCreator(
            arrayOf("alice", "bob", "alice", "bob"),
            arrayOf("a", "b", "c", "d"),
            intArrayOf(5, 5, 5, 5)
        )
        assertEquals(mapOf("alice" to "a", "bob" to "b"), result.associate { it[0] to it[1] })
    }

    @Test
    fun choosesMostViewedVideoThenLexicographicallySmallestId() {
        val result = solution.mostPopularCreator(
            arrayOf("alice", "alice", "alice"),
            arrayOf("z", "b", "a"),
            intArrayOf(5, 10, 10)
        )
        assertEquals(listOf(listOf("alice", "a")), result)
    }

    @Test
    fun handlesEmptyInput() {
        assertTrue(solution.mostPopularCreator(arrayOf(), arrayOf(), intArrayOf()).isEmpty())
    }
}
