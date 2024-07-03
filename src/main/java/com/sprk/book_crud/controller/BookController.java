package com.sprk.book_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sprk.book_crud.entity.Book;
import com.sprk.book_crud.service.BookService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/show-form")
    public String showForm(Model model) {
        model.addAttribute("book", new Book());

        return "book-form";
    }

    @PostMapping("/process-form")
    public String processForm(@Valid @ModelAttribute Book book, BindingResult result,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "book-form";
        } else {

            boolean isInserted = bookService.saveBook(book);
            if (isInserted) {

                redirectAttributes.addFlashAttribute("msg", "Inserted Succesfull");
            }

            return "redirect:/book/show-dashboard";
        }

    }

    @GetMapping("/show-dashboard")
    public String getMethodName(Model model) {

        List<Book> books = bookService.getAllBooks();

        model.addAttribute("books", books);

        return "dashboard";
    }

}
