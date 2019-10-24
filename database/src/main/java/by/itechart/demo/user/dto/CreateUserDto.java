package by.itechart.demo.user.dto;

import by.itechart.demo.common.annotation.validation.username.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {

    @UniqueUsername
    @Size(max = 40,min = 6, message = "Min value should be greater then 6 and Max value should be less then 40")
    private String userName;
    private String password;
    private String role;
}
