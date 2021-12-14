package com.nttdata.saleapp.presentation.home.account

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nttdata.saleapp.databinding.AccountFragmentBinding
import com.nttdata.saleapp.presentation.login.LoginActivity

class AccountFragment : Fragment() {

    private lateinit var binding: AccountFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AccountFragmentBinding.inflate(layoutInflater,container,false)

        binding.btnLogout.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }


}