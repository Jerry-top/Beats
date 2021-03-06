package com.dss.beats_music.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dss.beats_music.BaseActivity
import com.dss.beats_music.databinding.ActivityLoginBinding
import com.dss.beats_music.network.LoginService
import com.dss.beats_music.network.OkCallback
import com.dss.beats_music.network.ServiceCreator
import com.dss.beats_music.network.bean.CheckPhoneResult
import kotlinx.android.synthetic.main.activity_login.*

import java.util.regex.Pattern

class LoginActivity : BaseActivity() {

    private lateinit var binding :ActivityLoginBinding

    /**
     * 发送网络请求的类
     */
    private val loginService = ServiceCreator.create<LoginService>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 设置toolbar
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        // editText 获取焦点
        phoneEditText.requestFocus()

    }

    /**
     * “下一步"按钮的点击事件
     */
    fun onClickNext(v: View){
        // 获取手机号
        val phoneNumber = phoneEditText.text.toString()
        // 检查手机号是否合法
        if(!isPhoneNumber(phoneNumber)){
            Toast.makeText(this,"请输入合法手机号",Toast.LENGTH_SHORT).show()
            return
        }
        // 发送网络请求检查手机号是否注册过
        loginService.checkPhoneExist(phoneNumber).enqueue(object : OkCallback<CheckPhoneResult>() {

            override fun onSuccess(result: CheckPhoneResult) {
                super.onSuccess(result)
                if(result.exist == 1){
                    // 手机号已注册过，跳转输入密码界面
                    PasswordActivity.start(this@LoginActivity,phoneNumber)

                }else{
                    // 手机号未注册过，跳转设置密码界面
                    SetPasswordActivity.start(this@LoginActivity,phoneNumber)
                }
            }

        })
    }

    /**
     * 检查该字符串是否是手机号码
     */
    private fun isPhoneNumber(number:String):Boolean{
        val regular = "\\d{11}"
        return Pattern.compile(regular).matcher(number).matches()
    }

}