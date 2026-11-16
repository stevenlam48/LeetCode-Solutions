package numberofuniquegoodsubsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfUniqueGoodSubsequencesTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().numberOfUniqueGoodSubsequences("001"))
    }

    @Test
    fun example2() {
        assertEquals(5, Solution().numberOfUniqueGoodSubsequences("101"))
    }

    @Test
    fun allZeros() {
        assertEquals(1, Solution().numberOfUniqueGoodSubsequences("0000"))
    }

    @Test
    fun singleOne() {
        assertEquals(1, Solution().numberOfUniqueGoodSubsequences("1"))
    }

    @Test
    fun singleZero() {
        assertEquals(1, Solution().numberOfUniqueGoodSubsequences("0"))
    }

    @Test
    fun repeatedOnes() {
        assertEquals(2, Solution().numberOfUniqueGoodSubsequences("11"))
    }
}
