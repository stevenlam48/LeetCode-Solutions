package divideplayersintoteamsofequalskill

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DividePlayersIntoTeamsOfEqualSkillTest {
    @Test
    fun example1() {
        assertEquals(22L, Solution().dividePlayers(intArrayOf(3, 2, 5, 1, 3, 4)))
    }

    @Test
    fun example2() {
        assertEquals(12L, Solution().dividePlayers(intArrayOf(3, 4)))
    }

    @Test
    fun example3() {
        assertEquals(-1L, Solution().dividePlayers(intArrayOf(1, 1, 2, 3)))
    }

    @Test
    fun singleTeam() {
        assertEquals(1L, Solution().dividePlayers(intArrayOf(1, 1)))
    }

    @Test
    fun largeValues() {
        assertEquals(2000000000000L, Solution().dividePlayers(intArrayOf(1000000, 1000000, 1000000, 1000000)))
    }
}
