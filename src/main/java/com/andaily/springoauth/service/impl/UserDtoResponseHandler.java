package com.andaily.springoauth.service.impl;

import com.andaily.springoauth.infrastructure.httpclient.HttpResponseHandler;
import com.andaily.springoauth.infrastructure.httpclient.MkkHttpResponse;
import com.andaily.springoauth.infrastructure.json.JsonUtils;
import com.andaily.springoauth.service.dto.UserDto;
import org.apache.http.StatusLine;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * 15-5-18
 *
 * @author Shengzhao Li
 */
public class UserDtoResponseHandler implements HttpResponseHandler {

    private static final String ERROR_DATA_KEY = "<oauth>";

    private UserDto userDto;

    public UserDtoResponseHandler() {
    }

    /*
    * Response is JSON or  XML (failed)
    *
    *  Error data:
    *  <oauth><error_description>Invalid access token: 3420d0e0-ed77-45e1-8370-2b55af0a62e8</error_description><error>invalid_token</error></oauth>
    *
    * */
    @Override
    public void handleResponse(MkkHttpResponse response) {
        if (response.isResponse200()) {
            responseToUserDto(response);
        } else {
            final StatusLine statusLine = response.httpResponse().getStatusLine();
            this.userDto = new UserDto(String.valueOf(statusLine.getStatusCode()), statusLine.getReasonPhrase());
        }
    }

    private void responseToUserDto(MkkHttpResponse response) {
        final String text = response.responseAsString();
        if (text.startsWith(ERROR_DATA_KEY)) {
            parseErrorXML(response);
        } else {
            this.userDto = JsonUtils.textToBean(new UserDto(), text);
        }
    }

    private void parseErrorXML(MkkHttpResponse response) {
        try {
            final SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            saxParser.parse(response.httpResponse().getEntity().getContent(), new ErrorDefaultHandler());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public UserDto getUserDto() {
        return userDto;
    }


    /**
     * Parse Error XML handler
     */
    private class ErrorDefaultHandler extends DefaultHandler {
        private String qName;

        private ErrorDefaultHandler() {
            userDto = new UserDto();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            this.qName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            final String text = new String(ch, start, length);

            if ("error_description".equalsIgnoreCase(qName)) {
                userDto.setErrorDescription(text);
            } else if ("error".equalsIgnoreCase(qName)) {
                userDto.setError(text);
            }

        }

    }

}
