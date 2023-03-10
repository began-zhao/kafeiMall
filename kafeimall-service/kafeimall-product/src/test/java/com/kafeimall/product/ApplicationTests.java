package com.kafeimall.product;

import com.kafeimall.product.domain.repository.BrandRepository;
import com.kafeimall.product.domain.model.BrandDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: zzg
 * @date: 2023/2/22
 * @Description: zzg
 */
public class ApplicationTests {
    public static void main(String[] args) {

    }

    @Autowired
    private BrandRepository brandRepository;

    @Test
    void getBrands() {
        brandRepository.getById(1L);
    }

    @Test
    void insertBrands() {
        BrandDO brandDO = new BrandDO();
        brandDO.setDescript("1");
        brandDO.setLogo("1");
        brandDO.setFirstLetter("1");
        brandDO.setShowStatus(1);
        brandDO.setName("11");
        brandRepository.save(brandDO);
    }
}
