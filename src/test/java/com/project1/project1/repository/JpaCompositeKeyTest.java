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

//    @Test
//    @Transactional
//    @Rollback(false)
//    public void CategoryRepositoryTest() {
//        Brand brand = new Brand();
//        brand.setBrandName("삼성");
//        em.persist(brand);
//
//        Category category = new Category();
//        category.setCategoryType(Category.CategoryType.Phone);
//        em.persist(category);
//
//        Product product = new Product();
//        product.setBrandId(brand.getBrandId());
//        product.setCategoryId(category.getCategoryId());
//        product.setProductId(10024L);
//        product.setName("Galaxy S38");
//        em.persist(product);
//    }

    @Test
    @Transactional
    public void ProductSearchTest() {
        ProductId productId = new ProductId();
        productId.setProductId(10024L);
        productId.setCategoryId(1L);
        productId.setBrandId(1L);
        Product product=em.find(Product.class, productId);
        System.out.println("테스트 결과"+product.getCategory().getCategoryType());
    }

    @Test
    @Transactional
    @Rollback(false)
    public void JpaEmbeddableInsertTest(){
        Brand brand = new Brand();
        brand.setBrandName("삼성");
        em.persist(brand);

        Category category = new Category();
        category.setCategoryType(Category.CategoryType.Phone);
        em.persist(category);

        ProductId productId = new ProductId(brand.getBrandId(),category.getCategoryId(),10022L);
        Product product = new Product();
        product.setId(productId);
        product.setName("Galaxy S07");
        em.persist(product);
    }

}










