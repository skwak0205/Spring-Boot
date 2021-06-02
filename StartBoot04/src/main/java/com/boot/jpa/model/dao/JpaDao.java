package com.boot.jpa.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.jpa.model.dto.JpaDto;

public interface JpaDao extends JpaRepository<JpaDto, Integer> { // T : type, ID: primary key로 지정해 준 column의 타입
	public List<JpaDto> findAll(Sort sort);

	public JpaDto findByMyno(int myno); // Myno는 @Id 연결되어 있음

	public JpaDto save(JpaDto dto);

	public JpaDto saveAndFlush(JpaDto dto);

	@Transactional // 필수!!!
	public void deleteByMyno(int myno);
}
