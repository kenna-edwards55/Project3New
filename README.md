# Project 4 Practice Arithmetic

Description of the project ...
* Quiz application that tests user's knowledge of math problems.

## Functionality 

The following **required** functionality is completed:

* [ ] User sees the WelcomeFragment first and can choose the following:
* [ ]     Difficulty: easy, medium, and hard
* [ ]     Operation: addition, subtraction, multiplication, and division
* [ ]     Number of Questions: Greater than or equal to 1
* [ ] User presses "start" button, and app navigates to the QuestionFragment
* [ ] The user answers the number of questions they chose from the operator and difficulty.
* [ ] When finished with each question, press done.
* [ ] Once the amount of questions requested has been answered, the app navigates back to the WelcomeFragment
* [ ] The user sees how many questions out of the total they got correct.
* [ ] If user's score is >= 80%, user is congratulated. Otherwise, the text is red and they are told to practice more.
* [ ] If desired, they can do another round of practice.

The following **extensions** are implemented:
* androidx.fragment.app.Fragment
* androidx.navigation.findNavController
* androidx.appcompat.app.AppCompatActivity

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/kenna-edwards55/Project3New/blob/main/Project%203%20Demo.gif' title='Video Walkthrough' width='50%' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Describe any challenges encountered while building the app.
* A major challenge I faced was the plugins.  I did not correctly implement all of the plugins, which led to several hours of debugging the issue.
* Another challenge was passing arguments between screens.  It was difficult to ensure the nav_graph.xml was correctly implemented.

Functionality Note
* For division, the user's answer is equal to the Integer. AKA if the question is 9/8, the answer is 1.

Logic
* The user chooses their difficulty level, which defines what operands will be displayed in the questions.
* "easy" = 1 <= operand < 10
* "medium" = 1 <= operand < 25
* "hard" = 1 <= operand < 50

* When the user submits an answer, the solve() function evaluates and returns the correct answer to the math problem.  An if statement in the "done" button evaluates whether the correct answer matches the users input.  If yes, the number of correct answers increases by 1.  For more details, see kDocs within QuestionFragment.kt

Sound Credits 
* Both sounds are located in /res/raw folder
* correct.mp3 <https://pixabay.com/sound-effects/interface-124464/>
* wrong.mp3 <https://pixabay.com/sound-effects/negative-beeps-6008/>

## License

    Copyright [2023] [Kenna Edwards]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
