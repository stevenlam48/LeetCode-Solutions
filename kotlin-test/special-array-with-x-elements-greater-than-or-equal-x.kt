package specialarraywithxelementsgreaterthanorequalx

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SpecialArrayWithXElementsGreaterThanOrEqualXTest {
    @Test
    fun exampleOne() {
        assertEquals(2, Solution().specialArray(intArrayOf(3, 5)))
    }

    @Test
    fun allZeros() {
        assertEquals(-1, Solution().specialArray(intArrayOf(0, 0)))
    }

    @Test
    fun exampleThree() {
        assertEquals(3, Solution().specialArray(intArrayOf(0, 4, 3, 0, 4)))
    }

    @Test
    fun noSpecialValue() {
        assertEquals(-1, Solution().specialArray(intArrayOf(3, 6, 7, 7, 0)))
    }
}
