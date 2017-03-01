package com.foodplazashubham.dao;
import java.util.List;

import com.foodplazashubham.pojo.Cart;
public interface CartDao
{
	boolean addToCart(Cart c);
	List<Cart> listCart(String customerusername);
	boolean deleteCart(int cartid,String customerusername);
	 boolean clearCart(String customerusername);
}
