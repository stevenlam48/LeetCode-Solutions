package minimumstringlengthafterremovingsubstrings

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumStringLengthAfterRemovingSubstringsTest {
    @Test
    fun `reduces the sample through successive removals`() {
        assertEquals(2, Solution().minLength("ABFCACDB"))
    }

    @Test
    fun `leaves a string without removable adjacent pairs unchanged`() {
        assertEquals(5, Solution().minLength("ACBBD"))
    }

    @Test
    fun `removes nested pairs after earlier removals expose them`() {
        assertEquals(0, Solution().minLength("ABCD"))
        assertEquals(0, Solution().minLength("AABBCCDD"))
    }

    @Test
    fun `handles empty and single-character strings`() {
        assertEquals(0, Solution().minLength(""))
        assertEquals(1, Solution().minLength("A"))
    }
}
