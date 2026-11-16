package comparestringsbyfrequencyofthesmallestcharacter

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CompareStringsByFrequencyOfTheSmallestCharacterTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(
            intArrayOf(1),
            solution.numSmallerByFrequency(arrayOf("cbd"), arrayOf("zaaaz"))
        )
    }

    @Test
    fun testExample2() {
        assertArrayEquals(
            intArrayOf(1, 2),
            solution.numSmallerByFrequency(arrayOf("bbb", "cc"), arrayOf("a", "aa", "aaa", "aaaa"))
        )
    }

    @Test
    fun testWordIsLarger() {
        assertArrayEquals(
            intArrayOf(1),
            solution.numSmallerByFrequency(arrayOf("a"), arrayOf("aaaa"))
        )
    }

    @Test
    fun testNoWordIsLarger() {
        assertArrayEquals(
            intArrayOf(0),
            solution.numSmallerByFrequency(arrayOf("zzzz"), arrayOf("a", "b"))
        )
    }

    @Test
    fun testMultipleQueries() {
        assertArrayEquals(
            intArrayOf(1, 0),
            solution.numSmallerByFrequency(arrayOf("a", "zzz"), arrayOf("aa", "b"))
        )
    }
}
