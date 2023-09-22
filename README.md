# Project 3 Practice Arithmetic

Description of the project ...
* Quiz application that tests user's knowledge of math problems.

## Functionality 

The following **required** functionality is completed:

* [ ] User sees the WelcomeFragment first and can choose the following:
* [ ]     Difficulty: easy, medium, and hard
* [ ]     Operation: addition, subtraction, multiplication, and division
* [ ]     Number of Questions: Greater than or equal to 1
* [ ] User presses "start" button, and app navigates to the QuestionFragment
* [ ] 
* [ ] The user answers the number of questions they chose from the operator and difficulty.
* [ ] When finished with each question, press done.
* [ ] Once the amount of questions requested has been answered, the app navigates to the CorrectAnswersFragment
* [ ] The user sees how many questions out of the total they got correct.
* [ ] If desired, they can go back to the beginning of the app and quiz again, by pressing the "Do it again" button

The following **extensions** are implemented:

* N/A

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/kenna-edwards55/Project3New/blob/main/Project%203%20Demo.gif' title='Video Walkthrough' width='50%' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Describe any challenges encountered while building the app.
* We had problems figuring out what to do to implement PEMDAS. We knew it had to do with some priority logic and a stack/queue. We tried doing an array list that split the code into chunks with priority given to chunks with multiplication, but it was difficult to get it to work 100% of the time. We ended up using the concept of postfix notation to implement the PEMDAS, which allows us to separate the operators and operands into two stacks until we need them, while keeping a postfix output list. We could order the operator stack and then add them in postfix order in the output list. The actual calculation happens in the operand stack but it references the output queue.

Logic
* (Orig Calc= 3+3*5) = Output list: (3, 3, 5, *, +)
* The output list allows us to iterate through and add the operands to the operand stack in order, but once we hit a operator (which is going to be in postfix notation resulting in PEMDAS), it will pop the most recent operands and do the calculation. Once that happens, it adds the result back into the stack for more postfix calcuations.

## License

    Copyright [2023] [Timothy Chan, Kenna Edwards]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
