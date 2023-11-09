/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.project_lp2_gp2.infrastructure.controller;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import upeu.edu.pe.project_lp2_gp2.app.service.CartService;

/**
 *
 * @author LAB-2
 */
@Controller
@RequestMapping("/user/cart")
public class CartController {

    private final CartService cartService;
    private final Logger log = LoggerFactory.getLogger(CartController.class);

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("add-product")
    public String addProductCart(@RequestParam Integer quantity, @RequestParam Integer idProduct, @RequestParam String nameProduct, @RequestParam BigDecimal price) {
        cartService.addItemCart(idProduct, nameProduct, quantity, price);
        showCart();
        return "redirect:/home";
    }
    //ver en consola
    private void showCart(){
        cartService.getItemCarts().forEach(itemCart -> log.info("Item cart {}",itemCart));
    }
     @GetMapping("/get-cart")
    public String getCart(Model model){
       showCart();
       model.addAttribute("cart", cartService.getItemCarts());
       model.addAttribute("total", cartService.getTotalCart());
       return "user/cart/cart";
    }
    @GetMapping("/delete-item-cart/{id}")
    public String deleteItemCart(@PathVariable Integer id){
        cartService.removeItemCart(id);
        return "redirect:/user/cart/get-cart";
    }
}
