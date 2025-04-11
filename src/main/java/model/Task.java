package model;

import constants.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    public static final String ID = "id";
    public static final String TASK_NAME = "task_name";
    public static final String DESCRIPTION = "description";
    public static final String CREATE_AT = "created_at";
    public static final String UPDATE_AT = "updated_at";
    public static final String STATUS = "status";
    public static final String CUSTOMER_NAME = "customer_name";
    public static final String EMAIL = "email";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;

    @Column(name = TASK_NAME)
    private String name;

    @Column(name = DESCRIPTION)
    private String description;

    @Column(name = CREATE_AT)
    private LocalDateTime createdAt;

    @Column(name = UPDATE_AT)
    private LocalDateTime updatedAt;

    @Column(name = STATUS)
    @Enumerated(EnumType.STRING)
    private Status status = Status.CREATED;

    @Column(name = CUSTOMER_NAME)
    private String customerName;

    @Column(name = EMAIL)
    private String email;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
