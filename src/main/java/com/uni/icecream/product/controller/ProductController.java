package com.uni.icecream.product.controller;

import com.uni.icecream.common.ResponseDto;
import com.uni.icecream.common.paging.Pagenation;
import com.uni.icecream.common.paging.ResponseDtoWithPaging;
import com.uni.icecream.common.paging.SelectCriteria;
import com.uni.icecream.product.dto.ProductDto;
import com.uni.icecream.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /*제품 목록 조회*/
    @GetMapping("/products")
    public ResponseEntity<ResponseDto> selectProductListWithPaging(@RequestParam(name="offset", defaultValue="1") String offset) {

        log.info("[ProductController] selectProductListWithPaging : " + offset);

        int totalCount = productService.selectProductTotal();
        int limit = 10;
        int buttonAmount = 5;
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(Integer.parseInt(offset), totalCount, limit, buttonAmount);;

        log.info("[ProductController] selectCriteria : " + selectCriteria);

        ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
        responseDtoWithPaging.setPageInfo(selectCriteria);
        responseDtoWithPaging.setData(productService.selectProductListWithPaging(selectCriteria));

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "제품 목록 조회 성공", responseDtoWithPaging));
    }
    /*관리자 제품 목록 조회*/
    @GetMapping("/productsicecream-management")
    public ResponseEntity<ResponseDto> selectProductListWithPagingForAdmin(@RequestParam(name="offset", defaultValue="1") String offset) {

        log.info("[ProductController] selectProductListWithPagingForAdmin : " + offset);

        int totalCount = productService.selectProductTotalForAdmin();
        int limit = 10;
        int buttonAmount = 5;
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(Integer.parseInt(offset), totalCount, limit, buttonAmount);;

        log.info("[ProductController] selectCriteria : " + selectCriteria);

        ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
        responseDtoWithPaging.setPageInfo(selectCriteria);
        responseDtoWithPaging.setData(productService.selectProductListWithPagingForAdmin(selectCriteria));

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "관리자 제품 목록 조회 성공", responseDtoWithPaging));
    }
    /*관리자 제품 상세정보 조회*/
    @GetMapping("/productsicecream-management/{productCode}")
    public ResponseEntity<ResponseDto> selectProductDetailForAdmin(@PathVariable String productCode) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "관리자 제품 상세정보 조회 성공",  productService.selectProductForAdmin(productCode)));
    }

//    @GetMapping("/products/meals")
//    public ResponseEntity<ResponseDto> selectProductListAboutMeal() {
//
//        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "조회 성공",  productService.selectProductListAboutMeal()));
//    }
//
//    @GetMapping("/products/dessert")
//    public ResponseEntity<ResponseDto> selectProductListAboutDessert() {
//
//        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "조회 성공",  productService.selectProductListAboutDessert()));
//    }
//
//    @GetMapping("/products/beverage")
//    public ResponseEntity<ResponseDto> selectProductListAboutBeverage() {
//
//        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "조회 성공",  productService.selectProductListAboutBeverage()));
//    }
//
//    @GetMapping("/products/search")
//    public ResponseEntity<ResponseDto> selectSearchList(@RequestParam(name="s", defaultValue="all") String search) {
//
//        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "조회 성공",  productService.selectSearchProductList(search)));
//    }

    /*제품 상세정보 조회*/
    @GetMapping("/products/{productCode}")
    public ResponseEntity<ResponseDto> selectProductDetail(@PathVariable String productCode) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "제품 상세정보 조회 성공",  productService.selectProduct(productCode)));
    }

    /*관리자 제품 추가*/
    @PostMapping(value = "/productsicecream-management")
    public ResponseEntity<ResponseDto> insertProduct(@ModelAttribute ProductDto productDto) {
        log.info("[ProductController] PostMapping productDto : " + productDto);
        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "관리자 제품 추가 성공",  productService.insertProduct(productDto)));
    }

    /*관리자 제품 수정*/
    @PutMapping(value = "/productsicecream-management")
    public ResponseEntity<ResponseDto> updateProduct(@ModelAttribute ProductDto productDto) {
        log.info("[ProductController]PutMapping productDto : " + productDto);

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "관리자 제품 수정 성공",  productService.updateProduct(productDto)));
    }

    /*관리자 제품 삭제*/
    @DeleteMapping(value = "/productsicecream-management/{productCode}")
    public ResponseEntity<ResponseDto> deleteProduct(@PathVariable long productCode) {
        log.info("[ProductController]DeleteMapping productDto : " + productCode);

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "관리자 제품 삭제 성공",  productService.deleteProduct(productCode)));
    }

}
