package designaleaderboard

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DesignALeaderboardTest {
    @Test
    fun testExample() {
        val lb = Leaderboard()
        lb.addScore(1, 73)
        lb.addScore(2, 56)
        lb.addScore(3, 39)
        lb.addScore(4, 51)
        lb.addScore(5, 4)
        assertEquals(73, lb.top(1))
        lb.reset(1)
        lb.reset(2)
        lb.addScore(2, 51)
        assertEquals(141, lb.top(3))
        lb.addScore(4, 39)
        assertEquals(184, lb.top(5))
    }

    @Test
    fun testAccumulateScores() {
        val lb = Leaderboard()
        lb.addScore(1, 10)
        lb.addScore(1, 20)
        assertEquals(30, lb.top(1))
    }

    @Test
    fun testResetToZero() {
        val lb = Leaderboard()
        lb.addScore(1, 50)
        lb.reset(1)
        assertEquals(0, lb.top(1))
    }

    @Test
    fun testTopMoreThanPlayers() {
        val lb = Leaderboard()
        lb.addScore(1, 5)
        lb.addScore(2, 3)
        assertEquals(8, lb.top(10))
    }
}
