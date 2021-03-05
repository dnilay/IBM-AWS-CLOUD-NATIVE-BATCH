package comm.example;

import java.util.Random;
import java.util.Scanner;

public class Todo {
    private int todoId;
    private String todoName;

    public Todo() {
    }

    private static Scanner scanner=new Scanner(System.in);
    public Todo(int todoId, String todoName) {
        this.todoId = todoId;
        this.todoName = todoName;
    }

    public  Todo createTodo()
    {
        System.out.print("TodoName: ");
        String name=scanner.next();
        if(name.length()<8)
        {
            throw new TodoException("ToDo Desc is insufficient");
        }
        this.todoId=new Random().nextInt(1000);
        this.todoName=name;
        Todo todo=new Todo(todoId,todoName);
        return todo;

    }

    @Override
    public String toString() {
        return "Todo{" +
                "todoId=" + todoId +
                ", todoName='" + todoName + '\'' +
                '}';
    }
}
