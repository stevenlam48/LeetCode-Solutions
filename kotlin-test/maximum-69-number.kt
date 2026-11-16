package maximum69number

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Maximum69NumberTest {
    @Test
    fun exampleOne() {
        assertEquals(9969, Solution().maximum69Number(9669))
    }

    @Test
    fun lastDigit() {
        assertEquals(9999, Solution().maximum69Number(9996))
    }

    @Test
    fun noSix() {
        assertEquals(9999, Solution().maximum69Number(9999))
    }

    @Test
    fun singleSix() {
        assertEquals(9, Solution().maximum69Number(6))
    }
}
