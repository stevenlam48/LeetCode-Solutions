package nextgreaternumericallybalancednumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NextGreaterNumericallyBalancedNumberTest {
    @Test
    fun `finds smallest balanced number greater than input`() {
        assertEquals(22, Solution().nextBeautifulNumber(1))
        assertEquals(1333, Solution().nextBeautifulNumber(1000))
    }

    @Test
    fun `skips unbalanced permutations`() {
        assertEquals(3133, Solution().nextBeautifulNumber(3000))
        assertEquals(122, Solution().nextBeautifulNumber(22))
    }

    @Test
    fun `finds seven digit answer when needed`() {
        assertEquals(1224444, Solution().nextBeautifulNumber(666666))
    }

    @Test
    fun `handles zero`() {
        assertEquals(1, Solution().nextBeautifulNumber(0))
    }
}
