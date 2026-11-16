package minimumcostgoodcaption

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostGoodCaptionTest {
    @Test
    fun standardExample() {
        assertEquals("cccc", Solution().minCostGoodCaption("cdcd"))
    }

    @Test
    fun tooShort() {
        assertEquals("aaa", Solution().minCostGoodCaption("aca"))
        assertEquals("", Solution().minCostGoodCaption("ab"))
    }

    @Test
    fun alreadyGood() {
        assertEquals("aaa", Solution().minCostGoodCaption("aaa"))
    }

    @Test
    fun singleGroupOfFour() {
        assertEquals("bbbb", Solution().minCostGoodCaption("abcd"))
    }
}
