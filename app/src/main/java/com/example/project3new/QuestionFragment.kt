package com.example.project3new

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val doneButton = view?.findViewById<Button>(R.id.done_button)
        val num1TV = view?.findViewById<TextView>(R.id.tv_num1)
        val num2TV = view?.findViewById<TextView>(R.id.tv_num2)
        val operationTV = view?.findViewById<TextView>(R.id.tv_operation)
        val correctAnswersTV = view?.findViewById<TextView>(R.id.tv_correct)
        val editTextAnswer = view?.findViewById<EditText>(R.id.edit_text_answer)
        val difficulty = QuestionFragmentArgs.fromBundle(requireArguments()).difficulty
        val operation = QuestionFragmentArgs.fromBundle(requireArguments()).operation
        val numQuestions = QuestionFragmentArgs.fromBundle(requireArguments()).numQuestions
        var correctAnswers = 0
        var questionsLeft = numQuestions

        if (editTextAnswer?.text?.equals("") == true) {
            operationTV?.text = operation
            correctAnswersTV?.text = correctAnswers.toString()
        }

        doneButton?.setOnClickListener {
            Log.i("QuestionFrag", "Done button Pressed")
            var num1 = 0
            var num2 = 0

            questionsLeft -= 1
            if (editTextAnswer?.text?.equals(solve(operation,num1, num2)) == true) {
                correctAnswers += 1
                correctAnswersTV?.text = correctAnswers.toString()
            }

            if (questionsLeft >= 1) {
                if (difficulty == "easy") {
                    num1 = (1 until 10).random()
                    num2 = (1 until 10).random()
                } else if (difficulty == "medium") {
                    num1 = (1 until 25).random()
                    num2 = (1 until 25).random()
                } else { //hard
                    num1 = (1 until 50).random()
                    num2 = (1 until 50).random()
                }
                num1TV?.text = num1.toString()
                num2TV?.text = num2.toString()
                editTextAnswer?.text = null
            } else {
                //navigate to correct answers
            }
        }

        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    fun solve(operation:String, num1:Int, num2:Int): Int {
        if (operation.equals("add")) {
            return num1 + num2
        } else if (operation.equals("subtract")) {
            return num1 - num2
        } else if (operation.equals("multiply")) {
            return num1 * num2
        } else {
            return num1 / num2
//            TODO rounding?
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuestionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuestionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}