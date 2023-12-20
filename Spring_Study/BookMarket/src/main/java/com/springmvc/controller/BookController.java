package com.springmvc.controller;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String requestBookList(Model model){
        List<Book> list = bookService.getAllBookList();
        model.addAttribute("bookList", list);
        return "books"; // books.jsp 호출
    }

    @GetMapping("/all")
    public ModelAndView requestAllBooks(){
        ModelAndView mav = new ModelAndView();
        List<Book> list = bookService.getAllBookList();
        mav.addObject("bookList", list);
        mav.setViewName("books");   // books.jsp
        return mav;
    }

    @GetMapping("/{category}")
    public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model){
        List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
        model.addAttribute("bookList", booksByCategory);
        return "books"; // books.jsp
    }

    @GetMapping("/filter/{bookFilter}")
    public String requestBooksByFilter(@MatrixVariable(pathVar = "bookFilter") Map<String, List<String>> bookFilter, Model model){
        Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
        model.addAttribute("bookList", booksByFilter);
        return "books"; //books.jsp
    }

    @GetMapping("/book")
    public String requestBookById(@RequestParam("id") String bookId, Model model){
        Book bookById =bookService.getBookById(bookId);
        model.addAttribute("book", bookById);
        return "book"; // book.jsp
    }

    @GetMapping("/add")
    public String requestAddBookForm(@ModelAttribute("NewBook") Book book){
        return "addBook"; // addBook.jsp
    }

    @PostMapping("/add")
    public String submitAddNewBook(@ModelAttribute("NewBook") Book book){
        bookService.setNewBook(book);
        return "redirect:/books";   // @RequestMapping("/books")에 맵핑
    }

    @ModelAttribute
    public void addAttribute(Model model){
        model.addAttribute("addTitle", "신규 도서 등록");
    }
}
