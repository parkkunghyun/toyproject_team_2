package com.twoteam.toyproject.controller;

import com.twoteam.toyproject.entity.Board;
import com.twoteam.toyproject.entity.Member;
import com.twoteam.toyproject.service.BoardService;
import com.twoteam.toyproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public String board(HttpSession session, Model model) {
        Member loggedInUser = (Member) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("memberName", loggedInUser.getMemberName());
            return "board/board"; // 로그인 성공 후 대시보드 페이지로 이동
        } else {
            return "redirect:/"; // 로그인 상태가 아니면 로그인 페이지로 리다이렉트
        }
    }
    // 아래부터는 다시 코딩해서 하기
//    @GetMapping("/board/write")
//    public String showWriteForm(HttpSession session, Model model) {
//        Member loggedInUser = (Member) session.getAttribute("loggedInUser");
//        if (loggedInUser != null) {
//            model.addAttribute("memberName", loggedInUser.getMemberName());
//            return "board/write";
//        } else {
//            return "redirect:/"; // 로그인 상태가 아니면 로그인 페이지로 리다이렉트
//        }
//    }
//
//    @PostMapping("/board/create")
//    public String createPost(@RequestParam String title, @RequestParam String content, HttpSession session) {
//        Member loggedInUser = (Member) session.getAttribute("loggedInUser");
//        if (loggedInUser != null) {
//            // 게시글 저장 로직
//            Board newPost = new Board();
//            newPost.setTitle(title);
//            newPost.setContent(content);
//            newPost.setMemberName(loggedInUser.getMemberName());
//            boardService.save(newPost);
//            return "redirect:/board";
//        } else {
//            return "redirect:/"; // 로그인 상태가 아니면 로그인 페이지로 리다이렉트
//        }
//    }
}
