package countingelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountingElementsTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().countElements(intArrayOf(1, 2, 3)))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().countElements(intArrayOf(1, 1, 3, 3, 5, 5, 7, 7)))
    }

    @Test
    fun example3() {
        assertEquals(2, Solution().countElements(intArrayOf(1, 1, 2, 2)))
    }

    @Test
    fun mixed() {
        assertEquals(3, Solution().countElements(intArrayOf(1, 3, 2, 3, 5, 6)))
    }

    @Test
    fun duplicatesCountedSeparately() {
        assertEquals(3, Solution().countElements(intArrayOf(1, 1, 1, 2)))
    }
}
