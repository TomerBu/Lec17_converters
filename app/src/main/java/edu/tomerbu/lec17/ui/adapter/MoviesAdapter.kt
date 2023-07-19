package edu.tomerbu.lec17.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import edu.tomerbu.lec17.data.entity.Movie
import edu.tomerbu.lec17.databinding.MovieItemBinding

class MoviesAdapter(private val movies: List<Movie>, val clicked: (Movie) -> Unit) :
    Adapter<MoviesAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val movie = movies[position]

        with(holder.binding) {
            textTitle.text = movie.title

            root.setOnClickListener {
                clicked(movie)
            }
        }
    }

    class VH(val binding: MovieItemBinding) : ViewHolder(binding.root)
}