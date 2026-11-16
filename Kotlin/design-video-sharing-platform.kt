package designvideosharingplatform

import java.util.PriorityQueue

// Time:  ctor:                O(1)
//        upload:              O(logn+l)
//        remove:              O(logn)
//        like:                O(1)
//        dislike:             O(1)
//        view:                O(l)
//        getLikesAndDislikes: O(1)
//        getViews:            O(1)
// Space: O(n * l), n = len(videos), l = max(len(v) for v in videos)

class VideoSharingPlatform {
    private val avails = PriorityQueue<Int>()
    private val videos = ArrayList<String>()
    private val likes = ArrayList<Int>()
    private val dislikes = ArrayList<Int>()
    private val views = ArrayList<Int>()

    fun upload(video: String): Int {
        val i: Int
        if (avails.isNotEmpty()) {
            i = avails.poll()
        } else {
            i = videos.size
            videos.add("")
            likes.add(0)
            dislikes.add(0)
            views.add(0)
        }
        videos[i] = video
        return i
    }

    fun remove(videoId: Int) {
        if (videoId >= videos.size || views[videoId] == -1) {
            return
        }
        avails.add(videoId)
        videos[videoId] = ""
        likes[videoId] = 0
        dislikes[videoId] = 0
        views[videoId] = 0
    }

    fun watch(videoId: Int, startMinute: Int, endMinute: Int): String {
        if (videoId >= videos.size || videos[videoId].isEmpty()) {
            return "-1"
        }
        ++views[videoId]
        val video = videos[videoId]
        return video.substring(startMinute, minOf(endMinute + 1, video.length))
    }

    fun like(videoId: Int) {
        if (videoId >= videos.size || videos[videoId].isEmpty()) {
            return
        }
        ++likes[videoId]
    }

    fun dislike(videoId: Int) {
        if (videoId >= videos.size || videos[videoId].isEmpty()) {
            return
        }
        ++dislikes[videoId]
    }

    fun getLikesAndDislikes(videoId: Int): IntArray {
        if (videoId >= videos.size || videos[videoId].isEmpty()) {
            return intArrayOf(-1)
        }
        return intArrayOf(likes[videoId], dislikes[videoId])
    }

    fun getViews(videoId: Int): Int {
        if (videoId >= videos.size || videos[videoId].isEmpty()) {
            return -1
        }
        return views[videoId]
    }
}
