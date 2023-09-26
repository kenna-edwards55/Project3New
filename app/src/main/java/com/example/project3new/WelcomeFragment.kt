package com.example.project3new

import android.graphics.Color
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


class WelcomeFragment : Fragment() {
    /**
     * Practice Arithmetic app WelcomeFragment.
     * This is the first view the user will see.
     *
     * @author Kenna Edwards
     *
     */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /**
         * Implements onClickListeners for all buttons on the UI screen.
         * Navigates to the QuestionFragment
         *
         * @property [inflater]: LayoutInflater- Instantiates a layout XML file into its corresponding View objects.
         * @property [container]: ViewGroup?- contains the elements of the view
         * @property [savedInstanceState] - saved state of the variables
         * @return [view]: inflates the view
         */

        /**
         * [view]: inflates the layout for this fragment
         */

        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        /**
         * Initialization of all Button, RadioButton, and TextView objects
         */

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
        val correctAnswersTVWelcome = view?.findViewById<TextView>(R.id.correct_answers_tv)

        /**
         * Variables that will hold information to be passed to the QuestionFragment
         * [difficulty] - a String that will be "easy", "medium", or "hard". The default is "easy".
         * [operation]- a String that will be "add", "subtract", "multiply", or "divide". The default is "add".
         * [numQuestions]- an Int that is >= 1. The default is 1.
         */
        var difficulty = "easy"
        var operation = "addition"
        var numQuestions = 1

        /**
         * Initialization of variables [numCorrect], and [outOf] receiving data passed from QuestionFragment.kt
         * [numCorrect] - an Int that is >= 0
         * [outOf]- an Int that is >= 1
         */

        val numCorrect = WelcomeFragmentArgs.fromBundle(requireArguments()).numCorrect
        val outOf = WelcomeFragmentArgs.fromBundle(requireArguments()).numOutOf

        /**
         * [numCorrect]'s default value in nav_graph.xml is -1.
         * IF this is still [numCorrect]'s value, we know this is the first visit to the WelcomeFragment.kt.
         * No text should be displayed.
         *
         * ELSE
         *  IF the user scored >= 80%, the text is black and textView will congratulate them.
         *  ELSE the textColor is changed to red and textView says user needs more practice.
         */

        if (numCorrect != -1) {
            if (numCorrect.toDouble()/outOf.toDouble() >= 0.8) {
                correctAnswersTVWelcome?.setTextColor(Color.parseColor("#FF000000"))
                correctAnswersTVWelcome?.text = "You got $numCorrect out of $outOf correct in $operation. Good Work!"
            } else {
                correctAnswersTVWelcome?.setTextColor(Color.parseColor("#FC0303"))
                correctAnswersTVWelcome?.text = "You got $numCorrect out of $outOf correct in $operation. You need to practice more!"
            }
        }

        buttonStart?.setOnClickListener {
            /**
             * When buttonStart is clicked, the NavController navigates to the QuestionFragment and sends the arguments
             * [difficulty], [operation], and [numQuestions]
             */

            Log.i("WelcomeFragment.kt", "Start button pressed")
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToQuestionFragment(difficulty, operation, numQuestions)
            view.findNavController().navigate(action)
        }

        buttonMinus?.setOnClickListener {
            /**
             * When buttonMinus is clicked, [numQuestions] decreases
             * [numQuestions] must be >= 1
             * The [tvNumQuestions] is updated to the appropriate number
             */

            Log.i("WelcomeFragment.kt", "Minus questions button pressed")
            if (numQuestions-1 >=1) {
                numQuestions -= 1
            }
            tvNumQuestions?.text = numQuestions.toString()
        }

        buttonPlus?.setOnClickListener {
            /**
             * When buttonPlus is clicked, [numQuestions] increases
             * The [tvNumQuestions] is updated to the appropriate number
             */

            Log.i("WelcomeFragment.kt", "Plus questions button pressed")
            numQuestions += 1
            tvNumQuestions?.text = numQuestions.toString()
        }

        radioButtonEasy?.setOnClickListener {
            /**
             * When radioButtonEasy is pressed, [difficulty] is assigned the String value "easy"
             * The radio_group_difficulty in WelcomeFragment.kt responds appropriately to
             * fill in the circle of the appropriate radio button.
             */

            Log.i("WelcomeFragment.kt", "Easy difficulty radio button selected")
            difficulty = "easy"
        }
        radioButtonMedium?.setOnClickListener {
            /**
             * When radioButtonMedium is pressed, [difficulty] is assigned the String value "medium"
             * The radio_group_difficulty in WelcomeFragment.kt responds appropriately to
             * fill in the circle of the appropriate radio button.
             */

            Log.i("WelcomeFragment.kt", "Medium difficulty radio button selected")
            difficulty = "medium"
        }
        radioButtonHard?.setOnClickListener {
            /**
             * When radioButtonHard is pressed, [difficulty] is assigned the String value "hard"
             * The radio_group_difficulty in WelcomeFragment.kt responds appropriately to
             * fill in the circle of the appropriate radio button.
             */

            Log.i("WelcomeFragment.kt", "Hard difficulty radio button selected")
            difficulty = "hard"
        }
        radioButtonAdd?.setOnClickListener {
            /**
             * When radioButtonAdd is pressed, [operation] is assigned the String value "add"
             * The radio_group_operation in WelcomeFragment.kt responds appropriately to
             * fill in the circle of the appropriate radio button.
             */

            Log.i("WelcomeFragment.kt", "Addition operation radio button selected")
            operation = "addition"
        }
        radioButtonSubtract?.setOnClickListener {
            /**
             * When radioButtonSubtract is pressed, [operation] is assigned the String value "subtract"
             * The radio_group_operation in WelcomeFragment.kt responds appropriately to
             * fill in the circle of the appropriate radio button.
             */

            Log.i("WelcomeFragment.kt", "Subtraction operation radio button selected")
            operation = "subtraction"
        }
        radioButtonMultiply?.setOnClickListener {
            /**
             * When radioButtonMultiply is pressed, [operation] is assigned the String value "multiply"
             * The radio_group_operation in WelcomeFragment.kt responds appropriately to
             * fill in the circle of the appropriate radio button.
             */

            Log.i("WelcomeFragment.kt", "Multiplication operation radio button selected")
            operation = "multiplication"
        }
        radioButtonDivide?.setOnClickListener {
            /**
             * When radioButtonDivide is pressed, [operation] is assigned the String value "divide"
             * The radio_group_operation in WelcomeFragment.kt responds appropriately to
             * fill in the circle of the appropriate radio button.
             */

            Log.i("WelcomeFragment.kt", "Division operation radio button selected")
            operation = "division"
        }

        return view
    }

}