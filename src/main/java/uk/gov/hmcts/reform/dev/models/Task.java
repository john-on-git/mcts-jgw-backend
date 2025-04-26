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
@SecondaryTable(name = "task_status", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class Task {
    @Id
    private int id;

    @Column(nullable=false)
    private String title;

    @Column(nullable=true)
    private String description;

    @Column(nullable = false, name = "title", table = "task_status")
    private String statusId;

    @Column(nullable=false)
    private LocalDateTime dueAt;
}

