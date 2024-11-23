package com.example.harrypotter.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harrypotter.data.model.BookModel
import com.example.harrypotter.databinding.ItemBookBinding

class BookAdapter : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    // Property
    private var currentBookList = emptyList<BookModel.Detail>()

    //-------------------- List Update -------------
    fun updateGameList(newBookList: List<BookModel.Detail>) {
        val callBack = GameCallBack(this.currentBookList, newBookList)
        val diffResult = DiffUtil.calculateDiff(callBack)
        this.currentBookList = newBookList
        diffResult.dispatchUpdatesTo(this)
    }


    // ---------------------- View Holder ---------------------
    inner class BookViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(currentBook: BookModel.Detail) = with(binding) {
            bookNameTextView.text = currentBook.attributes.bookName

            Glide.with(root)
                .load(currentBook.attributes.coverImage)
                .into(bookCoverImageView)
        }
    }

    // ------------------------------------ Override Methods -----------------------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            ItemBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = currentBookList.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(currentBookList[position])
    }


    // ------------------------- DiffUtil CalBack --------------------
    class GameCallBack(
        private val oldList: List<BookModel.Detail>,
        private val newList: List<BookModel.Detail>,
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
}