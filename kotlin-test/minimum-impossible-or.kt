package minimumimpossibleor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumImpossibleOrTest {
    @Test
    fun example1() {
        assertEquals(4, Solution().minImpossibleOR(intArrayOf(2, 1)))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().minImpossibleOR(intArrayOf(5, 3, 2)))
    }

    @Test
    fun powersOfTwoUpToEight() {
        assertEquals(16, Solution().minImpossibleOR(intArrayOf(1, 2, 4, 8)))
    }

    @Test
    fun singleOne() {
        assertEquals(2, Solution().minImpossibleOR(intArrayOf(1)))
    }

    @Test
    fun contiguousPowersOfTwo() {
        assertEquals(64, Solution().minImpossibleOR(intArrayOf(1, 2, 4, 8, 16, 32)))
    }
}
