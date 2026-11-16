package poorpigs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PoorPigsTest {
    @Test
    fun standardExample() {
        assertEquals(5, Solution().poorPigs(1000, 15, 60))
    }

    @Test
    fun oneTestRound() {
        assertEquals(2, Solution().poorPigs(4, 15, 15))
    }

    @Test
    fun singleBucket() {
        assertEquals(0, Solution().poorPigs(1, 15, 60))
    }

    @Test
    fun exactPowerOfStates() {
        assertEquals(3, Solution().poorPigs(125, 10, 50))
    }
}
