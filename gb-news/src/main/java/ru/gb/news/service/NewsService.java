package ru.gb.news.service;

import ru.gb.news.model.AddNews;
import ru.gb.news.model.News;

import java.util.List;

public interface NewsService {

    public List<News> findAllNews();

    public News findById(long id);

    public void archiveNews(News news);

    public News addNews(AddNews addNews);
}
