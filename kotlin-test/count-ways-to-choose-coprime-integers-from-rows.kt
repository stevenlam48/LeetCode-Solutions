package countwaystochoosecoprimeintegersfromrows

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountWaysToChooseCoprimeIntegersFromRowsTest {
    @Test
    fun example1() {
        assertEquals(
            3,
            Solution().countCoprime(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)))
        )
    }

    @Test
    fun example2() {
        assertEquals(
            0,
            Solution().countCoprime(arrayOf(intArrayOf(2, 2), intArrayOf(2, 2)))
        )
    }

    @Test
    fun allOnes() {
        assertEquals(
            4,
            Solution().countCoprime(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1)))
        )
    }

    @Test
    fun singleRowWithOne() {
        assertEquals(1, Solution().countCoprime(arrayOf(intArrayOf(1, 2, 3))))
    }

    @Test
    fun singleRow() {
        assertEquals(0, Solution().countCoprime(arrayOf(intArrayOf(2, 3, 4))))
    }

    @Test
    fun pairwiseCoprime() {
        assertEquals(
            4,
            Solution().countCoprime(arrayOf(intArrayOf(2, 3), intArrayOf(5, 7)))
        )
    }
}
