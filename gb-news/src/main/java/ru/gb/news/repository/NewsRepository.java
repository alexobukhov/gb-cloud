package ru.gb.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.news.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
