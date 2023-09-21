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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private var difficulty = ""
private var operation = ""
private var numQuestions = 0

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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

        buttonStart?.setOnClickListener {
            Log.d("Welcome Frag", "Start pressed")
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToQuestionFragment(difficulty, operation, numQuestions)
            view.findNavController().navigate(action)
        }

        buttonMinus?.setOnClickListener {
            numQuestions -= 1
            tvNumQuestions?.text = numQuestions.toString()
        }

        buttonPlus?.setOnClickListener {
            numQuestions += 1
            tvNumQuestions?.text = numQuestions.toString()
        }

        radioButtonEasy?.setOnClickListener {
            difficulty = "easy"
        }
        radioButtonMedium?.setOnClickListener {
            difficulty = "medium"
        }
        radioButtonHard?.setOnClickListener {
            difficulty = "hard"
        }
        radioButtonAdd?.setOnClickListener {
            operation = "add"
        }
        radioButtonSubtract?.setOnClickListener {
            operation = "subtract"
        }
        radioButtonMultiply?.setOnClickListener {
            operation = "multiply"
        }
        radioButtonDivide?.setOnClickListener {
            operation = "divide"
        }

        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WelcomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WelcomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}