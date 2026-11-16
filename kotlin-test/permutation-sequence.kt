package permutationsequence

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PermutationSequenceTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("213", solution.getPermutation(3, 3))
    }

    @Test
    fun testExample2() {
        assertEquals("2314", solution.getPermutation(4, 9))
    }

    @Test
    fun testFirstPermutation() {
        assertEquals("123", solution.getPermutation(3, 1))
    }

    @Test
    fun testSingleElement() {
        assertEquals("1", solution.getPermutation(1, 1))
    }
}
