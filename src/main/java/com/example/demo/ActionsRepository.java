package com.example.demo;

import com.example.demo.model.Action;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActionsRepository extends CrudRepository<Action, Long> {

    Action findActionById(Long id);
    List<Action> findActionByName(String name);


}
