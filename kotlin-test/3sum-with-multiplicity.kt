package p3sumwithmultiplicity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class P3sumwithmultiplicityTest {
    @Test
    fun example1() {
        assertEquals(20, Solution().threeSumMulti(intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5), 8))
    }

    @Test
    fun example2() {
        assertEquals(12, Solution().threeSumMulti(intArrayOf(1, 1, 2, 2, 2, 2), 5))
    }

    @Test
    fun example3() {
        assertEquals(1, Solution().threeSumMulti(intArrayOf(2, 1, 3), 6))
    }

    @Test
    fun noTriples() {
        assertEquals(0, Solution().threeSumMulti(intArrayOf(1, 2, 3), 100))
    }

    @Test
    fun allSame() {
        assertEquals(1, Solution().threeSumMulti(intArrayOf(0, 0, 0), 0))
    }
}
