package missingnumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MissingNumberTest {
    private val solution = Solution()

    @Test
    fun findsMissingNumberInShortArray() {
        assertEquals(2, solution.missingNumber(intArrayOf(3, 0, 1)))
    }

    @Test
    fun findsMissingTwoValueRangeEndpoint() {
        assertEquals(2, solution.missingNumber(intArrayOf(0, 1)))
    }

    @Test
    fun findsMissingNumberInLongerArray() {
        assertEquals(8, solution.missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))
    }

    @Test
    fun handlesEmptyArray() {
        assertEquals(0, solution.missingNumber(intArrayOf()))
    }
}
