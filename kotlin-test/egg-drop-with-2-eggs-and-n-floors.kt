package eggdropwith2eggsandnfloors

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EggDropWith2EggsAndNFloorsTest {
    @Test
    fun oneHundredFloors() {
        assertEquals(14, Solution().twoEggDrop(100))
    }

    @Test
    fun exactTriangularNumber() {
        assertEquals(8, Solution().twoEggDrop(36))
    }

    @Test
    fun twoFloors() {
        assertEquals(2, Solution().twoEggDrop(2))
    }

    @Test
    fun zeroAndOneFloor() {
        assertEquals(0, Solution().twoEggDrop(0))
        assertEquals(1, Solution().twoEggDrop(1))
    }
}
