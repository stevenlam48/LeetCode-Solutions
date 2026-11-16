package numberofselfdivisiblepermutations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfSelfDivisiblePermutationsTest {
    @Test
    fun testSmall() {
        assertEquals(1, Solution().selfDivisiblePermutationCount(1))
        assertEquals(1, Solution().selfDivisiblePermutationCount(2))
    }

    @Test
    fun testThree() {
        assertEquals(3, Solution().selfDivisiblePermutationCount(3))
    }

    @Test
    fun testFour() {
        assertEquals(4, Solution().selfDivisiblePermutationCount(4))
    }

    @Test
    fun testLarger() {
        assertEquals(28, Solution().selfDivisiblePermutationCount(5))
        assertEquals(16, Solution().selfDivisiblePermutationCount(6))
    }
}
