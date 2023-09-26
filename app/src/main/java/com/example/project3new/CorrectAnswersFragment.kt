//package com.example.project3new
//
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.TextView
//import androidx.fragment.app.Fragment
//import androidx.navigation.findNavController
//
//class CorrectAnswersFragment : Fragment() {
//    /**
//     * Practice Arithmetic app WelcomeFragment.
//     * This is the third view the user will see.
//     *
//     * @author Kenna Edwards
//     *
//     */
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        /**
//         * Implements onClickListeners for all buttons on the UI screen.
//         * Navigates to the WelcomeFragment
//         *
//         * @property [inflater]: LayoutInflater- Instantiates a layout XML file into its corresponding View objects.
//         * @property [container]: ViewGroup?- contains the elements of the view
//         * @property [savedInstanceState] - saved state of the variables
//         * @return [view]: inflates the view
//         */
//
//        /**
//         * [view]: inflates the layout for this fragment
//         */
//
//        val view = inflater.inflate(R.layout.fragment_correct_answers, container, false)
//
//        /**
//         * Initialization of Button, and TextView objects
//         */
//
//        val tvScore = view?.findViewById<TextView>(R.id.tv_score)
//        val doAgainButton = view?.findViewById<Button>(R.id.button_do_again)
//
//        /**
//         * Initialization of variables [numCorrect], and [outOf] receiving data passed from QuestionFragment.kt
//         * [numCorrect] - an Int that is >= 0
//         * [outOf]- an Int that is >= 1
//         */
//        val numCorrect = CorrectAnswersFragmentArgs.fromBundle(requireArguments()).numCorrect
//        val outOf = CorrectAnswersFragmentArgs.fromBundle(requireArguments()).numOutOf
//
//        /**
//         * Assigns the tvScore text view what the user scored out of the total number of questions
//         */
//        tvScore?.text = "Your score $numCorrect out of $outOf"
//
//        doAgainButton?.setOnClickListener {
//            /**
//             * When doAgainButton is clicked, the NavController navigates to the WelcomeFragment.kt No arguments are sent.
//             */
//            Log.i("CorrectAnswersFragment.kt", "Do again button pressed")
//            val action = CorrectAnswersFragmentDirections.actionCorrectAnswersFragmentToWelcomeFragment().setNumCorrectWelc(numCorrect).setNumOutOfWelc(outOf)
////            val action = CorrectAnswersFragmentDirections.actionCorrectAnswersFragmentToWelcomeFragment()
//            view?.findNavController()?.navigate(action)
//        }
//
//        return view
//    }
//}