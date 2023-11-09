package com.andaily.springoauth.infrastructure.repository;

import com.andaily.springoauth.ContextTest;
import com.andaily.springoauth.service.dto.ClientDetailsDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 2023/11/7 15:39
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
class ClientDetailsRepositoryFileTest extends ContextTest {


    @Autowired
    private ClientDetailsRepositoryFile repositoryFile;


    @Test
    void saveClientDetails() {

        ClientDetailsDto dto = new ClientDetailsDto();
        dto.setClientId("client_id");
        dto.setClientSecret("client_secret");
        dto.setSupportPkce(true);
        dto.setRedirectUris("https://...");
        dto.setAuthorizationGrantTypes("authorization_code");

        repositoryFile.saveClientDetails(dto);

        ClientDetailsDto clientDetails = repositoryFile.findDefaultClientDetails();
        assertNotNull(clientDetails);
        assertNotNull(clientDetails.getClientId());

    }

}