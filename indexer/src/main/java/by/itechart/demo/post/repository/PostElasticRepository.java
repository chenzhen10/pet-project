package by.itechart.demo.post.repository;

import by.itechart.demo.post.dto.PostDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostElasticRepository extends ElasticsearchRepository<PostDto,Long> {
}
