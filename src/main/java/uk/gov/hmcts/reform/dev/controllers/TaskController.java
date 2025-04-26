package uk.gov.hmcts.reform.dev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.gov.hmcts.reform.dev.repositories.TaskRepository;
import uk.gov.hmcts.reform.dev.models.Task;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(path="/task")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping(value = "/create")
    public ResponseEntity<Task> createCase(Task task) {
        final Task inserted = taskRepository.save(task);
        return ok().body(inserted);
    }

    @GetMapping(value = "/details", produces = "application/json")
    public ResponseEntity<Task> retrieveCase() {
        return status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GetMapping(value = "/index", produces = "application/json")
    public ResponseEntity<Iterable<Task>> retrieveCases() {
        final List<Task> allTasks = new ArrayList<Task>();
        for(final Task task : taskRepository.findAll()) {
            allTasks.add(task);
        }
        return ok().body(allTasks);
    }

    @PutMapping(value = "/get-example-case", produces = "application/json")
    public ResponseEntity<Task> updateCase() {
        return status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Task> deleteCase() {
        return status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
