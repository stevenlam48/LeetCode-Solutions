package identifythelargestoutlierinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IdentifyTheLargestOutlierInAnArrayTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().getLargestOutlier(intArrayOf(2, 3, 1, 2)))
    }

    @Test
    fun example2() {
        assertEquals(4, Solution().getLargestOutlier(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun negatives() {
        assertEquals(-2, Solution().getLargestOutlier(intArrayOf(-2, -1, -3, -4)))
    }

    @Test
    fun allEqual() {
        assertEquals(1, Solution().getLargestOutlier(intArrayOf(1, 1, 1)))
    }

    @Test
    fun largerArray() {
        assertEquals(6, Solution().getLargestOutlier(intArrayOf(1, 2, 3, 6)))
    }
}
