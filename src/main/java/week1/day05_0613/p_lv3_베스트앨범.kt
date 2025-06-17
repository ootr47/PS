class Solution {
    data class Music(val genre: String, val play: Int, val index: Int)

    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        return genres.indices
            .map { Music(genres[it], plays[it], it) }
            .groupBy { it.genre }
            .toList()
            .sortedByDescending { (_, songs) -> songs.sumOf { it.play } }
            .flatMap { (_, songs) ->
                songs.sortedWith(compareByDescending<Music> { it.play }.thenBy { it.index })
                    .take(2)
                    .map { it.index }
            }
            .toIntArray()
    }
}