package reorganizestring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReorganizeStringTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals("aba", solution.reorganizeString("aab"))
    }

    @Test
    fun impossibleArrangement() {
        assertEquals("", solution.reorganizeString("aaab"))
    }

    @Test
    fun dominantCharacterUsesRemainingHeapEntry() {
        assertEquals("vovlv", solution.reorganizeString("vvvlo"))
    }

    @Test
    fun tiesFollowCharacterPriority() {
        assertEquals("baba", solution.reorganizeString("aabb"))
    }
}
