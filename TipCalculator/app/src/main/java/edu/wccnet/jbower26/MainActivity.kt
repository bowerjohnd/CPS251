package edu.wccnet.jbower26

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.wccnet.jbower26.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcButton.setOnClickListener {
            if (binding.userInputText.text.isEmpty()) {
                binding.tipAmount.text = getString(R.string.inputError)
            } else {
                calcTip()
            }
        }
        binding.calcButton.setOnLongClickListener {
            false
        }
    }

    private fun calcTip() {
        try {
            val tipTen = binding.userInputText.text.toString().toDouble() * 0.10
            val formTen = NumberFormat.getCurrencyInstance().format(tipTen)
            val tipFif = binding.userInputText.text.toString().toDouble() * 0.15
            val formFif = NumberFormat.getCurrencyInstance().format(tipFif)
            val tipTwe = binding.userInputText.text.toString().toDouble() * 0.2
            val formTwe = NumberFormat.getCurrencyInstance().format(tipTwe)

            binding.tipAmount.text = getString(R.string.inputSuccess, formTen, formFif, formTwe)

        } catch (e: Exception) {
            binding.tipAmount.text = getString(R.string.calcInputError)
        }
    }
}