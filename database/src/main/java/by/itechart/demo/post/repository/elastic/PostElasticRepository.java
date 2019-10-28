package by.itechart.demo.post.repository.elastic;

import by.itechart.demo.post.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PostElasticRepository extends ElasticsearchRepository<Post,Long> {

}
