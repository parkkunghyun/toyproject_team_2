package com.twoteam.toyproject.controller;

import com.twoteam.toyproject.Service.MemberService;
import com.twoteam.toyproject.dto.MemberDTO;
import com.twoteam.toyproject.Service.MemberService;
import com.twoteam.toyproject.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String index() {
        return "index"; // 로그인 페이지로 이동
    }

    @GetMapping("/register")
    public String saveForm(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "register"; // 회원가입 페이지로 이동
    }

    @PostMapping("/register")
    public String registerMember(MemberDTO memberDTO, Model model) {
        // 비밀번호 확인 (클라이언트 측 JavaScript에서 처리)

        try {
            memberService.registerMember(memberDTO);
            return "redirect:/";  // 회원가입 성공 후 로그인 페이지로 리다이렉트
        } catch (Exception e) {
            model.addAttribute("errorMessage", "회원가입에 실패했습니다. 다시 시도해주세요.");
            return "register"; // 회원가입 페이지에 오류 메시지를 포함하여 다시 이동
        }
    }
    @PostMapping("/login")
    public String login(@RequestParam String memberEmail, @RequestParam String memberPW, Model model) {
        Member member = memberService.findMemberByEmailAndPassword(memberEmail, memberPW);

        if (member != null) {
            // 로그인 성공
            return "redirect:/board"; // 대시보드 페이지로 리다이렉트
        } else {
            // 로그인 실패
            model.addAttribute("errorMessage", "이메일 또는 비밀번호가 잘못되었습니다.");
            return "index"; // 로그인 페이지에 오류 메시지를 포함하여 다시 이동
        }
    }
    @GetMapping("/board")
    public String board() {
        return "board/board"; // 로그인 성공 후 대시보드 페이지로 이동
    }

}
