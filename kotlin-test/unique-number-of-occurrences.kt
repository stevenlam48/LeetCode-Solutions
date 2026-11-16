package uniquenumberofoccurrences

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class UniqueNumberOfOccurrencesTest {
    @Test
    fun allOccurrenceCountsAreUnique() {
        assertTrue(Solution().uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3)))
    }

    @Test
    fun duplicateOccurrenceCount() {
        assertFalse(Solution().uniqueOccurrences(intArrayOf(1, 2)))
    }

    @Test
    fun negativesAndZero() {
        assertTrue(Solution().uniqueOccurrences(intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0)))
    }

    @Test
    fun emptyInput() {
        assertTrue(Solution().uniqueOccurrences(intArrayOf()))
    }
}
