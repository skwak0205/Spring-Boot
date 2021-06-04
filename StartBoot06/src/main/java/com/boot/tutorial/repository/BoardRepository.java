package com.boot.tutorial.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.tutorial.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	List<Board> findByTitle(String title);

	List<Board> findByTitleOrContent(String title, String content);

	// 검색
	Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);

}
