package com.boot.tutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.tutorial.model.Board;
import com.boot.tutorial.model.User;
import com.boot.tutorial.repository.BoardRepository;
import com.boot.tutorial.repository.UserRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private UserRepository userRepository;

	public Board save(String username, Board board) {
		User user = userRepository.findByUsername(username);
		board.setUser(user);

		return boardRepository.save(board);
	}
}
