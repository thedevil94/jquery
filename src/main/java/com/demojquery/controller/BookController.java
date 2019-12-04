package com.demojquery.controller;

import com.demojquery.model.Book;
import com.demojquery.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Book> allBooks() {
        return bookService.findAll();
    }

    @GetMapping("/")
    public ModelAndView listBooks(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("allBooks", allBooks());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createFormBook(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Book createBook(@RequestBody Book book){
        return bookService.save(book);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editFormBook(@PathVariable int id){
        Book book = bookService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("book", book);
        return modelAndView;
    }
    @PostMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Book editBook(@PathVariable int id, @RequestBody Book book){
        book.setId(id);
        return bookService.save(book);
    }

   @PostMapping(value = "delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Book deleteBook(@PathVariable int id){
        return bookService.delete(id);
   }
}
