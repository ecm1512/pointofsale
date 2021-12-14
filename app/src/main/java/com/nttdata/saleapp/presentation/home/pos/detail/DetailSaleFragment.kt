package com.nttdata.saleapp.presentation.home.pos.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nttdata.saleapp.R

class DetailSaleFragment : Fragment() {

    companion object {
        fun newInstance() = DetailSaleFragment()
    }

    private lateinit var viewModel: DetailSaleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_sale_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailSaleViewModel::class.java)
        // TODO: Use the ViewModel
    }

}