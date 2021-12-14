package com.nttdata.saleapp.presentation.home.inventory

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nttdata.saleapp.databinding.ItemInventoryBinding
import com.nttdata.saleapp.domain.model.Inventory
import com.nttdata.saleapp.domain.model.Sale
import kotlin.properties.Delegates

class InventoryAdapter(private var listenerInventoryItem: (Inventory) -> Unit): RecyclerView.Adapter<InventoryAdapter.InventoryViewHolder>()  {

    var articles: List<Inventory> by Delegates.observable(emptyList()) { _,_,_ ->
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InventoryViewHolder {
        val binding = ItemInventoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InventoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InventoryViewHolder, position: Int) {
        val inventory = articles[position]

        holder.setDataCard(inventory)
    }

    override fun getItemCount(): Int {
        return articles.size
    }


    inner class InventoryViewHolder(val binding: ItemInventoryBinding): RecyclerView.ViewHolder(binding.root){
        fun setDataCard(inventory: Inventory){
            binding.tvId.text = inventory.id.toString()
            binding.tvInventoryName.text = inventory.name
            binding.tvInventoryPrice.text = inventory.price.toString()
            binding.tvInventoryStock.text = inventory.stock.toString()

            binding.inventoryCardview.setOnClickListener {
                listenerInventoryItem(inventory)
                binding.inventoryCardview.isChecked = !binding.inventoryCardview.isChecked
                Log.e("click1","click1")

            }
        }
    }


}