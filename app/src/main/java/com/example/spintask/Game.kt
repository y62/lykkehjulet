package com.example.spintask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spintask.databinding.FragmentGameBinding

class Game : Fragment(R.layout.fragment_game) {
    private var _binding : FragmentGameBinding? = null
    private val binding get () = _binding!!
    val cars = arrayOf("bmw", "mercedes", "toyota", "ferrari", "peugeot", "nissan", "tesla", "ford" )
    val countries = arrayOf("japan", "china", "canada", "brazil", "venezuela", "egypt", "australia", "denmark" )
    val cities = arrayOf("copenhagen", "sydney", "moscow", "delhi", "kyoto", "phoenix", "berlin", "paris", "bucharest" )
    val animals = arrayOf("elephant", "leopard", "cheetah", "crocodile", "horse", "donkey", "rabbit", "squirrel" )
    val brands = arrayOf("adidas", "gucci", "pringles", "pepsi", "microsoft", "visa", "nivea", "lacoste", "starbucks" )
    val celebrities = arrayOf("madonna", "trump", "drake", "rihanna", "eminem", "putin", "undertaker" )
    val finalResultMsg = arrayOf("YOU WIN!", "YOU LOSE!")
    val categories = arrayOf(cars, countries, cities, animals, brands, celebrities)
    val categoryNames = arrayOf("car", "country", "city", "animal", "brand", "celebrity")
    val categoryRandomizer = (0..5).random()
    val randomCategory = categories[categoryRandomizer]
    val randomCategoryWord = randomCategory[(0..randomCategory.lastIndex).random()]
    val questionMarks = mutableListOf<String>()
    val letters = mutableListOf<String>()
    var word: String = ""
    var tempWord: String = ""
    var questionWord: String = ""
    var tempQuestionWord: String = ""
    var questionMarkSigns: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         var point: Int = 1000
         var life: Int = 5
         val spinResult = arrayOf("Bankrupt", "1000 Extra!", "Miss Turn", "Extra Turn!" )

        binding.spinButton.setOnClickListener {
            val numbers = (0..3).random()
            if (spinResult[numbers] == spinResult[0]) {
                point = 0
            }
            if (spinResult[numbers] == spinResult[1]) {
                point += 1000
            }
            if (spinResult[numbers] == spinResult[2]) {
                life -= 1
            }
            if (spinResult[numbers] == spinResult[3]) {
                life += 1
            }
            if (life <= 0) {
            binding.finalResult.text = finalResultMsg[1].toString()
            }
       /*     if (life <= 0) {
                val toast = Toast.makeText(this,"GAME OVER!", Toast.LENGTH_SHORT)
                toast.show()
            } */
            binding.spinResultText.text = spinResult[numbers]
            binding.lives.text = life.toString()
            binding.points.text = point.toString()
        }

        println("Category " +  categoryNames[categoryRandomizer])
        binding.category.text = categoryNames[categoryRandomizer].toString()

        for (i in randomCategoryWord.indices) {
            questionMarks.add("?")
            questionMarkSigns += "?"
        }

        for (i in randomCategoryWord.indices) {
            letters.add(randomCategoryWord[i].toString())
        }

        for (i in letters.indices) {
            tempWord = letters[i].toString()
            word += tempWord
        }

        binding.guessResult.text = questionMarkSigns.toString()

        binding.enter.setOnClickListener{
            tempQuestionWord = ""
            for (i in letters.indices) {
                if (letters[i] == binding.guessTheWord.text.toString()) {
                    questionMarks[i] = letters[i]
                }
            }

            if (!letters.contains(binding.guessTheWord.text.toString())) {
                life--
            }

            questionWord = ""
            for (i in questionMarks.indices) {
                tempQuestionWord = questionMarks[i].toString()
                questionWord += tempQuestionWord
            }
            binding.guessResult.text = questionWord.toString()
            binding.lives.text = life.toString()

            if (questionWord == word && life >= 0) {
                binding.finalResult.text = finalResultMsg[0].toString()
            }
            if (life <= 0) {
                binding.finalResult.text = finalResultMsg[1].toString()
            }

          /*  if (questionWord == word) {
                val toast = Toast.makeText(this,"YOU WIN!", Toast.LENGTH_SHORT)
                toast.show()
            }

            if (life <= 0) {
                val toast = Toast.makeText(this,"GAME OVER!", Toast.LENGTH_SHORT)
                toast.show()
            }
*/
            //  binding.guessResult.text = binding.guessTheWord.text.toString()
            // binding.guessResult.text = cars[1].toString()
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}