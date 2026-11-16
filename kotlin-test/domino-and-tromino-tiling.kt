package dominoandtrominotiling

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DominoAndTrominoTilingTest {
    @Test
    fun one() {
        assertEquals(1, Solution().numTilings(1))
    }

    @Test
    fun two() {
        assertEquals(2, Solution().numTilings(2))
    }

    @Test
    fun three() {
        assertEquals(5, Solution().numTilings(3))
    }

    @Test
    fun four() {
        assertEquals(11, Solution().numTilings(4))
    }

    @Test
    fun five() {
        assertEquals(24, Solution().numTilings(5))
    }

    @Test
    fun thirty() {
        assertEquals(312342182, Solution().numTilings(30))
    }
}
