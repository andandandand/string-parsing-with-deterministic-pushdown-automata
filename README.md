# **String Parsing with Deterministic Pushdown Automata** #

![pda-overview.png](https://bitbucket.org/repo/6e7oxe/images/185934312-pda-overview.png)

Java (6+) implementation of a [deterministic pushdown automaton](http://en.wikipedia.org/wiki/Pushdown_automaton).  String are only accepted if they are consumed while being on a final state, with an empty stack. The automaton's transitions, stack operations, and evaluated strings are defined in an input text file. Output declaring strings as accepted/rejected is printed in console and saved in output.txt. To execute call from terminal

```
#!bash

java PDAParsing < input.txt
```
##Input File Definition##

* ***C*** is the number of automaton definitions (aka "cases") specified as the first integer of the input file. Each automaton case defines states, transitions, stack operations, and strings to parse. After ***C***, come ***C*** automata definitions.

* ***S*** is the number of states in 

#### Author: Antonio Rueda-Toicen ####

antonio [dot] rueda "dot" toicen [ at ]  gmail "." com