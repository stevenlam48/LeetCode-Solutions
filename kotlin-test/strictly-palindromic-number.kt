package strictlypalindromicnumber

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class StrictlyPalindromicNumberTest {
    @Test
    fun `four is not strictly palindromic`() {
        assertFalse(Solution().isStrictlyPalindromic(4))
    }

    @Test
    fun `nine is not strictly palindromic`() {
        assertFalse(Solution().isStrictlyPalindromic(9))
    }

    @Test
    fun `larger values are not strictly palindromic`() {
        assertFalse(Solution().isStrictlyPalindromic(100000))
    }
}
