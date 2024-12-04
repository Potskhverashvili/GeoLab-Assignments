package com.example.jokesapp.presentation.sceens.jokes_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jokesapp.databinding.ItemJokeBinding
import com.example.jokesapp.domain.model.Joke

class JokeAdapter : ListAdapter<Joke, JokeAdapter.JokeViewHolder>(JokeItemCallBack()) {

    var onDeleteClick: (Joke) -> Unit = {} // Lambda function to delete joke

    // ------------------------- View Holder ------------------------
    inner class JokeViewHolder(private val binding: ItemJokeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(joke: Joke) = with(binding) {
            jokeTypeTextView.text = joke.type
            jokeSetupTextView.text = joke.setup
            jokePunchlineTextView.text = joke.punchline
            deleteImageView.setOnClickListener {
                onDeleteClick(joke)
            }
        }
    }

    // ----------------------- DiffUtil CallBack --------------------
    class JokeItemCallBack : DiffUtil.ItemCallback<Joke>() {
        override fun areItemsTheSame(oldItem: Joke, newItem: Joke) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Joke, newItem: Joke) = oldItem == newItem
    }

    //------------------------ Override Methods --------------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        return JokeViewHolder(
            ItemJokeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}