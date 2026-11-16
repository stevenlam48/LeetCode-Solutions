package minimumadjacentswapstomakeavalidarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAdjacentSwapsToMakeAValidArrayTest {
    @Test
    fun standardExample() = assertEquals(6, Solution().minimumSwaps(intArrayOf(3, 4, 5, 5, 3, 1)))

    @Test
    fun alreadyValid() = assertEquals(0, Solution().minimumSwaps(intArrayOf(1, 2, 3, 3, 4)))

    @Test
    fun minimumBeforeMaximum() = assertEquals(2, Solution().minimumSwaps(intArrayOf(3, 1, 2)))

    @Test
    fun singleElement() = assertEquals(0, Solution().minimumSwaps(intArrayOf(7)))
}
