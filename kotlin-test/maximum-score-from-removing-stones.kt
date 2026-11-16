package maximumscorefromremovingstones

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreFromRemovingStonesTest {
    @Test
    fun exampleOne() {
        assertEquals(6, Solution().maximumScore(2, 4, 6))
    }

    @Test
    fun exampleTwo() {
        assertEquals(7, Solution().maximumScore(4, 4, 6))
    }

    @Test
    fun exampleThree() {
        assertEquals(8, Solution().maximumScore(1, 8, 8))
    }

    @Test
    fun twoEmptyPiles() {
        assertEquals(0, Solution().maximumScore(0, 0, 5))
    }

    @Test
    fun equalPiles() {
        assertEquals(1, Solution().maximumScore(1, 1, 1))
    }
}
