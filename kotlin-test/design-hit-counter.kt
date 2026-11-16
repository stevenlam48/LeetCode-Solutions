package designhitcounter

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignHitCounterTest {
    @Test
    fun leetCodeExample() {
        val counter = HitCounter()
        counter.hit(1)
        counter.hit(2)
        counter.hit(3)
        assertEquals(3, counter.getHits(4))
        counter.hit(300)
        assertEquals(4, counter.getHits(300))
        assertEquals(3, counter.getHits(301))
    }

    @Test
    fun exactFiveMinuteBoundaryExpires() {
        val counter = HitCounter()
        counter.hit(1)
        assertEquals(1, counter.getHits(300))
        assertEquals(0, counter.getHits(301))
    }

    @Test
    fun repeatedHitsAtSameTimestamp() {
        val counter = HitCounter()
        repeat(5) { counter.hit(10) }
        assertEquals(5, counter.getHits(10))
        assertEquals(5, counter.getHits(300))
        assertEquals(0, counter.getHits(311))
    }

    @Test
    fun queryingWithoutHits() {
        val counter = HitCounter()
        assertEquals(0, counter.getHits(100))
        counter.hit(100)
        assertEquals(1, counter.getHits(100))
    }
}
