package com.example.harrypotter.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harrypotter.data.model.MoviesDetails
import com.example.harrypotter.databinding.ItemMovieBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    // Properties
    private var currentMovieList = emptyList<MoviesDetails>()
    var onClickDetail: (MoviesDetails) -> Unit = {}

    //-------------------- List Update -------------
    fun updateMovieList(newList: List<MoviesDetails>) {
        val callBack = MovieCallBack(this.currentMovieList, newList)
        val diffResult = DiffUtil.calculateDiff(callBack)
        this.currentMovieList = newList
        diffResult.dispatchUpdatesTo(this)
    }

    // View Holder
    inner class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentMovie: MoviesDetails) = with(binding) {
            movieNameTextView.text = currentMovie.attributes.movieName
            movieDetailButton.setOnClickListener {
                onClickDetail(currentMovie)
            }
            Glide.with(root)
                .load(currentMovie.attributes.moviePoster)
                .into(movieCoverImageView)
        }
    }

    // Override Methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = currentMovieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(currentMovieList[position])
    }


    // ------------------------- DiffUtil CalBack --------------------
    class MovieCallBack(
        private val oldList: List<MoviesDetails>,
        private val newList: List<MoviesDetails>,
    ) : DiffUtil.Callback() {

        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldMovie = oldList[oldItemPosition]
            val newMovie = newList[newItemPosition]
            return oldMovie.id == newMovie.id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldMovie = oldList[oldItemPosition]
            val newMovie = newList[newItemPosition]
            return oldMovie == newMovie
        }
    }
}