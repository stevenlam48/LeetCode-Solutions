package missingelementinsortedarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MissingElementInSortedArrayTest {
    private val solution = Solution()

    @Test
    fun findsFirstMissingElement() {
        assertEquals(5, solution.missingElement(intArrayOf(4, 7, 9, 10), 1))
    }

    @Test
    fun skipsSeveralMissingElements() {
        assertEquals(8, solution.missingElement(intArrayOf(4, 7, 9, 10), 3))
    }

    @Test
    fun findsMissingElementAfterLastValue() {
        assertEquals(5, solution.missingElement(intArrayOf(1, 2, 3), 2))
    }

    @Test
    fun handlesSingleElement() {
        assertEquals(4, solution.missingElement(intArrayOf(1), 3))
    }
}
