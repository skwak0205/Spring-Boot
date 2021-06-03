package com.boot.tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import com.boot.tutorial.model.Board;
import com.boot.tutorial.repository.BoardRepository;

@RestController
@RequestMapping("/api")
public class BoardApiController {

	@Autowired
	private BoardRepository repository;

	@GetMapping("/boards")
	public List<Board> all(@RequestParam(required = false, defaultValue = "") String title,
			@RequestParam(required = false, defaultValue = "") String content) {

		if (StringUtils.isEmpty(title) && StringUtils.isEmpty(content)) {
			return repository.findAll();
		} else {
			return repository.findByTitleOrContent(title, content);
		}
	}

	@PostMapping("/boards")
	public Board newBoard(@RequestBody Board newBoard) {
		return repository.save(newBoard);
	}

	// Single item
	@GetMapping("/boards/{id}")
	public Board one(@PathVariable Long id) {
		return repository.findById(id).orElse(null);
	}

	@PutMapping("/boards/{id}")
	public Board replaceBoard(@RequestBody Board newBoard, @PathVariable Long id) {

		return repository.findById(id).map(board -> {
			board.setTitle(newBoard.getTitle());
			board.setContent(newBoard.getContent());
			return repository.save(board);
		}).orElseGet(() -> {
			newBoard.setId(id);
			return repository.save(newBoard);
		});
	}

	@DeleteMapping("/boards/{id}")
	public void deleteBoard(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
