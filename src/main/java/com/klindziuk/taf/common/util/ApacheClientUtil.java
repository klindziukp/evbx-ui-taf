package com.klindziuk.taf.common.util;

import com.klindziuk.taf.common.exception.RequestException;
import com.klindziuk.taf.common.log.Info;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Utility for Apache client usage
 */
public class ApacheClientUtil {

    private ApacheClientUtil() {

    }

    public static String getRequest(String requestUrl) {
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpResponse response = client.execute(new HttpGet(requestUrl));
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, "UTF-8");
        } catch (IOException ioEx) {
            Info.error(ioEx);
            throw new RequestException("Unable to execute GET request.", ioEx);
        }
    }
}
