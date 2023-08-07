package com.nehak.springbootrestapidb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Schema(description = "User DTO model")
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Schema(description = "User unique Id")
    private String id;
    @Schema(description = "User's username")
    @NotEmpty(message = "User userName should not be null or empty")
    private String userName;
    @Schema(description = "User's lastName")
    @NotEmpty(message = "User userName should not be null or empty")
    private String lastName;
    @Schema(description = "User's email address")
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "Email address should be valid")
    private String email;
}
