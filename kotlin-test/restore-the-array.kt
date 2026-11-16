package restorethearray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RestoreTheArrayTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().numberOfArrays("1000", 10000))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().numberOfArrays("1000", 10))
    }

    @Test
    fun example3() {
        assertEquals(8, Solution().numberOfArrays("1317", 2000))
    }

    @Test
    fun example4() {
        assertEquals(1, Solution().numberOfArrays("2020", 30))
    }

    @Test
    fun example5() {
        assertEquals(34, Solution().numberOfArrays("1234567890", 90))
    }

    @Test
    fun wholeNumberOnly() {
        assertEquals(1, Solution().numberOfArrays("10", 10))
    }

    @Test
    fun singleZeroIsInvalid() {
        assertEquals(0, Solution().numberOfArrays("0", 10))
    }
}
