package countsymmetricintegers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSymmetricIntegersTest {
    private val solution = Solution()

    @Test
    fun `counts standard examples`() {
        assertEquals(9, solution.countSymmetricIntegers(1, 100))
        assertEquals(4, solution.countSymmetricIntegers(1200, 1230))
    }

    @Test
    fun `handles a symmetric four digit number`() {
        assertEquals(1, solution.countSymmetricIntegers(1001, 1001))
    }

    @Test
    fun `excludes odd length numbers`() {
        assertEquals(0, solution.countSymmetricIntegers(111, 111))
        assertEquals(0, solution.countSymmetricIntegers(10000, 10000))
    }

    @Test
    fun `reuses memoized values across calls`() {
        assertEquals(9, solution.countSymmetricIntegers(1, 100))
        assertEquals(9, solution.countSymmetricIntegers(1, 100))
    }
}
