package ru.gb.news.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.news.model.AddNews;
import ru.gb.news.model.News;
import ru.gb.news.model.Status;
import ru.gb.news.repository.NewsRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<News> findAllNews() {
        return newsRepository.findAll();
    }

    public News findById(long id) {
        return newsRepository.findById(id).orElse(null);
    }

    public void archiveNews(News news) {
        if (news.getStatus() != Status.Archive) {
            news.setStatus(Status.Archive);
        }
        newsRepository.saveAndFlush(news);
    }

    public News addNews(AddNews addNews) {
        News news = new News();
        news.setShortDescription(addNews.getShortDescription());
        news.setDescription(addNews.getDescription());
        news.setCreateDate(LocalDate.now());
        news.setStatus(Status.Active);
        return newsRepository.saveAndFlush(news);
    }
}
