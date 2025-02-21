package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.AddCart;
import com.example.entity.Customer;
import com.example.repo.AddCartRepo;
import com.example.repo.CustomerRepo;

@Service
public class AddCartServiceImpl {

	@Autowired
	private AddCartRepo addCartRepo;

	@Autowired
	private CustomerRepo customerRepo;
	
	public List<AddCart> getProducts(String username) {
		List<AddCart> byCustomerUsername = addCartRepo.findByCustomerUsername(username);
		System.out.println("Cart items for user: " + username + " -> " + byCustomerUsername);
		return byCustomerUsername;
	}

	/*
	 * public List<AddCart> getAllProducts(String username) {
	 * 
	 * List<AddCart> byCustomerUsername =
	 * addCartRepo.findByCustomerUsername(username);
	 * System.out.println("Cart items for user: " + username + " -> " +
	 * byCustomerUsername); return byCustomerUsername;
	 * 
	 * Customer customer = customerRepo.findByUsername(username);
	 * System.out.println("Cart items for user: " + username + " -> " + customer);
	 * return addCartRepo.findByCustomer(customer); }
	 */

	public boolean deleteUserBySrNo(Long srNo) {
		addCartRepo.deleteById(srNo);
		return true;
	}

	public void saveAnarkali1(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Anarkali Set");
			anarkali1.setPrice(314.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveAnarkali2(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Crepe Anarkali Set");
			anarkali1.setPrice(429.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveAnarkali3(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Anarkali Set");
			anarkali1.setPrice(623.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveAnarkali4(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Anarkali Set");
			anarkali1.setPrice(899.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveAnarkali5(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Cotton Anarkali Set");
			anarkali1.setPrice(532.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveAnarkali6(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Anarkali Set");
			anarkali1.setPrice(490.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}
	
	public void saveAnarkaliDupatta1(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Anarkali Set");
			anarkali1.setPrice(540.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}
	
	public void saveAnarkaliDupatta2(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Crepe Anarkali Set");
			anarkali1.setPrice(366.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveAnarkaliDupatta3(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Cotton Anarkali Set");
			anarkali1.setPrice(580.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveAnarkaliDupatta4(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Anarkali Set");
			anarkali1.setPrice(699.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveAnarkaliDupatta5(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Organza Anarkali Set");
			anarkali1.setPrice(532.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveAnarkaliDupatta6(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Party Wear Anarkali Set");
			anarkali1.setPrice(666.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveAnarkaliDupatta7(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Organza Anarkali Set");
			anarkali1.setPrice(670.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveAnarkaliDupatta8(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Party Wear Anarkali Set");
			anarkali1.setPrice(780.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}
	
	public void saveCordSet1(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Rayon Cord Set");
			anarkali1.setPrice(365.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}
	
	public void saveCordSet2(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Crepe Cord Set");
			anarkali1.setPrice(299.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveCordSet3(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Cotton Cord Set");
			anarkali1.setPrice(319.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveCordSet4(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Cord Set");
			anarkali1.setPrice(423.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveCordSet5(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Khadi Cotton Cord Set");
			anarkali1.setPrice(308.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveCordSet6(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Cotton Cord Set");
			anarkali1.setPrice(408.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}
	
	public void saveKurtaDupatta1(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Rayon Kurti With Dupatta");
			anarkali1.setPrice(365.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveKurtaDupatta2(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Crepe Kurti With Dupatta");
			anarkali1.setPrice(299.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveKurtaDupatta3(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Cotton Kurti Set");
			anarkali1.setPrice(319.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveKurtaDupatta4(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Kurti With Dupatta");
			anarkali1.setPrice(423.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}
	
	public void saveKurtaDupatta5(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Khadi Cotton Set");
			anarkali1.setPrice(308.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveKurtaDupatta6(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Cotton Dupatta Set");
			anarkali1.setPrice(408.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}
	
	public void saveKurtaSet1(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Rayon Kurti With Plazzo");
			anarkali1.setPrice(365.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveKurtaSet2(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Crepe Plazzo Set");
			anarkali1.setPrice(299.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveKurtaSet3(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Cotton Kurti With Plazzo");
			anarkali1.setPrice(319.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveKurtaSet4(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Cotton Kurti With Plazzo");
			anarkali1.setPrice(423.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveKurtaSet5(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Khadi Cotton Kurti Set");
			anarkali1.setPrice(365.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public void saveKurtaSet6(String username, AddCart addCart) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null) {
			AddCart anarkali1 = new AddCart();
			anarkali1.setName("Woman's Cotton Kurta Set");
			anarkali1.setPrice(365.00);
			anarkali1.setCustomer(customer); // Associate this cart item with the user
			addCartRepo.save(anarkali1);
		} else {
			throw new RuntimeException("User not found");
		}
	}
}