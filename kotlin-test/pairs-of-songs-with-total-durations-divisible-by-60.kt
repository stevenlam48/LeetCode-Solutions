package pairsofsongswithtotaldurationsdivisibleby60

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PairsOfSongsWithTotalDurationsDivisibleBy60Test {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals(3, solution.numPairsDivisibleBy60(intArrayOf(30, 20, 150, 100, 40)))
        assertEquals(3, solution.numPairsDivisibleBy60(intArrayOf(60, 60, 60)))
    }

    @Test
    fun tooFewSongs() {
        assertEquals(0, solution.numPairsDivisibleBy60(intArrayOf()))
        assertEquals(0, solution.numPairsDivisibleBy60(intArrayOf(60)))
    }

    @Test
    fun durationsAboveSixty() {
        assertEquals(4, solution.numPairsDivisibleBy60(intArrayOf(20, 40, 60, 120, 180)))
    }
}
