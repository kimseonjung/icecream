package com.uni.icecream.product.dao;

import com.uni.icecream.common.paging.SelectCriteria;
import com.uni.icecream.product.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    /*제품 상세정보 조회*/
    ProductDto selectProduct(String productCode);

    List<ProductDto> selectProductListAboutMeal();

    List<ProductDto> selectProductListAboutDessert();

    List<ProductDto> selectProductListAboutBeverage();

    /*관리자 제품 추가*/
    int insertProduct(ProductDto product);

    /*관리자 제품 수정*/
    int updateProduct(ProductDto product);

    List<ProductDto> productListWithSearchValue(String search);

    /*관리자 제품 상세정보 조회*/
    ProductDto selectProductForAdmin(String productCode);

    /*제품 목록 조회*/
    int selectProductTotal();

    /*제품 목록 조회 페이징*/
    List<ProductDto> selectProductListWithPaging(SelectCriteria selectCriteria);

    /*관리자 제품 목록 조회*/
    int selectProductTotalForAdmin();

    /*관리자 제품 목록 조회 페이징*/
    List<ProductDto> selectProductListWithPagingForAdmin(SelectCriteria selectCriteria);

    /*관리자 제품 삭제*/
    int deleteProduct(long productCode);
}
