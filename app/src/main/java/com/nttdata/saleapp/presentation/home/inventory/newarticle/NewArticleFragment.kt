package com.nttdata.saleapp.presentation.home.inventory.newarticle

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.nttdata.saleapp.R
import com.nttdata.saleapp.databinding.NewArticleFragmentBinding
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewArticleFragment : ScopeFragment() {

    private lateinit var binding: NewArticleFragmentBinding

    private val viewModel: NewArticleViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewArticleFragmentBinding.inflate(inflater,container,false)

        viewModel.isSaved.observe(requireActivity(), Observer(::onSaved))

        binding.btnSaveProduct.setOnClickListener {
            createInventory()
        }

        return binding.root
    }

    private fun createInventory() {
        val icon = AppCompatResources.getDrawable(requireContext(),R.drawable.ic_error)
        icon?.setBounds(0,0,icon.intrinsicWidth,icon.intrinsicHeight)

        val name = binding.inputName.editText!!
        val stock = binding.inputStock.editText!!
        val price = binding.inputPrice.editText!!

        when{
            TextUtils.isEmpty(name.text.toString().trim()) ->{
                name.setError("Ingresa el nombre",icon)
            }
            TextUtils.isEmpty(stock.text.toString().trim()) ->{
                stock.setError("Ingresa el stock",icon)
            }
            TextUtils.isEmpty(price.text.toString().trim()) ->{
                price.setError("Ingresa el precio",icon)
            }

            name.text.isNotEmpty() && stock.text.isNotEmpty() && price.text.isNotEmpty() -> {
                viewModel.insertInventory(name.text.toString().trim(), stock.text.toString().trim().toInt(),price.text.toString().trim().toDouble() )

            }
        }
    }

    private fun onSaved(response: Long) {
        if(response >=0){
            findNavController().navigate(R.id.inventoryFragment)
            Snackbar.make(requireActivity().findViewById(R.id.home_constraintlayout),"Articulo creado", Snackbar.LENGTH_LONG).show()
        }else{
            findNavController().navigate(R.id.inventoryFragment)
            Snackbar.make(requireActivity().findViewById(R.id.home_constraintlayout),"No se pudo crear el articulo", Snackbar.LENGTH_LONG).show()
        }
    }

}