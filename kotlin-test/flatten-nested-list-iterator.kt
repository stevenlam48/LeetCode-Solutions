package flattennestedlistiterator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FlattenNestedListIteratorTest {
    @Test
    fun example1() {
        val nested = listOf(
            nested(int(1), int(1)),
            int(2),
            nested(int(1), int(1))
        )
        assertEquals(listOf(1, 1, 2, 1, 1), drain(NestedIterator(nested)))
    }

    @Test
    fun example2() {
        val nested = listOf(
            int(1),
            nested(int(4), nested(int(6)))
        )
        assertEquals(listOf(1, 4, 6), drain(NestedIterator(nested)))
    }

    @Test
    fun emptyNestedList() {
        assertEquals(emptyList<Int>(), drain(NestedIterator(listOf(nested()))))
    }

    @Test
    fun singleInteger() {
        assertEquals(listOf(0), drain(NestedIterator(listOf(int(0)))))
    }

    @Test
    fun deeplyNested() {
        val nested = listOf(nested(nested(nested(int(5)))))
        assertEquals(listOf(5), drain(NestedIterator(nested)))
    }

    private fun drain(iterator: NestedIterator): List<Int> {
        val result = mutableListOf<Int>()
        while (iterator.hasNext()) {
            result.add(iterator.next())
        }
        return result
    }

    private fun int(value: Int): NestedInteger {
        return NestedInteger(value)
    }

    private fun nested(vararg items: NestedInteger): NestedInteger {
        val result = NestedInteger()
        for (item in items) {
            result.add(item)
        }
        return result
    }
}
