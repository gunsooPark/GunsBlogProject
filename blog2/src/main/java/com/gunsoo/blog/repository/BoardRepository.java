package com.gunsoo.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gunsoo.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
