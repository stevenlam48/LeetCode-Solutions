package movingstonesuntilconsecutiveii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MovingStonesUntilConsecutiveIiTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(1, 2), Solution().numMovesStonesII(intArrayOf(7, 4, 9)))
    }

    @Test
    fun example2() {
        assertArrayEquals(intArrayOf(2, 3), Solution().numMovesStonesII(intArrayOf(6, 5, 4, 3, 10)))
    }

    @Test
    fun alreadyConsecutive() {
        assertArrayEquals(
            intArrayOf(0, 0),
            Solution().numMovesStonesII(intArrayOf(100, 101, 104, 102, 103))
        )
    }

    @Test
    fun threeStones() {
        assertArrayEquals(intArrayOf(1, 1), Solution().numMovesStonesII(intArrayOf(1, 3, 5)))
    }

    @Test
    fun oneGap() {
        assertArrayEquals(intArrayOf(1, 1), Solution().numMovesStonesII(intArrayOf(1, 2, 4)))
    }
}
