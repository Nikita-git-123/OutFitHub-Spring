package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.AddCart;
import com.example.repo.AddCartRepo;

@Service
public class AddCartServiceImpl {

	@Autowired
	private AddCartRepo addCartRepo;
	
	 public List<AddCart> getAllProducts() {
	        return addCartRepo.findAll();
	 }
	 
	 public boolean deleteUserBySrNo(Long srNo) {
		 addCartRepo.deleteById(srNo);
		 return true;
	}

	public void saveAnarkali1(AddCart user) {
		AddCart anarkali1 = new AddCart();
		anarkali1.setName("Woman's Anarkali Set");
		anarkali1.setPrice(314.00);
		addCartRepo.save(anarkali1);
	} 
	
	public void saveAnarkali2(AddCart user) {
		AddCart anarkali2 = new AddCart();
		anarkali2.setName(" Woman's Crepe Anarkali Set");
		anarkali2.setPrice(429.00);
		addCartRepo.save(anarkali2);
	}
	
	public void saveAnarkali3(AddCart user) {
		AddCart anarkali3 = new AddCart();
		anarkali3.setName("Woman's Anarkali Set");
		anarkali3.setPrice(623.00);
		addCartRepo.save(anarkali3);
	}
	
	public void saveAnarkali4(AddCart user) {
		AddCart anarkali4 = new AddCart();
		anarkali4.setName("Woman's Anarkali Set");
		anarkali4.setPrice(899.00);
		addCartRepo.save(anarkali4);
	}
	
	public void saveAnarkali5(AddCart user) {
		AddCart anarkali5 = new AddCart();
		anarkali5.setName("Woman's Cotton Anarkali Set");
		anarkali5.setPrice(532.00);
		addCartRepo.save(anarkali5);
	}
	
	public void saveAnarkali6(AddCart user) {
		AddCart anarkali6 = new AddCart();
		anarkali6.setName("Woman's Anarkali Set");
		anarkali6.setPrice(490.00);
		addCartRepo.save(anarkali6);
	}


	public void saveAnarkaliDupatta1(AddCart user) {
		AddCart anarkaliDup1 = new AddCart();
		anarkaliDup1.setName("Woman's Anarkali Set");
		anarkaliDup1.setPrice(540.00);
		addCartRepo.save(anarkaliDup1);
	}
	
	public void saveAnarkaliDupatta2(AddCart user) {
		AddCart anarkaliDup2 = new AddCart();
		anarkaliDup2.setName("Woman's Crepe Anarkali Set");
		anarkaliDup2.setPrice(366.00);
		addCartRepo.save(anarkaliDup2);
	}
	
	public void saveAnarkaliDupatta3(AddCart user) {
		AddCart anarkaliDup3 = new AddCart();
		anarkaliDup3.setName("Woman's Cotton Anarkali Set");
		anarkaliDup3.setPrice(580.00);
		addCartRepo.save(anarkaliDup3);
	}
	
	public void saveAnarkaliDupatta4(AddCart user) {
		AddCart anarkaliDup4 = new AddCart();
		anarkaliDup4.setName("Woman's Anarkali Set");
		anarkaliDup4.setPrice(699.00);
		addCartRepo.save(anarkaliDup4);
	}
	
	public void saveAnarkaliDupatta5(AddCart user) {
		AddCart anarkaliDup5 = new AddCart();
		anarkaliDup5.setName("Woman's Organza Anarkali Set");
		anarkaliDup5.setPrice(532.00);
		addCartRepo.save(anarkaliDup5);
	}
	
	public void saveAnarkaliDupatta6(AddCart user) {
		AddCart anarkaliDup6 = new AddCart();
		anarkaliDup6.setName("Woman's Party Wear Anarkali Set");
		anarkaliDup6.setPrice(666.00);
		addCartRepo.save(anarkaliDup6);
	}
	
	public void saveAnarkaliDupatta7(AddCart user) {
		AddCart anarkaliDup7 = new AddCart();
		anarkaliDup7.setName("Woman's Organza Anarkali Set");
		anarkaliDup7.setPrice(670.00);
		addCartRepo.save(anarkaliDup7);
	}
	
	public void saveAnarkaliDupatta8(AddCart user) {
		AddCart anarkaliDup8 = new AddCart();
		anarkaliDup8.setName("Woman's Party Wear Anarkali Set");
		anarkaliDup8.setPrice(780.00);
		addCartRepo.save(anarkaliDup8);
	}
	
	
	public void saveCordSet1(AddCart user) {
		AddCart cordSet1 = new AddCart();
		cordSet1.setName("Woman's Rayon Cord Set");
		cordSet1.setPrice(365.00);
		addCartRepo.save(cordSet1);
	}
	
