package alloonedatastructure

// Time:  O(1), per operation
// Space: O(k)

class AllOne {
    private class Bucket(val value: Int) {
        val keys = LinkedHashSet<String>()
        var prev: Bucket? = null
        var next: Bucket? = null
    }

    private var head: Bucket? = null
    private var tail: Bucket? = null
    private val bucketOfKey = HashMap<String, Bucket>()

    fun inc(key: String) {
        var bucket = bucketOfKey[key]
        if (bucket == null) {
            bucket = Bucket(0)
            bucket.keys.add(key)
            insertAtFront(bucket)
            bucketOfKey[key] = bucket
        }
        var next = bucket.next
        if (next == null || next.value > bucket.value + 1) {
            next = Bucket(bucket.value + 1)
            insertAfter(bucket, next)
        }
        next.keys.add(key)
        bucketOfKey[key] = next
        bucket.keys.remove(key)
        if (bucket.keys.isEmpty()) {
            removeBucket(bucket)
        }
    }

    fun dec(key: String) {
        val bucket = bucketOfKey[key] ?: return
        var prev = bucket.prev
        bucketOfKey.remove(key)
        if (bucket.value > 1) {
            if (bucket.prev == null || prev!!.value < bucket.value - 1) {
                prev = Bucket(bucket.value - 1)
                insertBefore(bucket, prev)
            }
            prev!!.keys.add(key)
            bucketOfKey[key] = prev!!
        }
        bucket.keys.remove(key)
        if (bucket.keys.isEmpty()) {
            removeBucket(bucket)
        }
    }

    fun getMaxKey(): String = tail?.keys?.firstOrNull() ?: ""

    fun getMinKey(): String = head?.keys?.firstOrNull() ?: ""

    private fun insertAtFront(bucket: Bucket) {
        bucket.next = head
        head?.prev = bucket
        head = bucket
        if (tail == null) {
            tail = bucket
        }
    }

    private fun insertAfter(node: Bucket, bucket: Bucket) {
        bucket.prev = node
        bucket.next = node.next
        node.next?.prev = bucket
        node.next = bucket
        if (tail === node) {
            tail = bucket
        }
    }

    private fun insertBefore(node: Bucket, bucket: Bucket) {
        bucket.next = node
        bucket.prev = node.prev
        node.prev?.next = bucket
        node.prev = bucket
        if (head === node) {
            head = bucket
        }
    }

    private fun removeBucket(bucket: Bucket) {
        bucket.prev?.next = bucket.next
        bucket.next?.prev = bucket.prev
        if (head === bucket) {
            head = bucket.next
        }
        if (tail === bucket) {
            tail = bucket.prev
        }
        bucket.prev = null
        bucket.next = null
    }
}
