package com.example.retrofithandlestatus.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofithandlestatus.data.model.signin.request.ReqSignInSuccessData
import com.example.retrofithandlestatus.databinding.ActivityMainBinding
import com.example.retrofithandlestatus.presentation.viewmodel.SignInViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val signInViewModel: SignInViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            userLogin()
        }

        getInfo()
    }

    private fun userLogin() {
        signInViewModel.postSignIn(
            ReqSignInSuccessData(
                "earthgardener@gmail.com",
                "12345690"
            )
        )
    }

    private fun getInfo() {
        signInViewModel.signInStatus.observe(this, {
            if (it == 200) {
                Timber.d("로그인 성공")
            } else if (it == 401) {
                Timber.d("이메일 또는 비밀번호 오류")
            }
        })
    }
}