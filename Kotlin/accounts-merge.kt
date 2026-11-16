package accountsmerge

// Time:  O(nlogn), n is the number of total emails, and the max length of email is 320, p.s. {64}@{255}
// Space: O(n)

class Solution {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val unionFind = UnionFind()
        val emailToName = HashMap<String, String>()
        val emailToId = HashMap<String, Int>()
        for (account in accounts) {
            val name = account[0]
            for (i in 1 until account.size) {
                if (!emailToId.containsKey(account[i])) {
                    emailToName[account[i]] = name
                    emailToId[account[i]] = unionFind.getId()
                }
                unionFind.unionSet(emailToId[account[1]]!!, emailToId[account[i]]!!)
            }
        }

        val lookup = HashMap<Int, java.util.TreeSet<String>>()
        for ((email, _) in emailToName) {
            val root = unionFind.findSet(emailToId[email]!!)
            lookup.getOrPut(root) { java.util.TreeSet() }.add(email)
        }
        val result = ArrayList<List<String>>()
        for (emails in lookup.values) {
            val tmp = ArrayList<String>()
            tmp.add(emailToName[emails.first()]!!)
            tmp.addAll(emails)
            result.add(tmp)
        }
        return result
    }

    private class UnionFind {
        private val set = ArrayList<Int>()

        fun getId(): Int {
            set.add(set.size)
            return set.size - 1
        }

        fun findSet(x: Int): Int {
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x: Int, y: Int) {
            val xRoot = findSet(x)
            val yRoot = findSet(y)
            if (xRoot != yRoot) {
                set[minOf(xRoot, yRoot)] = maxOf(xRoot, yRoot)
            }
        }
    }
}
