package countofsmallernumbersafterself

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountOfSmallerNumbersAfterSelfTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(2, 1, 1, 0), solution.countSmaller(intArrayOf(5, 2, 6, 1)))
    }

    @Test
    fun testExample2() {
        assertArrayEquals(intArrayOf(0), solution.countSmaller(intArrayOf(-1)))
    }

    @Test
    fun testDuplicates() {
        assertArrayEquals(intArrayOf(0, 0), solution.countSmaller(intArrayOf(-1, -1)))
    }

    @Test
    fun testMixed() {
        assertArrayEquals(intArrayOf(2, 0, 0), solution.countSmaller(intArrayOf(2, 0, 1)))
    }

    @Test
    fun testEmpty() {
        assertArrayEquals(intArrayOf(), solution.countSmaller(intArrayOf()))
    }
}
