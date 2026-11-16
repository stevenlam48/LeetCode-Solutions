package containsduplicate

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ContainsDuplicateTest {
    @Test
    fun duplicateIsPresent() {
        assertTrue(Solution().containsDuplicate(intArrayOf(1, 2, 3, 1)))
    }

    @Test
    fun allValuesAreDistinct() {
        assertFalse(Solution().containsDuplicate(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun severalValuesRepeat() {
        assertTrue(Solution().containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
    }

    @Test
    fun emptyAndSingleInputsHaveNoDuplicate() {
        assertFalse(Solution().containsDuplicate(intArrayOf()))
        assertFalse(Solution().containsDuplicate(intArrayOf(1)))
    }
}
