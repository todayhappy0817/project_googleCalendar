package com.project1.project1.repository;

import com.project1.project1.domain.Brand;
import com.project1.project1.domain.Category;
import com.project1.project1.domain.Product;
import com.project1.project1.domain.ProductId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
public class JpaCompositeKeyTest {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;
    @PersistenceContext
    private EntityManager em;

    @Test
    @Transactional
    @Rollback(false)
    public void CategoryRepositoryTest() {
        Brand brand = new Brand();
        brand.setBrandName("삼성");
        em.persist(brand);

        Category category = new Category();
        category.setCategoryType(Category.CategoryType.Phone);
        em.persist(category);

        Product product = new Product();
        product.setBrandId(brand.getBrandId());
        product.setCategoryId(category.getCategoryId());
        product.setProductId(10025L);
        product.setName("Galaxy S34");
        em.persist(product);
    }

    @Test
    public void ProductSearchTest() {
        ProductId productId = new ProductId();
        productId.setProductId(10025L);
        productId.setCategoryId(2L);
        productId.setBrandId(2L);
        Product product=em.find(Product.class, productId);
        System.out.println("테스트 결과"+product.getCategory().getCategoryType());
        //productRepository.findById(productId);
    }




}










