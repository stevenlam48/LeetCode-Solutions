package minimumgardenperimetertocollectenoughapples

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumGardenPerimeterToCollectEnoughApplesTest {
    @Test
    fun example1() {
        assertEquals(8L, Solution().minimumPerimeter(1))
    }

    @Test
    fun example2() {
        assertEquals(16L, Solution().minimumPerimeter(13))
    }

    @Test
    fun example3() {
        assertEquals(5040L, Solution().minimumPerimeter(1000000000))
    }

    @Test
    fun justAboveFirstRing() {
        assertEquals(16L, Solution().minimumPerimeter(14))
    }
}
