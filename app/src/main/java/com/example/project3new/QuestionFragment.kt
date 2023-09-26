package com.example.project3new

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class QuestionFragment : Fragment() {
    /**
     * Practice Arithmetic app QuestionFragment.
     * This is the second view the user will see.
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
         * Navigates to the CorrectAnswersFragment
         *
         * @property [inflater]: LayoutInflater- Instantiates a layout XML file into its corresponding View objects.
         * @property [container]: ViewGroup?- contains the elements of the view
         * @property [savedInstanceState] - saved state of the variables
         * @return [view]: inflates the view
         */

        /**
         * [view]: inflates the layout for this fragment
         */
        val view = inflater.inflate(R.layout.fragment_question, container, false)

        /**
         * Initialization of all Button, and TextView objects
         */
        val doneButton = view?.findViewById<Button>(R.id.done_button)
        val num1TV = view?.findViewById<TextView>(R.id.tv_num1)
        val num2TV = view?.findViewById<TextView>(R.id.tv_num2)
        val operationTV = view?.findViewById<TextView>(R.id.tv_operation)
        val editTextAnswer = view?.findViewById<EditText>(R.id.edit_text_answer)

        /**
         * Initialization of variables [difficulty], [operation], and [numQuestions] receiving data passed from WelcomeFragment.kt
         * [difficulty] - a String that will be "easy", "medium", or "hard"
         * [operation]- a String that will be "add", "subtract", "multiply", or "divide"
         * [numQuestions]- an Int that is >= 1
         */
        val difficulty = QuestionFragmentArgs.fromBundle(requireArguments()).difficulty
        val operation = QuestionFragmentArgs.fromBundle(requireArguments()).operation
        val numQuestions = QuestionFragmentArgs.fromBundle(requireArguments()).numQuestions

        /**
         * [correctAnswers]: an Int.
         *          A counter that increments by one when the user's input matches the correct answer to the question posed
         * [questionsLeft]: an Int.
         *          A counter that begins as equivalent to the [numQuestions] value passed from WelcomeFragment.kt.
         *          Decrements by 1 each time the user submits an answer with buttonDone (see buttonDone.setOnClickListener)
         */
        var correctAnswers = 0
        var questionsLeft = numQuestions

        /**
         * See nums() for assignments of [num1] and [num2]
         * [num1]: an Int. The first number in the arithmetic expression posed to the user.
         * [num2]: an Int. The second number in the arithmetic expression posed to the user.
         */
        var num1 = 0
        var num2 = 0

        /**
         * Evaluates the value in the [operation] String, whose value was passed from WelcomeFragment.kt
         * Assigns the value to the operationTV in the UI.
         */

        if (operation == "addition") {
            operationTV?.text = "+"
        } else if (operation == "subtraction") {
            operationTV?.text = "-"
        } else if (operation == "multiplication") {
            operationTV?.text = "X"
        } else {
            operationTV?.text = "/"
        }

        /**
         * First question assignment of [num1] and [num2]
         * [num1TV.text] and [num2TV.text] are assigned the values of both [num1] and [num2], which are cast to Strings
         */
        num1 = nums(difficulty)
        num2 = nums(difficulty)
        num1TV?.text = num1.toString()
        num2TV?.text = num2.toString()

        /**
         * Defining the MediaPlayers to play sounds for when a user gets an answer correct/wrong
         * [mediaPlayerCorrect]: a MediaPlayer- plays the correct.mp3 file in /res/raw
         * [mediaPlayerWrong]: a MediaPlayer- plays the wrong.mp3 file in /res/raw
         */
        var mediaPlayerCorrect= MediaPlayer.create(activity, R.raw.correct)
        var mediaPlayerWrong = MediaPlayer.create(activity, R.raw.wrong)

        /**
         * Defining the Toasts
         * [toastCorrect] shows when the user's answer was correct
         * [toastWrong] shows when the user's answer was wrong
         */
        val toastCorrect = Toast.makeText(activity, "Correct. Good Work!", Toast.LENGTH_SHORT)
        val toastWrong = Toast.makeText(activity, "Wrong", Toast.LENGTH_SHORT)

        doneButton?.setOnClickListener {
            /**
             * When doneButton is clicked, it is first evaluated whether the user's input matches the correct answer to the problem.
             * If the answer is correct, [correctAnswers] increments by 1, a Toast shows that the user's answer was correct, and a ding sound plays
             * If the answer is wrong, a Toast shows that the user's answer was wrong, and a falling sound plays
             *
             * [questionsLeft] is decremented by 1.
             *
             * IF: there are questions left, [num1] and [num2] are reassigned,
             * the [num1TV] and [num2TV] are updated appropriately,
             * and the user can answer the new question.
             *
             * ELSE: the NavController navigates to the CorrectAnswersFragment and sends the arguments
             * [correctAnswers] and [numQuestions]
             */
            Log.i("QuestionFragment.kt", "Done button Pressed")

            if (editTextAnswer?.text.toString().toInt() == solve(operation,num1,num2)) {
                Log.i("QuestionFragment.kt", "Correct answer")
                correctAnswers += 1

                toastCorrect.show()
                mediaPlayerCorrect?.start()
            } else {
                Log.i("QuestionFragment.kt", "Incorrect answer")
                toastWrong.show()
                mediaPlayerWrong?.start()
            }
            questionsLeft -= 1

            if (questionsLeft >= 1) {
                num1 = nums(difficulty)
                num2 = nums(difficulty)
                num1TV?.text = num1.toString()
                num2TV?.text = num2.toString()
                editTextAnswer?.text = null
            } else {
                val action = QuestionFragmentDirections.actionQuestionFragmentToWelcomeFragment().setNumCorrect(correctAnswers).setNumOutOf(numQuestions)
                view?.findNavController()?.navigate(action)
            }
        }

        return view
    }

    fun nums(difficulty:String): Int {
        /**
         * Returns a random number based on the difficulty of problem.
         *
         * @param difficulty: a String. The difficulty of question the user selected in WelcomeFragment
         *
         * @return a random number
         */
        if (difficulty == "easy") {
            return (1 until 10).random()
        } else if (difficulty == "medium") {
            return (1 until 25).random()
        } else { //hard
            return (1 until 50).random()
        }
    }


    fun solve(operation:String, num1:Int, num2:Int): Int {
        /**
         * Solves and returns the mathematical problem that is posed to the user.
         *
         * @param operation: a String. The operation the user selected in WelcomeFragment
         * @param num1: an Int. The first operand in the math expression
         * @param num2: an Int. The second operand in the math expression
         *
         * @return the correct answer to the mathematical problem
         */
        if (operation.equals("addition")) {
            return num1 + num2
        } else if (operation.equals("subtraction")) {
            return num1 - num2
        } else if (operation.equals("multiplication")) {
            return num1 * num2
        } else {
            return num1 / num2
        }
    }

}