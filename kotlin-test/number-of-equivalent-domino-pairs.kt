package numberofequivalentdominopairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfEquivalentDominoPairsTest {
    @Test
    fun testExample1() {
        val dominoes = arrayOf(
            intArrayOf(1, 2), intArrayOf(2, 1), intArrayOf(3, 4), intArrayOf(5, 6)
        )
        assertEquals(1, Solution().numEquivDominoPairs(dominoes))
    }

    @Test
    fun testExample2() {
        val dominoes = arrayOf(
            intArrayOf(1, 2), intArrayOf(1, 2), intArrayOf(1, 1),
            intArrayOf(1, 2), intArrayOf(2, 2)
        )
        assertEquals(3, Solution().numEquivDominoPairs(dominoes))
    }

    @Test
    fun testSingleDomino() {
        assertEquals(0, Solution().numEquivDominoPairs(arrayOf(intArrayOf(1, 1))))
    }

    @Test
    fun testFourIdentical() {
        val dominoes = arrayOf(
            intArrayOf(2, 1), intArrayOf(1, 2), intArrayOf(1, 2), intArrayOf(1, 2)
        )
        assertEquals(6, Solution().numEquivDominoPairs(dominoes))
    }
}
