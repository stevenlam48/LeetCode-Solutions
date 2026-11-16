package thediningphilosophers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertTimeoutPreemptively
import java.time.Duration
import java.util.Collections
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class TheDiningPhilosophersTest {
    @Test
    fun fivePhilosophersEatWithoutInterleavingTheirActions() {
        val actions = runDiningRound(1)
        assertEquals(25, actions.size)
        for (philosopher in 0 until 5) {
            assertEquals(expectedActions(philosopher), actions.filter { it.startsWith("$philosopher:") })
        }
    }

    @Test
    fun repeatedContentionCompletes() {
        val actions = runDiningRound(2)
        assertEquals(50, actions.size)
        for (philosopher in 0 until 5) {
            val expected = expectedActions(philosopher) + expectedActions(philosopher)
            assertEquals(expected, actions.filter { it.startsWith("$philosopher:") })
        }
    }

    @Test
    fun allFiveCallbackOperationsAreUsed() {
        val actions = runDiningRound(1)
        for (operation in listOf("pickLeft", "pickRight", "eat", "putLeft", "putRight")) {
            assertEquals(5, actions.count { it.endsWith(":$operation") })
        }
    }
}

private fun runDiningRound(rounds: Int): List<String> = assertTimeoutPreemptively(Duration.ofSeconds(5)) {
    val diningPhilosophers = DiningPhilosophers()
    val actions = Collections.synchronizedList(mutableListOf<String>())
    val start = CountDownLatch(1)
    val done = CountDownLatch(5)
    val threads = List(5) { philosopher ->
        thread(start = true) {
            start.await()
            repeat(rounds) {
                diningPhilosophers.wantsToEat(
                    philosopher,
                    { actions.add("$philosopher:pickLeft") },
                    { actions.add("$philosopher:pickRight") },
                    { actions.add("$philosopher:eat") },
                    { actions.add("$philosopher:putLeft") },
                    { actions.add("$philosopher:putRight") }
                )
            }
            done.countDown()
        }
    }
    start.countDown()
    assertTrue(done.await(4, TimeUnit.SECONDS))
    threads.forEach { it.join() }
    actions.toList()
}

private fun expectedActions(philosopher: Int): List<String> = listOf(
    "$philosopher:pickLeft",
    "$philosopher:pickRight",
    "$philosopher:eat",
    "$philosopher:putLeft",
    "$philosopher:putRight"
)
