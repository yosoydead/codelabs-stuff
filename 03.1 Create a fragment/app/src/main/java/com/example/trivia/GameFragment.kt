package com.example.trivia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.trivia.databinding.FragmentGameBinding


//simply creating a game fragment
class GameFragment: Fragment() {

    //this is how the question would be structured
    //the text of the question
    //an array which stores 4 values as answers
    data class Question(val text: String, val answers: List<String>)

    //this is a list of some questions and their "answers"
    //first answer is the correct one. randomize the answer before showing the text
    //all questions must have four answers
    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "What is Android Jetpack?",
            answers = listOf("All of these", "Tools", "Documentation", "Libraries")),
        Question(text = "What is the base class for layouts?",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")),
        Question(text = "What layout do you use for complex screens?",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")),
        Question(text = "What do you use to push structured data into a layout?",
            answers = listOf("Data binding", "Data pushing", "Set text", "An OnClick method")),
        Question(text = "What method do you use to inflate layouts in fragments?",
            answers = listOf("onCreateView()", "onActivityCreated()", "onCreateLayout()", "onInflateLayout()")),
        Question(text = "What's the build system for Android?",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")),
        Question(text = "Which class do you use to create a vector drawable?",
            answers = listOf("VectorDrawable", "AndroidVectorDrawable", "DrawableVector", "AndroidVector")),
        Question(text = "Which one of these is an Android navigation component?",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")),
        Question(text = "Which XML element lets you register an activity with the launcher activity?",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")),
        Question(text = "What do you use to mark a layout for data binding?",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>"))
    )

    //this is going to hold the question which will be displayed
    lateinit var currentQuestion: Question
    //this list will contain the currently displayed question's answers
    lateinit var answers: MutableList<String>


    private var questionIndex = 0

    //this will be the number of questions the game will show
    //the maximum would be 3 questions
    //if the arrays size is bigger than 3, then 3 would be chosen because of the min()
    //if the (arrays size +1)/2 is < 3, then the arrays length would be chosen because of the min()
    private val numQuestions = Math.min((questions.size +1) / 2, 3)

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //create the binding object to use it in the view
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater, R.layout.fragment_game, container, false)


        //start the game with a randomized list of questions
        randomizeQuestions()

        //the views game object will be this class with all its properties
        binding.game = this

        //set a click listener for the submit button of the view
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER"){view: View ->

            //see what value the user checked
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId

            //if the user did choose something
            if(-1 != checkedId){

                //set the answer index to 0 because all questions have the correct answer
                //at index 0
                var answerIndex = 0

                //if the checkBox is not the first one, update the answerIndex value
                when(checkedId){
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }

                //if the user gave the correct answer
                if(answers[answerIndex] == currentQuestion.answers[0]){
                    questionIndex++

                    //go to the next question only if you didn;t exceed
                    //the max number of questions
                    if(questionIndex < numQuestions){
                        //set the new question
                        currentQuestion = questions[questionIndex]
                        setQuestion()

                        //use invalidate to update/redraw the view
                        binding.invalidateAll()
                    }else{
                        //if you exceeded the number of max questions
                        //we won. navigate to the gameWonFragment
                        Navigation.findNavController(view).navigate(R.id.action_gameFragment_to_gameWonFragment)
                    }
                }//if you gave the wrong answer
                else{
                    //game over. navigate to the gameOverFragment
                    Navigation.findNavController(view).navigate(R.id.action_gameFragment_to_gameOverFragment)
                }
            }

        }
        return binding.root
    }

    //small function that helps shuffle the questions array and
    //picks the first question
    private fun randomizeQuestions(){
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    //this sets the question for each drawn view
    private fun setQuestion(){
        currentQuestion = questions[questionIndex]

        //this holds the answers for the current question
        answers = currentQuestion.answers.toMutableList()

        answers.shuffle()

        //this makes the actionbar display a text that shows how many questions you are in
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_android_trivia_question, questionIndex+1, numQuestions)
    }
}