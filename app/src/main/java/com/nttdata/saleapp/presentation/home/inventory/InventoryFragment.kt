package com.nttdata.saleapp.presentation.home.inventory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nttdata.saleapp.R
import com.nttdata.saleapp.databinding.InventoryFragmentBinding
import com.nttdata.saleapp.domain.model.Inventory
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class InventoryFragment : ScopeFragment() {

    private lateinit var binding: InventoryFragmentBinding
    private val viewModel: InventoryViewModel by viewModel()
    private lateinit var inventoryAdapter: InventoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InventoryFragmentBinding.inflate(inflater,container,false)

        binding.fabNewArticle.setOnClickListener {
            findNavController().navigate(R.id.action_inventoryFragment_to_newArticleFragment)
        }

        viewModel.getInventory()

        view()

        listenData(binding)

        return binding.root
    }

    private fun view(){
        inventoryAdapter = InventoryAdapter { inventory -> goToDetailIventory(inventory) }
    }

    private fun goToDetailIventory(inventory: Inventory) {

    }

    private fun listenData(binding: InventoryFragmentBinding){
        viewModel.data.observe(viewLifecycleOwner, {
            inventoryAdapter.articles = it
        })
        binding.recyclerInventory.adapter = inventoryAdapter
    }

}