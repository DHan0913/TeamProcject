package himedia.dvd.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.dvd.repositories.vo.CommentVo;
import himedia.dvd.repositories.vo.NoticeVo;
import himedia.dvd.repositories.vo.ProductVo;
import himedia.dvd.repositories.vo.UserVo;
import himedia.dvd.services.ProductService;
import himedia.dvd.services.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    
    private static final int PAGE_SIZE = 15; // 페이지당 항목 수를 상수로 정의

    @GetMapping({ "/", "/main" })
    public String main(@RequestParam(defaultValue = "1") int page, Model model) {
        if (page < 1) {
            page = 1; // 페이지가 1보다 작을 경우 기본값으로 설정
        }
        
        int start = (page - 1) * PAGE_SIZE + 1;
        int end = page * PAGE_SIZE;

        List<ProductVo> products = productService.getProductsByPage(start, end);
        int totalProducts = productService.getProductCount();
        int totalPages = (int) Math.ceil((double) totalProducts / PAGE_SIZE);

        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "home";
    }

    @GetMapping("/products/search")
    public String search(
            @RequestParam("filter") String filter, 
            @RequestParam(value = "keyword", defaultValue = "") String keyword, 
            @RequestParam(value = "genre", defaultValue = "") String genre, 
            Model model) {
        
        List<ProductVo> products;
        
        if ("productName".equals(filter)) {
            products = productService.searchProductsByName(keyword);
        } else if ("genre".equals(filter)) {
            products = productService.searchProductsByGenre(genre);
        } else {
            // filter 값이 잘못된 경우를 처리하는 로직 추가
            products = List.of(); // 빈 리스트 반환
        }
        
        model.addAttribute("products", products);
        return "home";
    }
    
    //최근 공지사항 띄우기
    @ModelAttribute("latestNotice")
    public NoticeVo getLatestNotice() {
        return userService.getLatestNotice();
    }
    
    //공지사항 리스트 이동
    @GetMapping("/board/noticelist")
    public String noticeList(Model model) {
        List<NoticeVo> notices = userService.getAllNotices();
        model.addAttribute("notices", notices);
        return "board/noticelist";
    }
    
    //공지사항 상세조회
    @GetMapping("/board/noticelist/{id}")
    public String getNoticeDetail(@PathVariable("id") Long id, Model model, HttpSession session) {
        NoticeVo notice = userService.getNoticedetail(id);
        List<CommentVo> comments = userService.getComment(id);
        
        for (CommentVo comment : comments) {
            List<CommentVo> replies = userService.getReplies(comment.getId());
            comment.setReplies(replies);
        }
        
        model.addAttribute("notice", notice);
        model.addAttribute("comments", comments);
        return "board/noticedetail";
    }
    
    //댓글 추가
    @PostMapping("/board/noticelist/{id}/addComment")
    public String addComment(@PathVariable("id") Long noticeId, 
                             @RequestParam("comment") String comment, 
                             @RequestParam(value = "secret", required = false, defaultValue = "N") String secret, 
                             HttpSession session) {
        UserVo authUser = (UserVo) session.getAttribute("authUser");
        if (authUser != null) {
            CommentVo commentVo = new CommentVo();
            commentVo.setNoticeId(noticeId);
            commentVo.setUserId(authUser.getUserNo());
            commentVo.setContent(comment);
            commentVo.setSecret(secret); 
            commentVo.setCreatedDate(new Date());  
            userService.addComment(commentVo);
        }
        return "redirect:/board/noticelist/" + noticeId;
    }
    
    //대댓글 추가
    @PostMapping("/board/noticelist/{id}/addReply")
    public String addReply(@PathVariable("id") Long noticeId, 
                           @RequestParam("reply") String reply, 
                           @RequestParam("commentId") Long commentId,
                           @RequestParam(value = "secretReply", required = false, defaultValue = "N") String secretReply,
                           HttpSession session) {
        UserVo authUser = (UserVo) session.getAttribute("authUser");
        if (authUser != null) {
            CommentVo commentVo = new CommentVo();
            commentVo.setNoticeId(noticeId);
            commentVo.setUserId(authUser.getUserNo());
            commentVo.setContent(reply);
            commentVo.setCommentId(commentId);
            commentVo.setSecret(secretReply);
            commentVo.setCreatedDate(new Date());
            userService.addReply(commentVo);
        }
        return "redirect:/board/noticelist/" + noticeId;
    }
    
    // 댓글 수정
    @PostMapping("/board/noticelist/updateComment")
    public String updateComment(@RequestParam("id") Long id,
                                @RequestParam("content") String content,
                                @RequestParam("secret") String secret,
                                HttpSession session) {
        UserVo authUser = (UserVo) session.getAttribute("authUser");
        if (authUser != null) {
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            params.put("content", content);
            params.put("secret", secret);
            userService.updateComment(params);
        }
        return "redirect:/board/noticelist/" + id;
    }
    
    //대댓글 수정
    @PostMapping("/board/noticelist/updateReply")
    public String updateReply(@RequestParam("id") Long id,
                              @RequestParam("content") String content,
                              @RequestParam("secret") String secret,
                              HttpSession session) {
        UserVo authUser = (UserVo) session.getAttribute("authUser");
        if (authUser != null) {
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            params.put("content", content);
            params.put("secret", secret);
            userService.updateReply(params);
        }
        return "redirect:/board/noticelist/" + id;
    }
    
    // 댓글 삭제
    @PostMapping("/board/noticelist/deleteComment")
    public String deleteComment(@RequestParam("id") Long id, HttpSession session) {
        UserVo authUser = (UserVo) session.getAttribute("authUser");
        if (authUser != null) {
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            params.put("secret", "D");
            userService.deleteComment(params);
        }
        return "redirect:/board/noticelist/" + id;
    }

    // 대댓글 삭제
    @PostMapping("/board/noticelist/deleteReply")
    public String deleteReply(@RequestParam("id") Long id, HttpSession session) {
        UserVo authUser = (UserVo) session.getAttribute("authUser");
        if (authUser != null) {
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            params.put("secret", "D");
            userService.deleteReply(params);
        }
        return "redirect:/board/noticelist/" + id;
    }
   
}
    
