package mostvisitedsectorinacirculartrack

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MostVisitedSectorInACircularTrackTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(1, 2), Solution().mostVisited(4, intArrayOf(1, 3, 1, 2)))
    }

    @Test
    fun example2() {
        assertArrayEquals(intArrayOf(2), Solution().mostVisited(2, intArrayOf(2, 1, 2, 1, 2, 1, 2, 1, 2)))
    }

    @Test
    fun example3() {
        assertArrayEquals(
            intArrayOf(1, 2, 3, 4, 5, 6, 7),
            Solution().mostVisited(7, intArrayOf(1, 3, 5, 7))
        )
    }

    @Test
    fun singleRound() {
        assertArrayEquals(intArrayOf(3), Solution().mostVisited(5, intArrayOf(3)))
    }

    @Test
    fun wrapAround() {
        assertArrayEquals(intArrayOf(1, 2, 5), Solution().mostVisited(5, intArrayOf(5, 2)))
    }
}
