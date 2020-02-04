package by.itechart.demo.post.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "blog", type = "post")
public class PostDto {
    private Long id;
    private String name;
    private String body;
    private String tag;
}
