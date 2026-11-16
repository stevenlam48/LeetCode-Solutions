package dividenodesintothemaximumnumberofgroups

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DivideNodesIntoTheMaximumNumberOfGroupsTest {
    @Test
    fun example1() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 4),
            intArrayOf(1, 5),
            intArrayOf(2, 3),
            intArrayOf(2, 6),
            intArrayOf(3, 4),
            intArrayOf(3, 5),
            intArrayOf(5, 6)
        )
        assertEquals(4, Solution().magnificentSets(6, edges))
    }

    @Test
    fun example2() {
        val edges = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 1))
        assertEquals(-1, Solution().magnificentSets(3, edges))
    }

    @Test
    fun noEdges() {
        assertEquals(3, Solution().magnificentSets(3, emptyArray()))
    }

    @Test
    fun singleNode() {
        assertEquals(1, Solution().magnificentSets(1, emptyArray()))
    }

    @Test
    fun twoComponents() {
        val edges = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        assertEquals(4, Solution().magnificentSets(4, edges))
    }
}
