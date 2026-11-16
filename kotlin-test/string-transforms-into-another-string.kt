package stringtransformsintoanotherstring

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class StringTransformsIntoAnotherStringTest {
    @Test
    fun `many source characters can map together`() {
        assertTrue(Solution().canConvert("aabcc", "ccdee"))
    }

    @Test
    fun `inconsistent mapping fails`() {
        assertFalse(Solution().canConvert("leetcode", "codeleet"))
    }

    @Test
    fun `equal strings need no spare character`() {
        assertTrue(Solution().canConvert("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz"))
    }

    @Test
    fun `full alphabet permutation without spare character fails`() {
        assertFalse(Solution().canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza"))
    }
}
