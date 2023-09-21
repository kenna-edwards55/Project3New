package com.example.project3new

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

        val difficulty = QuestionFragmentArgs.fromBundle(requireArguments()).difficulty
        val operation = QuestionFragmentArgs.fromBundle(requireArguments()).operation
        val numQuestions = QuestionFragmentArgs.fromBundle(requireArguments()).numQuestions

        val doneButton = view?.findViewById<Button>(R.id.done_button)
        val num1TV = view?.findViewById<TextView>(R.id.tv_num1)
        val num2TV = view?.findViewById<TextView>(R.id.tv_num2)
        val operationTV = view?.findViewById<TextView>(R.id.tv_operation)

        val randomEasy = (1 until 10).random()
        val randomMedium = (1 until 25).random()
        val randomHard = (1 until 50).random()

        var questionsLeft = numQuestions


        doneButton?.setOnClickListener {
            questionsLeft -= 1

            if (questionsLeft >= 1) {
                askQuestion(difficulty)
            } else {
                //navigate to correct answers
            }
        }

        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    fun askQuestion(difficulty:String) {
        if (difficulty == "easy") {

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