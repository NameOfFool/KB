package com.fool.knowledge_base.domain.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Запрос на регистрацию")
public class SignUpRequest {
    @Schema(description = "Имя пользователя")
    @Size(min = 5, max = 50, message = "Имя пользователя должно содержать от 5 до 50 символов")
    @NotBlank(message = "Имя пользователя не может быть пустым")
    private String username;

    @Schema(description = "Почта пользователя")
    @Size(min = 5, max = 255, message= "Email должен содержать от 5 до 255 символов")
    @NotBlank(message = "Email не может быть пустым")
    @Email(message = "Email должен быть в формате:user@example.com")
    private String email;

    @Schema(description = "Пароль пользователя")
    @Size(max = 255, message = "Длина пароля должна быть не более 255 символов")
    private String password;
}
