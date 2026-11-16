package findsubtreesizesafterchanges

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindSubtreeSizesAfterChangesTest {
    @Test
    fun testReparenting() {
        assertArrayEquals(
            intArrayOf(4, 1, 2, 1),
            Solution().findSubtreeSizes(intArrayOf(-1, 0, 1, 2), "abaa")
        )
    }

    @Test
    fun testStar() {
        assertArrayEquals(
            intArrayOf(3, 1, 1),
            Solution().findSubtreeSizes(intArrayOf(-1, 0, 0), "aaa")
        )
    }

    @Test
    fun testChain() {
        assertArrayEquals(
            intArrayOf(3, 1, 1),
            Solution().findSubtreeSizes(intArrayOf(-1, 0, 1), "aba")
        )
    }

    @Test
    fun testSingleNode() {
        assertArrayEquals(intArrayOf(1), Solution().findSubtreeSizes(intArrayOf(-1), "a"))
    }

    @Test
    fun testAllSameCharacterChain() {
        assertArrayEquals(
            intArrayOf(3, 2, 1),
            Solution().findSubtreeSizes(intArrayOf(-1, 0, 1), "aaa")
        )
    }
}
