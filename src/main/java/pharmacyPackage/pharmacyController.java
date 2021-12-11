package pharmacyPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SessionAttributes({"id","desc","errMsg"})
@RequestMapping
@Controller
public class pharmacyController {

//    Lab6. Step 16, update the controller to connect it with real database
    DatabaseService service1;

    @Autowired
    Connection123 connect;

    @Autowired
    DrugService service;

    //A mapping when someone enters file
    @RequestMapping(value = "/drug", method= RequestMethod.GET)
    public String showDrugHomePage(ModelMap model, @RequestParam(defaultValue = "") String id) throws ClassNotFoundException, SQLException{

        service1 = new DatabaseService(connect.connect());


        model.addAttribute("todos", service1.display());


        List<Drug> filteredTodos = new ArrayList<Drug>();


        filteredTodos = (List) model.get("todos");

        model.put("drugcode",filteredTodos.get(0).getDrugcode());

        model.put("drugname",filteredTodos.get(0).getDrugname());

        model.put("drugdesc",filteredTodos.get(0).getDrugdesc());

        return "drug";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showDrugPage2(ModelMap model) throws SQLException, ClassNotFoundException {

        service1 = new DatabaseService(connect.connect());

        model.addAttribute("todos", service1.display());

        List<Drug> filteredTodos = new ArrayList<Drug>();

        filteredTodos = (List) model.get("todos");

        model.put("drugcode",filteredTodos.get(0).getDrugcode());

        model.put("drugname",filteredTodos.get(0).getDrugname());

        model.put("drugdesc",filteredTodos.get(0).getDrugdesc());

        return "drug";
    }

//    Lab5. Step 15. Add a new method in the controller that will open the new page you have just created
    //    Step 16 is found on DrugService class
    @RequestMapping(value ="/add-todo", method = RequestMethod.GET)
    public String showTodoPage() {
        return "druger";
    }

// Lab5. Step 17. Add addTodo method in the controller to take the data from TodoPage then pass them to the Drug Object
//    Lab6. Step 19. Update the Adding Page, link it with database
    @RequestMapping(value ="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String drugcode, @RequestParam String drugname, @RequestParam String drugdesc) throws SQLException, ClassNotFoundException {

        if(!((service1.search(drugcode))==null)){
            model.put("errorMessage", "Record Existing");
            return "redirect:/drug";
        }

        Drug drug = new Drug(drugcode, drugname, drugdesc);

        service1.add(drug);

        model.clear();

        return "redirect:/drug";
    }


//    Lab5: Step 23. Add a method to the controller to call the drugEdit.jsp page
    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showEditTodoPage(ModelMap model, @RequestParam(defaultValue = "") String id) throws SQLException, ClassNotFoundException {

        model.put("drugcode", id);

        Drug drug= service1.search(id);

        model.put("drugcode", drug.getDrugcode());
        model.put("drugname", drug.getDrugname());
        model.put("drugdesc", drug.getDrugdesc());

        return "drugEdit";
    }


//    Lab5: Step23 extra step I wrote it
//    This method is used to return the DrugHomePage after User Edit the EditPage
    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model, @RequestParam String drugcode, @RequestParam String drugname, @RequestParam String drugdesc) throws SQLException, ClassNotFoundException {

        String olddrugcode = (String) model.get("drugcode"); //get the olddrugcode

        Drug newdrug = new Drug(drugcode, drugname, drugdesc);

        service1.edit(newdrug, olddrugcode);

        return "redirect:/drug";
    }





//    Lab5: Step 24. Add the delete method
    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam String id) throws SQLException, ClassNotFoundException {
        service1.delete(id);

        model.clear();
        return "redirect:/drug";
    }



// Lab6: Step 22. Map the method that wil call the Manufacture.jsp
@RequestMapping(value = "/see-todo", method = RequestMethod.GET)
public String seeManufacture(ModelMap model, @RequestParam(defaultValue = "") String id) throws SQLException, ClassNotFoundException{
    model.put("id", id);

    service1 = new DatabaseService(connect.connect());

    String iid = (String) model.get("id");

    List<Manufacture> ManufactureList = new ArrayList<>();

    ManufactureList = service1.display2(iid);

    if(ManufactureList.size()==0){
        model.put("errorMessage", "There are not items for this category");
        return "redirect:/";
    } else {
        model.put("errorMessage","");
    }

    model.put("desc",iid);

    System.out.println(iid);
    model.addAttribute("todos1", service1.display2(iid));

    return "manufacture";
}

//this method is used to redirect to the DrugPage
    @RequestMapping(value = "/see-todo", method= RequestMethod.POST)
    public String returnDrugAfterSeeingManufacture(){
        return "redirect:/drug";
    }

}
