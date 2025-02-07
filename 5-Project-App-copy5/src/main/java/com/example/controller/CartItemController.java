package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.CartItem;
import com.example.entity.Product;
import com.example.repo.CartItemRepository;
import com.example.repo.ProductRepository;

@Controller
public class CartItemController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartItemRepository cartRepository;
	
	 // Add product to cart
    @PostMapping("/addToCart")
    @ResponseBody
    public String addToCart(@RequestParam Long productId) {
        Product product = productRepository.findById(productId).orElse(null);

        if (product != null) {
            CartItem cart = cartRepository.findById(1L).orElse(new CartItem());
            cart.addProduct(product);
            cartRepository.save(cart);
        }

        return "redirect:/viewCart";
    }

 // View cart page
    @ResponseBody
    @GetMapping("/viewCart")
    public String viewCart(Model model) {
        CartItem cart = cartRepository.findById(1L).orElse(new CartItem());
        model.addAttribute("cart", cart);
        return "cart";
    }
    
 // Remove product from cart
    @PostMapping("/removeFromCart")
    @ResponseBody
    public String removeFromCart(@RequestParam Long productId) {
        CartItem cart = cartRepository.findById(1L).orElse(new CartItem());
        if (cart != null) {
            cart.removeProduct(productId);
            cartRepository.save(cart);
        }
        return "redirect:/viewCart";
    }
    
    
    
	/*
	 * @GetMapping("/cart") public String viewCart(@RequestParam("userId") Long
	 * userId, Model model) { model.addAttribute("cartItems",
	 * cartItemService.getCartItems(userId)); model.addAttribute("userId", userId);
	 * // Pass the userId for form submission return "Code"; // This view displays
	 * the cart }
	 * 
	 * @PostMapping("/addToCart") public String addToCart(@RequestParam("userId")
	 * Long userId, @RequestParam("productId") Long productId,
	 * 
	 * @RequestParam("productName") String productName, Model model) {
	 * cartItemService.addToCart(userId, productId, productName);
	 * model.addAttribute("cart", new Customer()); return "Cart"; // Redirect to
	 * cart page after adding }
	 * 
	 * @PostMapping("/removeFromCart") public String
	 * removeFromCart(@RequestParam("userId") Long
	 * userId, @RequestParam("productId") Long productId) {
	 * cartItemService.removeFromCart(userId, productId); return "Code"; // Redirect
	 * to cart page after removing }
	 */
	
	

	/*
	 * @GetMapping("/addCart") public String addToCart(@RequestParam Integer
	 * pid, @RequestParam Integer uid, HttpSession session) { CartItem saveCart =
	 * cartItemService.saveCart(pid, uid);
	 * 
	 * if (ObjectUtils.isEmpty(saveCart)) { session.setAttribute("errorMsg",
	 * "Product add to cart failed"); } else { session.setAttribute("succMsg",
	 * "Product added to cart"); } return "redirect:/product/" + pid; }
	 */
}
