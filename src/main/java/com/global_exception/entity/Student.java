package com.global_exception.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "student")
public class Student {

    @Id  // primary key
    private short id;

    @NotNull(message = "user shouldn't null")
    private String name;

    @Min(5)
    @Max(20)
    private int age;

    @Pattern(regexp = "^[0-9]+$", message = "rollNo must be numeric")
    @NotBlank(message = "user should have a rollNo")
    private String rollNo;

    @NotBlank
    @Pattern(regexp = "^\\d{6}$")
    private String zipCode;
}
