package by.itechart.demo.post.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDto {

    private Long id;
    private String name;
    private Date date;
    private String tag;
    private String body;
}
