package uk.gov.hmcts.reform.dev.repositories;

import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.gov.hmcts.reform.dev.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer>{
    @NativeQuery("SELECT * FROM task ORDER BY status ASC, due_at ASC")
    Iterable<Task> findAllOrderByCategoryAndDate();
}
