package ringsandrods

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RingsAndRodsTest {
    @Test
    fun exampleOne() {
        assertEquals(1, Solution().countPoints("B0B6G0R6R0R6G9"))
    }

    @Test
    fun exampleTwo() {
        assertEquals(1, Solution().countPoints("B0R0G0R9R0B0G0"))
    }

    @Test
    fun exampleThree() {
        assertEquals(0, Solution().countPoints("G4"))
    }

    @Test
    fun everyRodHasAllColors() {
        assertEquals(2, Solution().countPoints("R0G0B0R1G1B1"))
    }
}
