package findeventualsafestates

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindEventualSafeStatesTest {
    @Test
    fun standardExample() {
        val graph = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(5),
            intArrayOf(0),
            intArrayOf(5),
            intArrayOf(),
            intArrayOf()
        )
        assertEquals(listOf(2, 4, 5, 6), Solution().eventualSafeNodes(graph))
    }

    @Test
    fun secondExample() {
        val graph = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(1, 2),
            intArrayOf(3, 4),
            intArrayOf(0, 4),
            intArrayOf()
        )
        assertEquals(listOf(4), Solution().eventualSafeNodes(graph))
    }

    @Test
    fun allTerminal() {
        val graph = arrayOf(intArrayOf(), intArrayOf())
        assertEquals(listOf(0, 1), Solution().eventualSafeNodes(graph))
    }

    @Test
    fun singleSelfLoop() {
        val graph = arrayOf(intArrayOf(0))
        assertEquals(emptyList<Int>(), Solution().eventualSafeNodes(graph))
    }
}
