# **String Parsing with Deterministic Pushdown Automata** #

![pda-overview.png](https://bitbucket.org/repo/6e7oxe/images/185934312-pda-overview.png)

Java (6+) implementation of [deterministic pushdown automata](http://en.wikipedia.org/wiki/Pushdown_automaton).  Strings are only accepted if they are consumed while the automaton is on a final state, with an empty stack. The automaton's transitions, stack operations, and evaluated strings are defined in an input text file. Output declaring strings as accepted/rejected is printed in console and saved in output.txt. To execute call from terminal

```
#!bash

java PDAParsing < input.txt
```
##Input File Definition##

* ***C*** is the number of automaton definitions ("cases") and is the first integer of the input file. Each automaton case defines states, transitions, stack operations, and strings to parse. After this line, come ***C*** automata definitions.

* ***S***  (first line of the automaton's definition, first integer) is the number of states in the automaton.

* ***T*** (first line of the automaton's definition, second integer) is the number of transitions defined for the automaton.

* ***F*** (first line of the automaton's definition, third integer) is the number of final states defined for the automaton. 

* ***I***  (first line of the automaton's definition, fourth integer) is the initial state defined for the automaton. 

* ***K*** (first line of the automaton's definition, fifth integer) is the number of strings that will be parsed by the automaton. 

* After the first line of the automaton's definition, come ***F*** lines, each one specifying a final state. 

* After the ***F*** lines of final states, come ***T*** lines of transition definitions.
 
* Each transition starts with 2 integers, ***I*** and ***J***. The integer ***I*** corresponds to the transition's origin state, the integer ***J*** corresponds to the transition's destiny state. After ***J*** come 2 characters: ***read_symbol*** and ***TOP_SYMBOL***; ***read_symbol*** is the character read in the input string, and ***TOP_SYMBOL*** is the symbol currently at the top of the stack. When found as a ***read_symbol***, the character '/' represents the end of the input string. If it's specified as a ***TOP_SYMBOL***, the character  '/'  represents a disregard for the symbol at the top of the stack. Stack symbols are specified in uppercase letters in the input example below. The transition line ends with the string ***STACK_ACTION***, which represents the symbols to be pushed to the stack, starting from the rightmost symbol of the string. When read as a symbol from ***STACK_ACTION***, the character '/' represents the **pop** stack operation.

###input###
2

3 5 1 0 5

2

0 0 1 Z XZ

0 0 1 X XX

0 1 0 X X

1 1 1 X /

1 2 / Z Z

111101111

110111

011111

11011

###output###
Case 1:

accepted

rejected

rejected

accepted

rejected

#### Author: Antonio Rueda-Toicen ####

antonio [dot] rueda "dot" toicen [ at ]  gmail "." com

License: Affero GPL