package pharmacyPackage;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugService {

    private static List<Drug> todos = new ArrayList<>();

    static {
        todos.add(new Drug("Drug 1", "Drug Name 1", "Drug Description 1"));
        todos.add(new Drug("Drug 2", "Drug Name 2", "Drug Description 2"));
        todos.add(new Drug("Drug 3", "Drug Name 3", "Drug Description 3"));
        todos.add(new Drug("Drug 4", "Drug Name 4", "Drug Description 4"));
    }

    //This method is to display the inital data from Static method above
    public List<Drug> retrieveTodos(){
        List<Drug> filteredTodos = new ArrayList<>();
        for (Drug todo: todos){
            filteredTodos.add(todo);
        }

        return filteredTodos;
    }

//    Lap 5. Step 16. Add the method in DrugService Class to add data after user enter
//     and click on the Submit button on Druger Page. Then add this method to the controller
    public void addTodo(String drugcode, String drugname, String drugdesc) {
        todos.add(new Drug(drugcode, drugname, drugdesc));
    }

    //    Lab 5. Step 18. Complete the DrugService code
//    Create a Delete Method, this method will be called on the Controller later on
    public void deleteTodo(String id){
        for(int i=0; i<todos.size(); i++){
            if(id.equals(todos.get(i).getDrugcode())){

                todos.remove(i);
                break;
            }
        }
    }

    //    Lab 5. Step 18. Complete the DrugService code
//  This method is used to retrieved data from Drug class
    public Drug retrieve(String id){    // id is the input of Drugcode when user input drugcode
        for(Drug todo: todos){
           if (todo.getDrugcode().equals(id)){
               return todo;
           }
        }
        return null;
    }

    //    Lab 5. Step 18. Complete the DrugService code
//  This method is used to Update data to the Drug class
    public void update(Drug todo){
        todos.remove(todo);
        todos.add(todo);
    }
}
