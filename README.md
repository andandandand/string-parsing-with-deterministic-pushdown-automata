# **String Parsing with Deterministic Pushdown Automata** #

![pda-overview.png](https://bitbucket.org/repo/6e7oxe/images/185934312-pda-overview.png)

Java (6+) implementation of a [deterministic pushdown automaton](http://en.wikipedia.org/wiki/Pushdown_automaton).  String are only accepted if they are consumed while being on a final state, with an empty stack. The automaton's transitions, stack operatrions, and evaluated strings are defined in an input text file. Output declaring strings as accepted/rejected is printed in console and saved in output.txt. To execute call from terminal

```
#!bash

java PDAParsing < input.txt
```
#### Author: Antonio Rueda-Toicen ####

antonio [dot] rueda "dot" toicen [ at ]  gmail "." com