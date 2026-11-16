package minimumnumberofoperationstoreinitializeapermutation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToReinitializeAPermutationTest {
    private val solution = Solution()

    @Test
    fun twoElements() {
        assertEquals(1, solution.reinitializePermutation(2))
    }

    @Test
    fun fourElements() {
        assertEquals(2, solution.reinitializePermutation(4))
    }

    @Test
    fun sixElements() {
        assertEquals(4, solution.reinitializePermutation(6))
    }

    @Test
    fun eightElements() {
        assertEquals(3, solution.reinitializePermutation(8))
    }

    @Test
    fun tenElements() {
        assertEquals(6, solution.reinitializePermutation(10))
    }
}
