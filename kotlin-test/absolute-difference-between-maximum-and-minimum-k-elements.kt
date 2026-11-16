package absolutedifferencebetweenmaximumandminimumkelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PabsolutedifferencebetweenmaximumandminimumkelementsTest {
    @Test
    fun example1() {
        assertEquals(5, Solution().absDifference(intArrayOf(5, 2, 2, 4), 2))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().absDifference(intArrayOf(100, 1, 10), 3))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().absDifference(intArrayOf(7), 1))
    }

    @Test
    fun negatives() {
        assertEquals(4, Solution().absDifference(intArrayOf(-1, -2, -3, -4), 2))
    }

    @Test
    fun allEqual() {
        assertEquals(0, Solution().absDifference(intArrayOf(3, 3, 3, 3), 2))
    }
}
