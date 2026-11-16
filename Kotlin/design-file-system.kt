package designfilesystem

// Time:  create: O(n)
//        get:    O(n)
// Space: O(n)
class FileSystem {
    private val lookup = hashMapOf("" to -1)

    fun create(path: String, value: Int): Boolean {
        if (!lookup.containsKey(path.substring(0, path.lastIndexOf('/')))) {
            return false
        }
        lookup[path] = value
        return true
    }

    fun get(path: String): Int = lookup[path] ?: -1
}
