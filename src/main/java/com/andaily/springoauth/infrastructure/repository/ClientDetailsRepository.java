package com.andaily.springoauth.infrastructure.repository;

import com.andaily.springoauth.service.dto.ClientDetailsDto;

/**
 * 2023/11/7 15:24
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
public interface ClientDetailsRepository {

    /**
     * 查找默认client
     *
     * @return ClientDetailsDto or null
     */
    ClientDetailsDto findDefaultClientDetails();

    /**
     * 保存
     *
     * @param clientDetailsDto ClientDetailsDto
     * @return id or null
     */
    String saveClientDetails(ClientDetailsDto clientDetailsDto);

}
