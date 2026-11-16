package findthefirstplayertowinkgamesinarow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheFirstPlayerToWinKGamesInARowTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().findWinningPlayer(intArrayOf(4, 2, 6, 3, 9), 2))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().findWinningPlayer(intArrayOf(2, 5, 4), 3))
    }

    @Test
    fun kEqualsOne() {
        assertEquals(1, Solution().findWinningPlayer(intArrayOf(1, 2, 3, 4, 5), 1))
    }

    @Test
    fun singlePlayer() {
        assertEquals(0, Solution().findWinningPlayer(intArrayOf(5), 1))
    }

    @Test
    fun kLargerThanGames() {
        assertEquals(1, Solution().findWinningPlayer(intArrayOf(1, 2), 5))
    }
}
