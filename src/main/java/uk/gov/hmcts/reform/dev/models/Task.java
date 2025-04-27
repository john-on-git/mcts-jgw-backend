package uk.gov.hmcts.reform.dev.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@SecondaryTable(name="task_status")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "task_generator")
    @SequenceGenerator(name="task_generator", sequenceName = "task_id_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable=false)
    private String title;

    @Column()
    private String description;

    @Column(nullable=false)
    private LocalDateTime dueAt;

    @ManyToOne(optional = false)
    @JoinColumn(name="status", nullable = false)
    private TaskStatus status;
}

