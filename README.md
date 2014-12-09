# **String Parsing with Deterministic Pushdown Automata** #

![pda-overview.png](https://bitbucket.org/repo/6e7oxe/images/185934312-pda-overview.png)

Java (6+) implementation of [deterministic pushdown automata](http://en.wikipedia.org/wiki/Pushdown_automaton).  String are only accepted if they are consumed while being on a final state, with an empty stack. The automaton's transitions, stack operations, and evaluated strings are defined in an input text file. Output declaring strings as accepted/rejected is printed in console and saved in output.txt. To execute call from terminal

```
#!bash

java PDAParsing < input.txt
```
##Input File Definition##

* ***C*** is the number of automaton definitions (aka "cases") specified as the first integer of the input file. Each automaton case defines states, transitions, stack operations, and strings to parse. After ***C***, come ***C*** automata definitions.

* ***S***  (first line of the automaton's definition, first integer) is the number of states in the automaton.

* ***T*** (first line of the automaton's definition, second integer) is the number of transitions defined for the automaton.

* ***F*** (first line of the automaton's definition, third integer) is the number of final states defined for the automaton. 

* ***I***  (first line of the automaton's definition, fourth integer) is the initial state defined for the automaton. 

* ***K*** (first line of the automaton's definition, fifth integer) is the number of strings that will be parsed by the automaton. 

* After the first line of the automaton's definition, come ***F*** lines, each one specifying a final state. 

* After the ***F*** lines of final states, come ***T*** lines of transition definitions.
 
* Each transition starts with 2 integers, ***I** and ***J***. The integer ***I*** corresponds to the transition's origin state, the integer ***J*** corresponds to the transition's destiny state. After ***J*** come 2 characters and : ***read_symbol*** and ***TOP_SYMBOL***; ***read_symbol*** is the character in the input string read, and ***TOP_SYMBOL*** is the symbol currently at the top of the stack. The character '/' represents the end of the input string if parsed as a ***read_symbol***. The character also '/' represents a disregard for the symbol at the top of the stack if it's specified as a ***TOP_SYMBOL***. Stack symbols are represented in uppercase letters. The transition line ends with the string ***STACK_ACTION***, which represents the symbols to be pushed to the stack, starting from the rightmost symbol of the string. The character '/' represents the **pop** stack operation if it's read as symbol from ***STACK_ACTION***.

#### Author: Antonio Rueda-Toicen ####

antonio [dot] rueda "dot" toicen [ at ]  gmail "." com