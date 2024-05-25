package com.hectordevelopers.productservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hectordevelopers.productservices.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServicesApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Container
	static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:13-alpine");

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry registry){
		registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
		registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
		registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
	}


	@Test
	void shouldCreateProduct() throws Exception {
		ProductDto productDto = getProductDto();
		String json = objectMapper.writeValueAsString(productDto);
//		System.out.println(json);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated());
	}

	private ProductDto getProductDto() {
		return ProductDto.builder()
				.name("Nokia")
				.description("This is a Nokia product.")
				.price(BigDecimal.valueOf(19.99))
				.build();
	}
}
