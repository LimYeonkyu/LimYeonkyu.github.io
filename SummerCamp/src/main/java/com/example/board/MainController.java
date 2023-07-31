package com.example.board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @Autowired
    BoardDAO boardDAO;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("list", boardDAO.getBoardList());
        return "index";
    }

    @RequestMapping(value = "/topic/{seq}", method = RequestMethod.GET)
    public String topic(@PathVariable("seq") int seq, Model model) {
        BoardVO boardVO = boardDAO.getBoard(seq);
        model.addAttribute("b", boardVO);
        return "topic";
    }

    @RequestMapping(value = "/write")
    public String write() {
        return "write";
    }
    @RequestMapping(value = "/guidelines")
    public String guidelines() {
        return "guidelines";
    }


}
