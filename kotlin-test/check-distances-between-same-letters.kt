package checkdistancesbetweensameletters

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

private fun distances(): IntArray = IntArray(26)

class CheckDistancesBetweenSameLettersTest {
    private val solution = Solution()

    @Test
    fun matchingDistances() {
        val distance = distances()
        distance[0] = 1
        distance[1] = 3
        distance[2] = 0
        assertTrue(solution.checkDistances("abaccb", distance))
    }

    @Test
    fun characterAppearsMoreThanTwice() {
        val distance = distances()
        distance[0] = 2
        assertFalse(solution.checkDistances("aaa", distance))
    }

    @Test
    fun wrongDistance() {
        val distance = distances()
        distance[0] = 2
        assertFalse(solution.checkDistances("aba", distance))
    }

    @Test
    fun repeatedSingleCharacter() {
        val distance = distances()
        distance[0] = 0
        val other = distances()
        other[0] = 1
        assertTrue(solution.checkDistances("aa", distance))
        assertFalse(solution.checkDistances("aa", other))
    }
}
