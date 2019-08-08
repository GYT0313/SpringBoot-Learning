package com.gyt.elasticsearch;

import com.gyt.elasticsearch.bean.Article;
import com.gyt.elasticsearch.bean.Book;
import com.gyt.elasticsearch.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void test02() {
//        Book book = new Book();
//        book.setId(1);
//        book.setName("西游戏");
//        book.setAuthor("李四");
//        bookRepository.index(book);
        for (Book book : bookRepository.findByBookNameLike("西")) {
            System.out.println(book);
        }
    }

    @Test
    public void contextLoads() {
        // 1、给es中索引一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("good news");
        article.setAuthor("zhangsan");
        article.setContent("Hello world");

        // 构建一个索引功能
        Index index = new Index.Builder(article).index("gyt").type("news").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 搜索
    @Test
    public void search() {
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search build = new Search.Builder(json).addIndex("gyt").addType("news").build();
        try {
            SearchResult result = jestClient.execute(build);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
