package codepath.com.rxk200031.flixster.model

import org.json.JSONArray

data class Movie (
        val title: String,
        val overview: String,
        val imageUrl: String
        ) {
        companion object {
                fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
                        val movies = mutableListOf<Movie>()
                        for (i in 0 until movieJsonArray.length()) {
                                val movieJson = movieJsonArray.getJSONObject(i)
                                movies.add(
                                        Movie(
                                                movieJson.getString("title"),
                                                movieJson.getString("overview"),
                                                "https://image.tmdb.org/t/p/w500/" + movieJson.getString("poster_path")
                                        )
                                )
                        }
                        return movies
                }
        }
}
