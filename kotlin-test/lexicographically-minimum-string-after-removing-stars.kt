package lexicographicallyminimumstringafterremovingstars

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallyMinimumStringAfterRemovingStarsTest {
    @Test
    fun example1() {
        assertEquals("aab", Solution().clearStars("aaba*"))
    }

    @Test
    fun removesSmallest() {
        assertEquals("bc", Solution().clearStars("abc*"))
    }

    @Test
    fun everythingRemoved() {
        assertEquals("", Solution().clearStars("a*b*"))
    }

    @Test
    fun starBeforeLetters() {
        assertEquals("a", Solution().clearStars("*a"))
    }
}
