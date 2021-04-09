package com.example.demo;

import com.example.demo.model.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoController extends HttpServlet {

    @Autowired private ActionsRepository actionsRepository;

    @RequestMapping("/todo/{id}")
    public ResponseEntity<Action> todo(@PathVariable(value = "id") long id){
        return new ResponseEntity<Action>((actionsRepository.findActionById(id)), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping("/todo")
    public @ResponseBody
    List<Action> todos(){

        List<Action> actions = new ArrayList<>();

        actionsRepository.findAll().forEach(actions::add);
        System.out.println(actions);
        return actions;
    }


    @CrossOrigin
    @PostMapping(value = "/todo/create", consumes = "application/x-www-form-urlencoded")
    @ResponseStatus(HttpStatus.CREATED)
    public String createToDo(@RequestParam String name, @RequestParam String text) {
        Action action = new Action(name, text);
        actionsRepository.save(action);
        return "result";
    }


    @CrossOrigin
    @PutMapping(value = "/todo/update/{id}", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Action> todoUpdate (@PathVariable(value = "id") long id,
                                              @RequestParam String name,
                                              @RequestParam String text){
        Action action = actionsRepository.findActionById(id);
        action.setName(name);
        action.setText(text);
        actionsRepository.save(action);
        return new ResponseEntity<Action>(actionsRepository.findActionById(id), HttpStatus.OK);
    }


    @CrossOrigin
    @DeleteMapping(value = "/todo/delete/{id}")
    public ResponseEntity<Void> todoDelete (@PathVariable(value = "id") long id) {
        actionsRepository.delete(actionsRepository.findActionById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
