package com.example.demo.Dto;

import com.example.demo.constants.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class TaskDto {

    public String name;

    public String description;

    @Enumerated(EnumType.STRING)
    public Status status;

    public String customerName;

}
