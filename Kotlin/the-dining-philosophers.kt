package thediningphilosophers
// Time:  O(n)
// Space: O(1)

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class DiningPhilosophers {
    private val m = Array(5) { ReentrantLock() }

    fun wantsToEat(
        philosopher: Int,
        pickLeftFork: () -> Unit,
        pickRightFork: () -> Unit,
        eat: () -> Unit,
        putLeftFork: () -> Unit,
        putRightFork: () -> Unit
    ) {
        val left = philosopher
        val right = (philosopher + 4) % 5
        var first = left
        var second = right
        if (philosopher % 2 != 0) {
            val tmp = first
            first = second
            second = tmp
        }
        m[first].withLock {
            m[second].withLock {
                pickLeftFork()
                pickRightFork()
                eat()
                putLeftFork()
                putRightFork()
            }
        }
    }
}
