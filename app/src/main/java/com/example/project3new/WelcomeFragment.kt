package com.example.project3new

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        val buttonMinus = view?.findViewById<Button>(R.id.button_minus)
        val buttonPlus = view?.findViewById<Button>(R.id.button_plus)
        val buttonStart = view?.findViewById<Button>(R.id.button_start)
        val radioButtonEasy = view?.findViewById<RadioButton>(R.id.radio_easy)
        val radioButtonMedium = view?.findViewById<RadioButton>(R.id.radio_medium)
        val radioButtonHard = view?.findViewById<RadioButton>(R.id.radio_hard)
        val radioButtonAdd = view?.findViewById<RadioButton>(R.id.radio_add)
        val radioButtonSubtract = view?.findViewById<RadioButton>(R.id.radio_subtract)
        val radioButtonMultiply = view?.findViewById<RadioButton>(R.id.radio_multiply)
        val radioButtonDivide = view?.findViewById<RadioButton>(R.id.radio_divide)
        val tvNumQuestions = view?.findViewById<TextView>(R.id.tv_num_questions)

        var difficulty = ""
        var operation = ""
        var numQuestions = 0

        buttonStart?.setOnClickListener {
            Log.i("WelcomeFragment.kt", "Start button pressed")
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToQuestionFragment(difficulty, operation, numQuestions)
            view.findNavController().navigate(action)
        }

        buttonMinus?.setOnClickListener {
            Log.i("WelcomeFragment.kt", "Minus questions button pressed")
            numQuestions -= 1
            tvNumQuestions?.text = numQuestions.toString()
        }

        buttonPlus?.setOnClickListener {
            Log.i("WelcomeFragment.kt", "Plus questions button pressed")
            numQuestions += 1
            tvNumQuestions?.text = numQuestions.toString()
        }

        radioButtonEasy?.setOnClickListener {
            Log.i("WelcomeFragment.kt", "Easy difficulty radio button selected")
            difficulty = "easy"
        }
        radioButtonMedium?.setOnClickListener {
            Log.i("WelcomeFragment.kt", "Medium difficulty radio button selected")
            difficulty = "medium"
        }
        radioButtonHard?.setOnClickListener {
            Log.i("WelcomeFragment.kt", "Hard difficulty radio button selected")
            difficulty = "hard"
        }
        radioButtonAdd?.setOnClickListener {
            Log.i("WelcomeFragment.kt", "Addition operation radio button selected")
            operation = "add"
        }
        radioButtonSubtract?.setOnClickListener {
            Log.i("WelcomeFragment.kt", "Subtraction operation radio button selected")
            operation = "subtract"
        }
        radioButtonMultiply?.setOnClickListener {
            Log.i("WelcomeFragment.kt", "Multiplication operation radio button selected")
            operation = "multiply"
        }
        radioButtonDivide?.setOnClickListener {
            Log.i("WelcomeFragment.kt", "Division operation radio button selected")
            operation = "divide"
        }

        return view
    }

}