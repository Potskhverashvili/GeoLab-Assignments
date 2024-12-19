package com.example.cocktailapp.presentation.screens.cocktails_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cocktailapp.databinding.ItemCocktailBinding
import com.example.cocktailapp.domain.model.CocktailsList

class CocktailAdapter : RecyclerView.Adapter<CocktailAdapter.CocktailViewHolder>() {
    // --- Properties ----
    private var currentCocktailList = emptyList<CocktailsList.Drink>()

    // ------------------------ Update Cocktail List --------------------
    fun cocktailListUpdate(newCocktailList: List<CocktailsList.Drink>) {
        val callBack = CocktailCallBack(this.currentCocktailList, newCocktailList)
        val diffResult = DiffUtil.calculateDiff(callBack)

        this.currentCocktailList = newCocktailList
        diffResult.dispatchUpdatesTo(this)
    }

    // ------------------------ Override Methods -----------------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        return CocktailViewHolder(
            ItemCocktailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = currentCocktailList.size
    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        holder.bind(currentCocktailList[position])
    }

    // ------------------------ View Holder ------------------------------
    inner class CocktailViewHolder(private val binding: ItemCocktailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentCocktail: CocktailsList.Drink) = with(binding) {
            Glide.with(cocktailImageView)
                .load(currentCocktail.imageUrl)
                .into(cocktailImageView)
            cocktailNameTextView.text = currentCocktail.name
            instructionTextView.text = currentCocktail.instructions
        }
    }
}

// ------------------------- DiffUtil CalBack --------------------
class CocktailCallBack(
    private val oldList: List<CocktailsList.Drink>,
    private val newList: List<CocktailsList.Drink>,
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}