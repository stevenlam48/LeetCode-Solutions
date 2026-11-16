package similarstringgroups

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SimilarStringGroupsTest {
    private val solution = Solution()

    @Test
    fun `two disconnected similarity groups`() {
        assertEquals(2, solution.numSimilarGroups(listOf("tars", "rats", "arts", "star")))
    }

    @Test
    fun `single swapped pair`() {
        assertEquals(1, solution.numSimilarGroups(listOf("omv", "ovm")))
    }

    @Test
    fun `empty input`() {
        assertEquals(0, solution.numSimilarGroups(emptyList()))
    }

    @Test
    fun `identical words are not merged by reference algorithm`() {
        assertEquals(2, solution.numSimilarGroups(listOf("abc", "abc")))
    }
}
