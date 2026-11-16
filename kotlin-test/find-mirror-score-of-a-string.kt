package findmirrorscoreofastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMirrorScoreOfAStringTest {
    @Test
    fun example1() {
        assertEquals(5L, Solution().calculateScore("aczzx"))
    }

    @Test
    fun example2() {
        assertEquals(0L, Solution().calculateScore("abcdef"))
    }

    @Test
    fun singlePair() {
        assertEquals(1L, Solution().calculateScore("az"))
    }

    @Test
    fun reversedPair() {
        assertEquals(1L, Solution().calculateScore("za"))
    }

    @Test
    fun repeatedMirrors() {
        assertEquals(2L, Solution().calculateScore("azaz"))
    }

    @Test
    fun noMirrorPartner() {
        assertEquals(0L, Solution().calculateScore("zz"))
    }
}
