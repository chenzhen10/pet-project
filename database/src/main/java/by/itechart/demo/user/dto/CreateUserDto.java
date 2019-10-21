package by.itechart.demo.user.dto;

import by.itechart.demo.common.annotation.validation.username.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {

    @UniqueUsername
    @Min(value = 6, message = "Min value should be greater then 6")
    @Max(value = 40, message = "Max value should be less then 40")
    private String userName;
    private String password;
    private String role;
}
