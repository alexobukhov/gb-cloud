import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.gb.products.controller.ProductController;
import ru.gb.products.model.Product;
import ru.gb.products.service.ProductService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    private ProductController productController;

    @Before
    public void setUp() {
        ProductService mockProductService = Mockito.mock(ProductService.class);
        Date date = new Date(LocalDate.now().toEpochDay());
        Product product1 = new Product(0, "Test1", 13, date);
        Product product2 = new Product(1, "Test2", 13, date);
        Product product3 = new Product(2, "Test3", 13, date);
        List<Product> products = Arrays.asList(product1, product2, product3);
        Mockito.when(mockProductService.getProducts());
    }

    @Test
    public void getProductsTest() throws Exception {
        List<Product> actualProducts = productController.getProducts();
        assert(actualProducts != null);
    }
}
