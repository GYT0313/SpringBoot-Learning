package com.gyt.elasticsearch.repository;

import com.gyt.elasticsearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    List<Book> findByBookNameLike(String name);
}
