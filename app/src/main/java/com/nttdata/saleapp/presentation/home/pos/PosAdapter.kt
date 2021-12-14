package com.nttdata.saleapp.presentation.home.pos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nttdata.saleapp.databinding.ItemSaleBinding
import com.nttdata.saleapp.domain.model.Sale
import kotlin.properties.Delegates

class PosAdapter: RecyclerView.Adapter<PosAdapter.PosViewHolder>() {

    var sales: List<Sale> by Delegates.observable(emptyList()){ _,_,_ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosViewHolder {
        val binding = ItemSaleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PosViewHolder, position: Int) {
        val sale = sales[position]
        holder.setDataCard(sale)
    }

    override fun getItemCount(): Int {
        return sales.size
    }


    class PosViewHolder(private val binding: ItemSaleBinding): RecyclerView.ViewHolder(binding.root){
        fun setDataCard(sale: Sale){
            binding.tvSaleClientName.text = sale.client
            binding.tvSaleDate.text = sale.date.toString()
            binding.tvSaleTotal.text = sale.total.toString()
        }
    }
}