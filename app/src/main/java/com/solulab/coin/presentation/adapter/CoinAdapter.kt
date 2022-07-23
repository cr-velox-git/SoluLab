package com.solulab.coin.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.solulab.coin.R
import com.solulab.coin.domain.model.DomainCoinResponse

class CoinAdapter : ListAdapter<DomainCoinResponse, CoinAdapter.ItemViewHolder>(CoinCallback) {
    object CoinCallback : DiffUtil.ItemCallback<DomainCoinResponse>() {
        override fun areItemsTheSame(
            oldItem: DomainCoinResponse,
            newItem: DomainCoinResponse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: DomainCoinResponse,
            newItem: DomainCoinResponse
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setData(getItem(position))
    }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val image: ImageView? = itemView.findViewById(R.id.image)
        private val name: TextView? = itemView.findViewById(R.id.coin_name)

        fun setData(dataList: DomainCoinResponse) {

            //image!!.setImageResource(dataList.image)
            name!!.text = dataList.name
            Glide.with(itemView.context).load(dataList.image).centerCrop()
                .placeholder(R.drawable.ic_baseline_broken_image_24).into(image!!);
        }

    }


}