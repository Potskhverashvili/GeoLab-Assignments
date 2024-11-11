package com.example.movieapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemMovieBinding
import com.google.android.material.snackbar.Snackbar


class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val movie = movies[position]
        holder.binding.movieTitleTextView.text = movie.title
        holder.binding.imdbValueTextView.text = movie.imdbValue.toString()
        holder.binding.movieImageView.setImageResource(movie.imageResource)

        holder.binding.infoButton.setOnClickListener {
            Snackbar.make(holder.itemView, "${movie.title} - ${movie.imdbValue}", Snackbar.LENGTH_SHORT)
                .show()
        }
    }

    override fun getItemCount() = movies.size

    // ViewHolder class
    class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)
}