package trafficlightcontrolledintersection

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TrafficLightControlledIntersectionTest {
    @Test
    fun turnsGreenOnlyWhenRoadChanges() {
        val trafficLight = TrafficLight()
        var greenCount = 0
        val crossed = mutableListOf<Int>()

        fun arrive(carId: Int, roadId: Int) {
            trafficLight.carArrived(carId, roadId, 0, { ++greenCount }, { crossed.add(carId) })
        }

        arrive(1, 1)
        arrive(2, 2)
        arrive(3, 1)
        arrive(4, 2)

        assertEquals(3, greenCount)
        assertEquals(listOf(1, 2, 3, 4), crossed)
    }

    @Test
    fun concurrentCarsCrossOneAtATime() {
        val trafficLight = TrafficLight()
        val inside = AtomicInteger(0)
        val maxInside = AtomicInteger(0)
        val crossedCount = AtomicInteger(0)
        val start = CountDownLatch(1)
        val done = CountDownLatch(8)

        val threads = (0 until 8).map { i ->
            thread {
                start.await()
                trafficLight.carArrived(i, i % 2 + 1, 0, {}, {
                    val current = inside.incrementAndGet()
                    maxInside.accumulateAndGet(current) { a, b -> maxOf(a, b) }
                    Thread.sleep(1)
                    crossedCount.incrementAndGet()
                    inside.decrementAndGet()
                })
                done.countDown()
            }
        }

        start.countDown()
        assertTrue(done.await(5, TimeUnit.SECONDS))
        threads.forEach { it.join() }

        assertEquals(8, crossedCount.get())
        assertEquals(1, maxInside.get())
    }
}