	public void saveCordSet2(AddCart user) {
		AddCart cordSet2 = new AddCart();
		cordSet2.setName("Woman's Crepe Cord Set");
		cordSet2.setPrice(299.00);
		addCartRepo.save(cordSet2);
	}
	
	public void saveCordSet3(AddCart user) {
		AddCart cordSet3 = new AddCart();
		cordSet3.setName("Woman's Cotton Cord Set");
		cordSet3.setPrice(319.00);
		addCartRepo.save(cordSet3);
	}
	
	public void saveCordSet4(AddCart user) {
		AddCart cordSet4 = new AddCart();
		cordSet4.setName("Woman's Cord Set");
		cordSet4.setPrice(423.00);
		addCartRepo.save(cordSet4);
	}
	
	public void saveCordSet5(AddCart user) {
		AddCart cordSet5 = new AddCart();
		cordSet5.setName("Woman's Khadi Cotton Cord Set");
		cordSet5.setPrice(308.00);
		addCartRepo.save(cordSet5);
	}
	
	public void saveCordSet6(AddCart user) {
		AddCart cordSet6 = new AddCart();
		cordSet6.setName("Woman's Cotton Cord Set");
		cordSet6.setPrice(408.00);
		addCartRepo.save(cordSet6);
	}

    
	public void saveKurtaDupatta1(AddCart user) {
		AddCart kurtaDup1 = new AddCart();
		kurtaDup1.setName("Woman's Rayon Kurti With Dupatta");
		kurtaDup1.setPrice(365.00);
		addCartRepo.save(kurtaDup1);
	}
	
	public void saveKurtaDupatta2(AddCart user) {
		AddCart kurtaDup2 = new AddCart();
		kurtaDup2.setName("Woman's Crepe Dupatta Set");
		kurtaDup2.setPrice(299.00);
		addCartRepo.save(kurtaDup2);
	}
	
	public void saveKurtaDupatta3(AddCart user) {
		AddCart kurtaDup3 = new AddCart();
		kurtaDup3.setName("Woman's Cotton Kurti Set");
		kurtaDup3.setPrice(319.00);
		addCartRepo.save(kurtaDup3);
	}
	
	public void saveKurtaDupatta4(AddCart user) {
		AddCart kurtaDup4 = new AddCart();
		kurtaDup4.setName("Woman's Kurti With Dupatta");
		kurtaDup4.setPrice(423.00);
		addCartRepo.save(kurtaDup4);
	}
	
	public void saveKurtaDupatta5(AddCart user) {
		AddCart kurtaDup5 = new AddCart();
		kurtaDup5.setName("Woman's Khadi Cotton Set");
		kurtaDup5.setPrice(308.00);
		addCartRepo.save(kurtaDup5);
	}
	
	public void saveKurtaDupatta6(AddCart user) {
		AddCart kurtaDup6 = new AddCart();
		kurtaDup6.setName("Woman's Cotton Dupatta Set");
		kurtaDup6.setPrice(408.00);
		addCartRepo.save(kurtaDup6);
	}
	
	
	public void saveKurtaSet1(AddCart user) {
		AddCart kurta1 = new AddCart();
		kurta1.setName("Woman's Rayon Kurti With Plazzo");
		kurta1.setPrice(365.00);
		addCartRepo.save(kurta1);
	}
	
	public void saveKurtaSet2(AddCart user) {
		AddCart kurta2 = new AddCart();
		kurta2.setName("Woman's Crepe Palazzo Set");
		kurta2.setPrice(299.00);
		addCartRepo.save(kurta2);
	}
	
	public void saveKurtaSet3(AddCart user) {
		AddCart kurta3 = new AddCart();
		kurta3.setName("Woman's Cotton Kurti With Plazzo");
		kurta3.setPrice(319.00);
		addCartRepo.save(kurta3);
	}
	
	public void saveKurtaSet4(AddCart user) {
		AddCart kurta4 = new AddCart();
		kurta4.setName("Woman's Cotton Kurti With Plazzo");
		kurta4.setPrice(423.00);
		addCartRepo.save(kurta4);
	}
	
	public void saveKurtaSet5(AddCart user) {
		AddCart kurta5 = new AddCart();
		kurta5.setName("Woman's Khadi Cotton Kurti Set");
		kurta5.setPrice(308.00);
		addCartRepo.save(kurta5);
	}
	
	public void saveKurtaSet6(AddCart user) {
		AddCart kurta6 = new AddCart();
		kurta6.setName("Woman's Cotton Kurta Set");
		kurta6.setPrice(408.00);
		addCartRepo.save(kurta6);
	}
}
