package uk.gov.hmcts.reform.dev.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class TaskStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "task_status_generator")
    @SequenceGenerator(name="task_status_generator", sequenceName = "task_status_id_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable=false)
    private String title;
}
