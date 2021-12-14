package com.nttdata.saleapp.presentation.home.pos.newsale

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nttdata.saleapp.databinding.ItemSaleDetailBinding
import com.nttdata.saleapp.domain.model.Sale

class NewSaleAdapter: RecyclerView.Adapter<NewSaleAdapter.NewSaleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewSaleViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NewSaleViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class NewSaleViewHolder(private val binding: ItemSaleDetailBinding): RecyclerView.ViewHolder(binding.root){
        fun setDataCard(sale: Sale){
            /*binding.tvSaleClientName.text = sale.client
            binding.tvSaleDate.text = sale.date.toString()
            binding.tvSaleTotal.text = sale.total.toString()*/
        }
    }
}