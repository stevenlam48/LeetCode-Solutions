package dividechocolate

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DivideChocolateTest {
    @Test
    fun example1() {
        assertEquals(6, Solution().maximizeSweetness(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 5))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().maximizeSweetness(intArrayOf(5, 6, 7, 8, 9, 1, 2, 3, 4), 8))
    }

    @Test
    fun example3() {
        assertEquals(5, Solution().maximizeSweetness(intArrayOf(1, 2, 2, 1, 2, 2, 1, 2, 2), 2))
    }

    @Test
    fun noCuts() {
        assertEquals(6, Solution().maximizeSweetness(intArrayOf(1, 2, 3), 0))
    }

    @Test
    fun singlePiece() {
        assertEquals(5, Solution().maximizeSweetness(intArrayOf(5), 0))
    }
}
