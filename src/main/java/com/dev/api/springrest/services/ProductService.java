package com.dev.api.springrest.services;

import com.dev.api.springrest.dtos.ProductDTO;
import com.dev.api.springrest.models.Product;
import com.dev.api.springrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public void saveProduct(ProductDTO productDTO) {
		Product product = new Product();
		productToDTO(productDTO, product);
		productRepository.save(product);
	}

	public void productToDTO(ProductDTO productDTO, Product product){

		product.setName(productDTO.getName());
		product.setUnitaryValue(productDTO.getUnitaryValue());
		product.setDescription(productDTO.getDescription());
		product.setExpirationDate(productDTO.getExpirationDate());
		product.setQuantity(productDTO.getQuantity());

	}

	public Product dtoToProduct(ProductDTO productDTO, Product product){

		productDTO.setName(product.getName());
		productDTO.setUnitaryValue(product.getUnitaryValue());
		productDTO.setDescription(product.getDescription());
		productDTO.setExpirationDate(product.getExpirationDate());
		productDTO.setQuantity(product.getQuantity());

		return product;
	}

	public void deleteProduct(long id){productRepository.deleteById(id);}

	public List<Product> listAll() {return productRepository.findAll();}

	public ProductDTO findOneProduct(Long id){
		Optional<Product> product = productRepository.findById(id);
		Product productOnData;
		ProductDTO productDTO = new ProductDTO();
		if (product.isPresent()){
			productOnData = product.get();
			productToDTO(productDTO, product.get());
		}
		return productDTO;
	}

	public void updateProduct(Long id, ProductDTO productDTO) {
		Optional<Product> product = productRepository.findById(id);
		Product productOnBank = new Product();

		if (product.isPresent()) {
			productOnBank = product.get();
			if (productDTO.getName() != null) {
				productOnBank.setUnitaryValue(productDTO.getUnitaryValue());
			}
			if (productDTO.getDescription() != null) {
				productOnBank.setDescription(productDTO.getDescription());
			}
			if (productDTO.getExpirationDate() != null) {
				productOnBank.setExpirationDate(productDTO.getExpirationDate());
			}
			if (productDTO.getQuantity() != null) {
				productOnBank.setQuantity(productDTO.getQuantity());
			}

			productRepository.save(productOnBank);
		}
	}

}



