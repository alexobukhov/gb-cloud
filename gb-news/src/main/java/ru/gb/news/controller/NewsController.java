package ru.gb.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.news.model.News;
import ru.gb.news.service.NewsService;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/get")
    public List<News> findAllNews() {
        return newsService.findAllNews();
    }

    @GetMapping("/get/{id}")
    public News findById(@PathVariable long id) {
        return newsService.findById(id);
    }

    @DeleteMapping("/delete")
    public void deleteNews(@RequestBody News news) {
        newsService.archiveNews(news);
    }
}
