package sumofincreasingproductblocks

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfIncreasingProductBlocksTest {
    @Test
    fun smallNumberOfBlocks() {
        assertEquals(1, Solution().sumOfBlocks(1))
        assertEquals(7, Solution().sumOfBlocks(2))
        assertEquals(127, Solution().sumOfBlocks(3))
    }

    @Test
    fun fourBlocks() {
        assertEquals(5167, Solution().sumOfBlocks(4))
    }

    @Test
    fun fiveBlocks() {
        assertEquals(365527, Solution().sumOfBlocks(5))
    }
}
