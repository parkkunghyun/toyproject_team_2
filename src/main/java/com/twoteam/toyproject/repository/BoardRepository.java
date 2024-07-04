package com.twoteam.toyproject.repository;
import com.twoteam.toyproject.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    // 추가적인 메서드가 필요하면 여기에 추가할 수 있음
}
