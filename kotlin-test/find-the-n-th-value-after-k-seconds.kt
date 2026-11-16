package findthenthvalueafterkseconds

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheNThValueAfterKSecondsTest {
    @Test
    fun example1() {
        assertEquals(56, Solution().valueAfterKSeconds(4, 5))
    }

    @Test
    fun example2() {
        assertEquals(35, Solution().valueAfterKSeconds(5, 3))
    }

    @Test
    fun zeroSeconds() {
        assertEquals(1, Solution().valueAfterKSeconds(1, 0))
    }

    @Test
    fun oneSecond() {
        assertEquals(2, Solution().valueAfterKSeconds(2, 1))
    }
}
