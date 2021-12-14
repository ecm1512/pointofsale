package com.nttdata.saleapp.presentation.home.pos.newsale.addproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.nttdata.saleapp.R
import com.nttdata.saleapp.databinding.AddProductFragmentBinding
import com.nttdata.saleapp.databinding.LayoutBottomSheetBinding
import com.nttdata.saleapp.domain.model.Inventory
import com.nttdata.saleapp.presentation.home.inventory.InventoryAdapter
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddProductFragment : ScopeFragment() {

    private val viewModel: AddProductViewModel by viewModel()
    private lateinit var binding: AddProductFragmentBinding
    private lateinit var inventoryAdapter: InventoryAdapter

    private lateinit var inventorySelected : Inventory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = AddProductFragmentBinding.inflate(inflater,container,false)

        binding.buttonBack.setOnClickListener {
            findNavController().navigate(R.id.newSaleFragment)
        }

        binding.btnAddProduct.setOnClickListener {
            val bottomSheet = BottomSheetDialog(requireActivity())
            val bindingSheetDialog = LayoutBottomSheetBinding.inflate(inflater,container,false)

            bottomSheet.setContentView(bindingSheetDialog.root)
            bottomSheet.show()

            bindingSheetDialog.btnAddProductSaleDetail.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("idInventory",inventorySelected.id)
                bundle.putInt("quantity",bindingSheetDialog.textInputLayout.editText!!.text.toString().toInt())
                findNavController().navigate(R.id.newSaleFragment,bundle)
                bottomSheet.dismiss()
            }
        }

        viewModel.getInventory()

        view()

        listenData(binding)

        return binding.root
    }

    private fun view(){
        inventoryAdapter = InventoryAdapter() { inventory -> goToNewSaleDetail(inventory) }
    }

    private fun goToNewSaleDetail(inventory: Inventory) {
        inventorySelected = Inventory(inventory.name,inventory.stock,inventory.price,inventory.idStore)
    }

    private fun listenData(binding: AddProductFragmentBinding){
        viewModel.data.observe(viewLifecycleOwner, {
            inventoryAdapter.articles = it
        })
        binding.recyclerAddProduct.adapter = inventoryAdapter
    }

    private fun selectArticleQuantities(inventory: Inventory){

    }


}