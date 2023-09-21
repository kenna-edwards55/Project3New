package com.example.project3new

import android.os.Bundle
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

//        val radioGroupDifficulty = view?.findViewById<RadioGroup>(R.id.radio_group_difficulty)
//        val radioEasy = view?.findViewById<Button>(R.id.radio_easy)
//        val radioMedium = view?.findViewById<Button>(R.id.radio_medium)
//        val radioHard = view?.findViewById<Button>(R.id.radio_hard)
//        val radioAdd = view?.findViewById<Button>(R.id.radio_add)
//        val radioSubtract = view?.findViewById<Button>(R.id.radio_subtract)
//        val radioMultiply = view?.findViewById<Button>(R.id.radio_multiply)
//        val radioDivide = view?.findViewById<Button>(R.id.radio_divide)
        val buttonMinus = view?.findViewById<Button>(R.id.button_minus)
        val buttonPlus = view?.findViewById<Button>(R.id.button_plus)
        val buttonStart = view?.findViewById<Button>(R.id.button_start)
        val tvNumQuestions = view?.findViewById<TextView>(R.id.tv_num_questions)

        buttonStart?.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToQuestionFragment(difficulty, operation, numQuestions)
            view.findNavController().navigate(action)
        }

        buttonMinus?.setOnClickListener {
            numQuestions -= 1
        }

        buttonPlus?.setOnClickListener {
            numQuestions -= 1
        }

        return view
    }

     fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radio_easy ->
                    if (checked) {
                        difficulty = "easy"
                    }
                R.id.radio_medium ->
                    if (checked) {
                        difficulty = "medium"
                    }
                R.id.radio_hard ->
                    if (checked) {
                        difficulty = "hard"
                    }
                R.id.radio_add ->
                    if (checked) {
                        operation = "add"
                    }
                R.id.radio_subtract ->
                    if (checked) {
                        operation = "subtract"
                    }
                R.id.radio_multiply ->
                    if (checked) {
                        operation="multiply"
                    }
                R.id.radio_divide ->
                    if (checked) {
                        operation = "divide"
                    }
            }
        }
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