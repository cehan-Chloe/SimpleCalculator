# SimpleCalculator

This is my first Android project. The purpose of this project is to let me be familiar with the Android development 
envrionment by implementing a simple calculator.(Do **not** use the code in this repository in your course project).    

In this project, I will design and implement a Casio MS-8L calculator application.

## The interface design
I use relative layout to designed the layout of application. And the way to handle the situation that too many numbers is display them in a single line and the extra numbers is on behalf of ellipsis. And the length of line in textView is 11.    

<img src=https://cloud.githubusercontent.com/assets/15382804/18992458/6ec8130a-86ec-11e6-971f-96ec4f66fffe.png width="200" height="320" />

## Basic calculation

* Implement the calculation of binary operators +, -, * and /. 
* Implement the calculation of unary operators % and √.
* Implement the function of C(clear) button, and ignored the function of AC button.
* Implement the function of MRC, M- and M+.

## Exception handle

* Enter operators before any numbers.If users enter operators like “=” before enter numbers, the application will not give any result. So as the clear button.
* No more than one dot in a number. If users enter  invalid number like 1.2.3, you would not be allowed to enter the second dot.
* No number before dot. If users not enter any numbers before dot like .123, the application will treat it as 0.123 automatically.
* Enter two or more continuous operators. If users enter like 4 + % , then the application will implement the last one %. But if users enter unary operations continuously like 2%%, it will do the operations the same times.
* Infinity or NaN, display “Error”.
* Limit 8 digits after dot.
* Can handle negative number.

## Not finished
- [ ] the priority of operators
