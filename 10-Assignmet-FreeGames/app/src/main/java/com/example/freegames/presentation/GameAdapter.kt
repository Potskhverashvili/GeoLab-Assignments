package com.example.freegames.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.freegames.data.GameModel
import com.example.freegames.databinding.ItemGameBinding


class GameAdapter : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    // -------------- Properties -----------
    private var currentGameList = emptyList<GameModel>()
    var onClickLink: (GameModel) -> Unit = {}

    //-------------------- List Update -------------
    fun updateGameList(newGameList: List<GameModel>) {
        val callBack = GameCallBack(this.currentGameList, newGameList)
        val diffResult = DiffUtil.calculateDiff(callBack)

        this.currentGameList = newGameList
        diffResult.dispatchUpdatesTo(this)
    }


    // -------------------- View Holder --------------
    inner class GameViewHolder(private val binding: ItemGameBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(currentGame: GameModel) = with(binding) {
            titleTextView.text = currentGame.title
            gameLinkTextView.text = currentGame.gameUrl

            // Set an OnClickListener to handle clicks on the link
            gameLinkTextView.setOnClickListener {
                // Call the onClickLink lambda, passing the current game model
                onClickLink(currentGame)
            }
            // Load the game image using Glide
            Glide.with(gameItemImageView)
                .load(currentGame.gameImage)
                .into(gameItemImageView)

        }
    }


    //------------------------ Override Methods --------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            ItemGameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(currentGameList[position])
    }

    override fun getItemCount() = currentGameList.size
}


// ------------------------- DiffUtil CalBack --------------------
class GameCallBack(
    private val oldList: List<GameModel>,
    private val newList: List<GameModel>,
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldGame = oldList[oldItemPosition]
        val newGame = newList[newItemPosition]
        return oldGame.id == newGame.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldGame = oldList[oldItemPosition]
        val newGame = newList[newItemPosition]
        return oldGame == newGame
    }
}