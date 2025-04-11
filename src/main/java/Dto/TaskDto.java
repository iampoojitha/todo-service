package Dto;

import constants.Status;
import jakarta.annotation.Nonnull;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class TaskDto {

    @Nonnull
    public String name;

    public String description;

    @Enumerated(EnumType.STRING)
    public Status status;

    public String customerName;

}
