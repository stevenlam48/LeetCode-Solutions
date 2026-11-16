package preimagesizeoffactorialzeroesfunction

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PreimageSizeOfFactorialZeroesFunctionTest {
    @Test
    fun zero() {
        assertEquals(5, Solution().preimageSizeFZF(0))
    }

    @Test
    fun five() {
        assertEquals(0, Solution().preimageSizeFZF(5))
    }

    @Test
    fun three() {
        assertEquals(5, Solution().preimageSizeFZF(3))
    }

    @Test
    fun eleven() {
        assertEquals(0, Solution().preimageSizeFZF(11))
    }

    @Test
    fun twelve() {
        assertEquals(5, Solution().preimageSizeFZF(12))
    }

    @Test
    fun one() {
        assertEquals(5, Solution().preimageSizeFZF(1))
    }
}
