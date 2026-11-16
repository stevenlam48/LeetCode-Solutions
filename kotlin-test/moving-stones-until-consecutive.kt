package movingstonesuntilconsecutive

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MovingStonesUntilConsecutiveTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(1, 2), Solution().numMovesStones(1, 2, 5))
    }

    @Test
    fun example2() {
        assertArrayEquals(intArrayOf(0, 0), Solution().numMovesStones(4, 3, 2))
    }

    @Test
    fun example3() {
        assertArrayEquals(intArrayOf(1, 2), Solution().numMovesStones(3, 5, 1))
    }

    @Test
    fun alreadyConsecutiveUnsorted() {
        assertArrayEquals(intArrayOf(0, 0), Solution().numMovesStones(7, 5, 6))
    }

    @Test
    fun gapOfTwo() {
        assertArrayEquals(intArrayOf(1, 1), Solution().numMovesStones(1, 3, 4))
    }
}
