package dota2senate

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Dota2SenateTest {
    @Test
    fun example1() {
        assertEquals("Radiant", Solution().predictPartyVictory("RD"))
    }

    @Test
    fun example2() {
        assertEquals("Dire", Solution().predictPartyVictory("RDD"))
    }

    @Test
    fun example3() {
        assertEquals("Radiant", Solution().predictPartyVictory("RRDDD"))
    }

    @Test
    fun example4() {
        assertEquals("Dire", Solution().predictPartyVictory("DRDRDRDR"))
    }

    @Test
    fun singleParty() {
        assertEquals("Radiant", Solution().predictPartyVictory("RRR"))
        assertEquals("Dire", Solution().predictPartyVictory("DDD"))
    }
}
