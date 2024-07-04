package com.twoteam.toyproject.service;

import com.twoteam.toyproject.entity.Board;
import com.twoteam.toyproject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void save(Board board) {
        boardRepository.save(board);
    }
    public Board createNewPost(String title, String content, String memberName) {
        Board newPost = new Board();
        newPost.setTitle(title);
        newPost.setContent(content);
        newPost.setMemberName(memberName);
        return boardRepository.save(newPost);
    }
    // 다른 필요한 기능 추가 가능
}
