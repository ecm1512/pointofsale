package com.nttdata.saleapp.presentation.home.pos.newsale

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nttdata.saleapp.R
import com.nttdata.saleapp.databinding.NewSaleFragmentBinding
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class NewSaleFragment : ScopeFragment() {

    private lateinit var binding: NewSaleFragmentBinding
    private val viewModel: NewSaleViewModel by viewModel()
    private val dateFormat = SimpleDateFormat("dd/M/yyyy")
    private val currentDate = dateFormat.format(Date())

    companion object {
        const val ID_INVENTORY = "idInventory"
        const val QUANTITY = "quantity"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = NewSaleFragmentBinding.inflate(inflater,container,false)

        binding.btnAddProduct.setOnClickListener {
            findNavController().navigate(R.id.action_newSaleFragment_to_addProductFragment)
        }

        binding.tvDate.text = currentDate

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       /* val inventoryId = arguments?.getBundle(ID_INVENTORY).toString().toInt()
        val quantiyId = arguments?.getBundle(QUANTITY).toString().toInt()*/

        //viewModel.getInventoryById(inventoryId)
    }
}