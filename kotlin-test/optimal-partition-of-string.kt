package optimalpartitionofstring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OptimalPartitionOfStringTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(4, solution.partitionString("abacaba"))
    }

    @Test
    fun testExample2() {
        assertEquals(6, solution.partitionString("ssssss"))
    }

    @Test
    fun testSingleChar() {
        assertEquals(1, solution.partitionString("a"))
    }

    @Test
    fun testAllDistinct() {
        assertEquals(1, solution.partitionString("abcdefghijklmnopqrstuvwxyz"))
    }
}
