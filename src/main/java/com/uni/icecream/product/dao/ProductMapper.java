package com.uni.icecream.product.dao;

import com.uni.icecream.common.paging.SelectCriteria;
import com.uni.icecream.product.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductDto selectProduct(String productCode);

    List<ProductDto> selectProductListAboutMeal();

    List<ProductDto> selectProductListAboutDessert();

    List<ProductDto> selectProductListAboutBeverage();


    int insertProduct(ProductDto product);

    int updateProduct(ProductDto product);

    List<ProductDto> productListWithSearchValue(String search);

    ProductDto selectProductForAdmin(String productCode);

    int selectProductTotal();

    List<ProductDto> selectProductListWithPaging(SelectCriteria selectCriteria);

    int selectProductTotalForAdmin();

    List<ProductDto> selectProductListWithPagingForAdmin(SelectCriteria selectCriteria);

    int deleteProduct(long productCode);
}
