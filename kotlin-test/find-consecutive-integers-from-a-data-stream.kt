package findconsecutiveintegersfromadatastream

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindConsecutiveIntegersFromADataStreamTest {
    @Test
    fun standardExample() {
        val dataStream = DataStream(4, 3)
        assertFalse(dataStream.consec(4))
        assertFalse(dataStream.consec(4))
        assertTrue(dataStream.consec(4))
        assertFalse(dataStream.consec(3))
    }

    @Test
    fun kEqualsOne() {
        val dataStream = DataStream(1, 1)
        assertTrue(dataStream.consec(1))
        assertFalse(dataStream.consec(2))
        assertTrue(dataStream.consec(1))
    }

    @Test
    fun resetAfterMismatch() {
        val dataStream = DataStream(1, 2)
        assertFalse(dataStream.consec(1))
        assertTrue(dataStream.consec(1))
        assertFalse(dataStream.consec(2))
        assertFalse(dataStream.consec(1))
        assertTrue(dataStream.consec(1))
    }

    @Test
    fun longerRun() {
        val dataStream = DataStream(7, 3)
        assertFalse(dataStream.consec(7))
        assertFalse(dataStream.consec(7))
        assertTrue(dataStream.consec(7))
        assertTrue(dataStream.consec(7))
    }
}
