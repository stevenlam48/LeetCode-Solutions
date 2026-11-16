package timebasedkeyvaluestore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TimeBasedKeyValueStoreTest {
    @Test
    fun standardOperationSequence() {
        val timeMap = TimeMap()
        timeMap.set("foo", "bar", 1)
        assertEquals("bar", timeMap.get("foo", 1))
        assertEquals("bar", timeMap.get("foo", 3))
        timeMap.set("foo", "bar2", 4)
        assertEquals("bar2", timeMap.get("foo", 4))
        assertEquals("bar2", timeMap.get("foo", 5))
    }

    @Test
    fun missingKeyAndTimestampBeforeFirstValue() {
        val timeMap = TimeMap()
        assertEquals("", timeMap.get("missing", 10))
        timeMap.set("key", "value", 5)
        assertEquals("", timeMap.get("key", 4))
    }

    @Test
    fun keysAreIndependent() {
        val timeMap = TimeMap()
        timeMap.set("a", "first", 1)
        timeMap.set("b", "second", 2)
        assertEquals("first", timeMap.get("a", 100))
        assertEquals("second", timeMap.get("b", 2))
    }
}
