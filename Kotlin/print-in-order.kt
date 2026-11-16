package printinorder

import java.util.concurrent.CompletableFuture

// Time:  O(n)
// Space: O(1)

class Foo {
    private val p1 = CompletableFuture<Void>()
    private val p2 = CompletableFuture<Void>()

    fun first(printFirst: () -> Unit) {
        printFirst()
        p1.complete(null)
    }

    fun second(printSecond: () -> Unit) {
        p1.join()
        printSecond()
        p2.complete(null)
    }

    fun third(printThird: () -> Unit) {
        p2.join()
        printThird()
    }
}
