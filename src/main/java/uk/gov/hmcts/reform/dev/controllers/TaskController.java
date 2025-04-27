package uk.gov.hmcts.reform.dev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import uk.gov.hmcts.reform.dev.models.Task;
import uk.gov.hmcts.reform.dev.repositories.TaskRepository;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(path="/task")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping(value = "/create")
    public ResponseEntity<Object> createCase(@RequestBody Task task) {
        try {
            if(task.getId() == null) {
                final var inserted = taskRepository.save(task);
                return created(
                    UriComponentsBuilder.newInstance()
                        .scheme("https")
                        .host("localhost")
                        .port("4000")
                        .path(String.format("/details?id=%d", inserted.getId()))
                    .build().toUri()
                ).body(inserted);
            }
            else {
                return status(HttpStatus.BAD_REQUEST).body("Task to create cannot have an ID. Task IDs are assigned by the server.");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return status(500).body(e.getMessage());
        }
    }

    @GetMapping(value = "/details", produces = "application/json")
    public ResponseEntity<Optional<Task>> retrieveCase(@RequestParam int id) {
        return ok().body(taskRepository.findById(id));
    }

    @GetMapping(value = "/index", produces = "application/json")
    public ResponseEntity<Iterable<Task>> retrieveCases() {
        return ok().body(taskRepository.findAllOrderByCategoryAndDate());
    }

    @PutMapping(value = "/update", produces = "application/json")
    public ResponseEntity<Object> updateCase(@RequestBody Task task) {
        try {
            final var inserted = taskRepository.save(task);
            return ok().body(inserted);
        }
        catch(Exception e) {
            e.printStackTrace();
            return status(500).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> deleteCase(@RequestParam int id) {
        try {
            taskRepository.deleteById(id);
            return ok().build();
        }
        catch(Exception e) {
            e.printStackTrace();
            return status(500).body(e.getMessage());
        }
    }
}
