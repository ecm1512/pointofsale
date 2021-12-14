package com.nttdata.saleapp.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.nttdata.saleapp.R
import com.nttdata.saleapp.data.repository.UserRepository
import com.nttdata.saleapp.data.service.SaleServiceDataSource
import com.nttdata.saleapp.databinding.ActivityLoginBinding
import com.nttdata.saleapp.domain.usecases.Autenticate
import com.nttdata.saleapp.presentation.home.HomeActivity
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : ScopeActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel.isAutenticated.observe(this, Observer(::onAutenticate))
        viewModel.isLoading.observe(this,Observer(::onLoadingChange))

        binding.btnAutenticate.setOnClickListener {
            autenticate()
        }
    }

    private fun onLoadingChange(isLoading: Boolean?) {
        binding.progressLoading.visibility = if (isLoading == true) View.VISIBLE else View.GONE
    }

    private fun onAutenticate(response: Boolean) {
        if(response){
            Snackbar.make(binding.linearLayout,"Te logueaste correctamente", Snackbar.LENGTH_LONG).show()
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }else{
            Snackbar.make(binding.linearLayout,"Usuario o contraseña incorrectas", Snackbar.LENGTH_LONG).show()
            Log.e("Login","aqui")
        }
    }

    private fun autenticate() {
        val icon = AppCompatResources.getDrawable(this,R.drawable.ic_error)
        icon?.setBounds(0,0,icon.intrinsicWidth,icon.intrinsicHeight)

        val username = binding.inputUsername.editText!!
        val password = binding.inputPassword.editText!!

        when{
            TextUtils.isEmpty(username.text.toString().trim()) ->{
                username.setError("Ingresa el usuario",icon)
            }
            TextUtils.isEmpty(password.text.toString().trim()) ->{
                password.setError("Ingresa la contraseña",icon)
            }

            username.text.isNotEmpty() && password.text.isNotEmpty() -> {
                viewModel.autenticate(username.text.toString().trim(), password.text.toString().trim())

            }
        }
    }
}