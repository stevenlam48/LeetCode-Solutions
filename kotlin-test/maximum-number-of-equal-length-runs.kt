package maximumnumberofequallengthruns

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfEqualLengthRunsTest {
    private val solution = Solution()

    @Test
    fun allSingleRuns() {
        assertEquals(5, solution.maxSameLengthRuns("ababa"))
    }

    @Test
    fun threeRunsOfLengthTwo() {
        assertEquals(3, solution.maxSameLengthRuns("aabbaa"))
    }

    @Test
    fun twoRunsOfLengthThree() {
        assertEquals(2, solution.maxSameLengthRuns("aaabbb"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, solution.maxSameLengthRuns("a"))
    }

    @Test
    fun oneLongRun() {
        assertEquals(1, solution.maxSameLengthRuns("aaaa"))
    }

    @Test
    fun sixSingleRuns() {
        assertEquals(6, solution.maxSameLengthRuns("abcabc"))
    }
}
