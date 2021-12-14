package com.nttdata.saleapp.presentation.home.pos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nttdata.saleapp.R
import com.nttdata.saleapp.databinding.PosFragmentBinding
import com.nttdata.saleapp.domain.model.Sale
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class PosFragment : ScopeFragment() {

    private val viewModel: PosViewModel by viewModel()
    private lateinit var binding: PosFragmentBinding
    private lateinit var posAdapter: PosAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = PosFragmentBinding.inflate(inflater,container,false)

        binding.fabNewSale.setOnClickListener{
            findNavController().navigate(R.id.action_posFragment_to_newSaleFragment)
        }

        viewModel.getSales()

        view()

        listenData(binding)

        return binding.root

    }

    private fun view(){
        posAdapter = PosAdapter()
    }

    private fun listenData(binding: PosFragmentBinding){
        viewModel.data.observe(viewLifecycleOwner, {
            posAdapter.sales = it
        })
        binding.recyclerSale.adapter = posAdapter
    }

    /*private fun gotoDetailSale(sale: Sale){
        val action
    }*/

}