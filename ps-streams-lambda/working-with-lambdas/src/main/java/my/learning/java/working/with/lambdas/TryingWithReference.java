/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.learning.java.working.with.lambdas;

/**
 *
 * @author uditarko
 */
public class TryingWithReference {
    public interface Command 
    {
        public void execute(Object data);
    }

    public class PrintCommand implements Command 
    {
        public void execute(Object data) 
        {
            System.out.println(data.toString());
        }    
    }

    static Command cmd=object -> System.out.println(object);
    
    public static void callCommand(Command command, Object data) 
    {
        command.execute(data);
    }

    public static void main(String[] args) {
        callCommand(cmd,"hello world");
        TryingWithReference t=new TryingWithReference();
        PrintCommand pc=t.new PrintCommand();
        callCommand( pc::execute, "Hello data");
    }
        
}
