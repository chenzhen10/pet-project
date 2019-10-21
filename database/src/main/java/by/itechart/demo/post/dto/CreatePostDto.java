package by.itechart.demo.post.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePostDto {
    private String name;
    private Date date;
    private String tag;
}
