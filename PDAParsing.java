
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;



class PushdownAutomaton{

    Integer currentState;
    
    Integer initialState;
    
     
    Stack <Character> stack;
    
    HashSet<Integer> finalStates;
    
    HashMap<String, String> transitions;
    
    PushdownAutomaton(int initialState){
    
        this.currentState = initialState;
        this.initialState = initialState;
        
        stack = new Stack<>();
     
       transitions = new HashMap<>();
       finalStates = new HashSet<>(); 
        
    }
    
    
    public String processInputString(char [] input){
         
        currentState = initialState;
                            
        stack.push('Z');
        char topOfStack = '$'; //dummy
        char currentInputSymbol;
        
        for (int inputIndex = 0; 
                 inputIndex < input.length;
                 inputIndex++){
        
                if (!stack.empty()){
                    topOfStack         = stack.pop();
                }
                 
                currentInputSymbol = input[inputIndex];
                

                //key to query the transitions HashMap
                String transitionKey = String.valueOf(currentState) +
                                       String.valueOf(currentInputSymbol) +
                                       String.valueOf(topOfStack);
                
                if (!transitions.containsKey(transitionKey)){
                    return "rejected";
                }
                
                //todo: check for validity
                String transitionValue = transitions.get(transitionKey);
                
                //update current state    
                currentState = nextState(transitionValue);
                 
                //update stack 
                char [] symbolsToStack = getStackActionSymbols(transitionValue);
                
                //only push when symbol is different from '/'
                if (symbolsToStack[0]!='/'){
                    //stack first the rightmost symbols
                    for (int stackIndex = symbolsToStack.length-1;
                             stackIndex >= 0;
                             stackIndex--){

                        stack.push(symbolsToStack[stackIndex]);
                    }
                }
        }

           // after consuming the string 
          // the input is "ACCEPTED" IF 
         // the automaton is in a final state AND
        // the top of stack is Z  
               
         if (finalStates.contains(currentState) && 
             topOfStack=='Z'){
                return "accepted"; 
            }
        
         return "rejected";
    }
    
    
    
    
    public char [] getStackActionSymbols(String newStateAndActionValuePair){
      
        char [] stackActionSymbols = newStateAndActionValuePair.substring(1,
                                     newStateAndActionValuePair.length())
                                    .toCharArray();
        
        return stackActionSymbols; 
    }
    
    public int nextState(String newStateAndActionValuePair){
    
        int nextState = Integer
                .parseInt(newStateAndActionValuePair.substring(0,1));

        return nextState;
        
    }
}

public class PDAParsing {

  public static void main (String args[]) {

	//File file = new File("input.txt");

	try {

            //Scanner scanner = new Scanner(file);
            Scanner scanner = new Scanner(System.in);
	    PrintWriter pw = new PrintWriter("output.txt");
            
	    
	    int cases = scanner.nextInt();
            
            for (int caseIndex = 0; 
                     caseIndex < cases; 
                     caseIndex++){
                
                pw.println("Case " + String.valueOf(caseIndex+1) + ":");
		System.out.println("Case " + String.valueOf(caseIndex+1) + ":");                

                int automatonStates       = scanner.nextInt();
                int numberOfTransitions   = scanner.nextInt();
                int numberOfFinalStates   = scanner.nextInt(); 
                int initialState          = scanner.nextInt();
                int numberOfTestStrings   = scanner.nextInt();
                
                PushdownAutomaton pda = new PushdownAutomaton(initialState);
               
                //add final states
                for (int final_state_index = 0;
                         final_state_index < numberOfFinalStates;
                         final_state_index++){
                
                        pda.finalStates.add(scanner.nextInt());
                }
                
                //add transitions
                for (int transition_index = 0;
                         transition_index < numberOfTransitions;
                         transition_index++){
                
                         String originState        = scanner.next();
                         String destinyState       = scanner.next();
                         String inputSymbol        = scanner.next();
                         String symbolTopOfStack   = scanner.next();
                         String stackAction        = scanner.next();
                         
                         //transitions HashMap key
                         String originInputTopKey;
                         
                         originInputTopKey =    originState 
                                                + inputSymbol 
                                                + symbolTopOfStack;
                         
                         //transitions HashMap value
                         String destinyActionValue;
                         
                         destinyActionValue = destinyState
                                              + stackAction;
                         
                         
                         pda.transitions.put(originInputTopKey, 
                                             destinyActionValue);
                }
                
                // process input strings
                for (int stringIndex = 0; 
                         stringIndex < numberOfTestStrings;
                         stringIndex++){
                
                    //clear stack from previous test case
                    pda.stack.clear();
                    String input = scanner.next();
                    input = input + "/";
                    
                    String result 
                            = pda.processInputString(input.toCharArray());
                    
                    pw.println(result);
		    System.out.println(result);
                }
            }
                
                scanner.close();
                pw.flush();
                pw.close();
                } 
    	
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

	}


}
