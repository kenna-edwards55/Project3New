package com.example.project3new

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController


/**
 * A simple [Fragment] subclass.
 * Use the [CorrectAnswersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CorrectAnswersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_correct_answers, container, false)
        val tvScore = view?.findViewById<TextView>(R.id.tv_score)
        val doAgainButton = view?.findViewById<Button>(R.id.button_do_again)
        val numCorrect = CorrectAnswersFragmentArgs.fromBundle(requireArguments()).numCorrect
        val outOf = CorrectAnswersFragmentArgs.fromBundle(requireArguments()).numOutOf

        tvScore?.text = "Your score $numCorrect out of $outOf"

        doAgainButton?.setOnClickListener {
            Log.i("CorrectAnswersFragment.kt", "Do again button pressed")
            //go back to the beginning
            val action = CorrectAnswersFragmentDirections.actionCorrectAnswersFragmentToWelcomeFragment()
            view?.findNavController()?.navigate(action)
        }

        return view
    }
}