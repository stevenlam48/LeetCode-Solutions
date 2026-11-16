package designeventmanager

// Time:  ctor:           O(n)
//        updatePriority: O(logn), amortized
//        pollHightest:   O(logn), amortized
// Space: O(n)
import java.util.PriorityQueue

class EventManager(events: Array<IntArray>) {
    private val lookup = HashMap<Int, Int>()
    private val maxHeap = PriorityQueue<Pair<Int, Int>>(
        compareByDescending<Pair<Int, Int>> { it.first }.thenByDescending { it.second }
    )

    init {
        for (event in events) {
            lookup[event[0]] = event[1]
            maxHeap.add(event[1] to -event[0])
        }
    }

    fun updatePriority(eventId: Int, newPriority: Int) {
        lookup[eventId] = newPriority
        maxHeap.add(newPriority to -eventId)
        if (maxHeap.size > 2 * lookup.size) {
            rebuild()
        }
    }

    fun pollHighest(): Int {
        while (maxHeap.isNotEmpty()) {
            val (priority, id) = maxHeap.poll()
            if (lookup[-id] == priority) {
                lookup.remove(-id)
                return -id
            }
        }
        return -1
    }

    private fun rebuild() {
        val active = HashMap<Int, Int>()
        val rebuilt = PriorityQueue<Pair<Int, Int>>(maxHeap.comparator())
        while (maxHeap.isNotEmpty()) {
            val (priority, id) = maxHeap.poll()
            if (lookup[-id] == priority) {
                lookup.remove(-id)
                active[-id] = priority
                rebuilt.add(priority to id)
            }
        }
        lookup.clear()
        lookup.putAll(active)
        maxHeap.clear()
        maxHeap.addAll(rebuilt)
    }
}
