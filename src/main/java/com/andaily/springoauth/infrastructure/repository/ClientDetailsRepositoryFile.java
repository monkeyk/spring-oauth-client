package com.andaily.springoauth.infrastructure.repository;

import com.andaily.springoauth.infrastructure.json.JsonUtils;
import com.andaily.springoauth.service.dto.ClientDetailsDto;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 2023/11/7 15:26
 * <p>
 * 默认存文件
 * <p>
 * TODO:此实现不能满足生产需要，请使用更安全的存储实现（如数据库）
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
@Repository
public class ClientDetailsRepositoryFile implements ClientDetailsRepository {

    private static final Logger LOG = LoggerFactory.getLogger(ClientDetailsRepositoryFile.class);

    /**
     * 存储的文件名
     * 隐藏文件 .xxx
     */
    public static final String CLIENT_DETAILS_FILE = ".client_details.json";

    /**
     * {@inheritDoc}
     */
    @Override
    public ClientDetailsDto findDefaultClientDetails() {
        File jsonFile = getFile();
        if (!jsonFile.exists() || !jsonFile.canRead()) {
            if (LOG.isWarnEnabled()) {
                LOG.warn("Not exist jsonFile: {} or can not read", jsonFile);
            }
            return null;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Read file full-path: {}", jsonFile.getAbsolutePath());
        }
        String json;
        try {
            json = FileCopyUtils.copyToString(new FileReader(jsonFile, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new IllegalStateException("Read error", e);
        }
        return JsonUtils.textToBean(new ClientDetailsDto(), json);
    }

    private File getFile() {
        return new File(CLIENT_DETAILS_FILE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String saveClientDetails(ClientDetailsDto clientDetailsDto) {
        JSONObject jsonObject = JSONObject.fromObject(clientDetailsDto);
        String json = jsonObject.toString();
        try {
            File jsonFile = getFile();
            FileCopyUtils.copy(json, new FileWriter(jsonFile, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new IllegalStateException("Write error", e);
        }
        return null;
    }
}
