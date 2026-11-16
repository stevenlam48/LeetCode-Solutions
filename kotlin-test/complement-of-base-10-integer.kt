package complementofbase10integer

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ComplementOfBase10IntegerTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.bitwiseComplement(5))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.bitwiseComplement(7))
    }

    @Test
    fun testExample3() {
        assertEquals(5, solution.bitwiseComplement(10))
    }

    @Test
    fun testZero() {
        assertEquals(1, solution.bitwiseComplement(0))
    }

    @Test
    fun testPowerOfTwo() {
        assertEquals(0, solution.bitwiseComplement(1))
        assertEquals(3, solution.bitwiseComplement(4))
    }
}
