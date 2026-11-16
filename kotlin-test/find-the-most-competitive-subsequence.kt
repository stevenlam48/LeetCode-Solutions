package findthemostcompetitivesubsequence

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindTheMostCompetitiveSubsequenceTest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(2, 6),
            Solution().mostCompetitive(intArrayOf(3, 5, 2, 6), 2)
        )
    }

    @Test
    fun example2() {
        assertArrayEquals(
            intArrayOf(2, 3, 3, 4),
            Solution().mostCompetitive(intArrayOf(2, 4, 3, 3, 5, 4, 9, 6), 4)
        )
    }

    @Test
    fun wholeArray() {
        assertArrayEquals(
            intArrayOf(1, 2, 3),
            Solution().mostCompetitive(intArrayOf(1, 2, 3), 3)
        )
    }
}
