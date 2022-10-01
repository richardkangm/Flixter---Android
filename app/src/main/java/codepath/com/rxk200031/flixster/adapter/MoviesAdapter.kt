package codepath.com.rxk200031.flixster.adapter

import android.content.Context
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import codepath.com.rxk200031.flixster.model.Movie
import codepath.com.rxk200031.flixster.R
import com.bumptech.glide.Glide


class MoviesAdapter (private val context: Context, private val movies: List<Movie>):
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tvTitle: TextView
        private val tvDescription: TextView
        private val ivPosterUrl: ImageView

        init {
            tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
            tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
            ivPosterUrl = itemView.findViewById<ImageView>(R.id.ivPoster)
        }

        fun bind(movie: Movie){
            tvTitle.text = movie.title
            tvDescription.text = movie.overview
            Glide.with(context).load(movie.imageUrl).into(ivPosterUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.movies_layout, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie: Movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size
}