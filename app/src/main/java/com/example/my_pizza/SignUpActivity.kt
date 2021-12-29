package com.example.my_pizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var fullName: TextInputLayout
    private lateinit var eMail: TextInputLayout
    private lateinit var mobileNumber: TextInputLayout
    private lateinit var createPassword: TextInputLayout
    private lateinit var confirmPassword: TextInputLayout

    private lateinit var agreeCheckBox: CheckBox
    private lateinit var inscriptionBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        fullName = findViewById(R.id.register_full_name_til)
        eMail = findViewById(R.id.register_email_til)
        mobileNumber = findViewById(R.id.register_mobile_num_til)
        createPassword = findViewById(R.id.register_create_password_til)
        confirmPassword = findViewById(R.id.register_confirm_password_til)

        agreeCheckBox = findViewById(R.id.register_agree_check_box)
        inscriptionBtn = findViewById(R.id.btn_inscription)

        agreeCheckBox.setOnClickListener {
            inscriptionBtn.isEnabled = agreeCheckBox.isChecked
        }

        inscriptionBtn.setOnClickListener(){

        }

        val btn_inscription = findViewById<Button>(R.id.btn_inscription)
        val se_connecter = findViewById<Button>(R.id.se_connecter)
        se_connecter.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
        btn_inscription.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }


    }


    private fun validateName(): Boolean {
        val fullName = fullName.editText!!.text.toString().trim()
        if(fullName.isEmpty()) {
            fullName.error = getString(R.string.field_empty)
            return false
        }
        fullName.error = null
        return true
    }

}