package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping("/")
    public String listItems(Model model){
        model.addAttribute("items", itemRepository.findAll());
                return "list";
    }

    @GetMapping("/add")
    public String itemForm(Model model){
        model.addAttribute("item", new Item());
        return "itemform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Item item,
                              BindingResult result){
        if(result.hasErrors()){
            return "itemform";
        }
        itemRepository.save(item);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showItem(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("item", itemRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateItem(@PathVariable("id") long id, Model model){
        model.addAttribute("item", itemRepository.findById(id).get());
        return "itemform";
    }

    @RequestMapping("/delete/{id}")
    public String delItem(@PathVariable("id") long id){
        itemRepository.deleteById(id);
        return "redirect:/";
    }
}
