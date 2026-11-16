package findthechildwhohastheballafterkseconds

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheChildWhoHasTheBallAfterKSecondsTest {
    @Test
    fun handlesThreeChildren() {
        assertEquals(1, Solution().numberOfChild(3, 5))
    }

    @Test
    fun handlesFiveChildren() {
        assertEquals(2, Solution().numberOfChild(5, 6))
    }

    @Test
    fun handlesTwoChildrenAndDirectionChanges() {
        val solution = Solution()
        assertEquals(0, solution.numberOfChild(2, 0))
        assertEquals(1, solution.numberOfChild(2, 1))
        assertEquals(0, solution.numberOfChild(2, 2))
    }
}
