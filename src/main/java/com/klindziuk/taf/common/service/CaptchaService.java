package com.klindziuk.taf.common.service;

import com.klindziuk.taf.common.config.Captcha;
import com.klindziuk.taf.common.config.ConfigStorage;
import com.klindziuk.taf.common.constant.TimeConstant;
import com.klindziuk.taf.common.log.Info;
import com.klindziuk.taf.common.util.ApacheClientUtil;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

/**
 * Service to pass captcha
 */
public class CaptchaService {

    private String apiKey;
    private Captcha captcha;

    public CaptchaService(String apiKey) {
        this.apiKey = apiKey;
        this.captcha = ConfigStorage.getConfig().getCaptcha();
    }

    /**
     * Generates token for pass captcha
     * @param pageUrl captcha service url
     * @return captcha
     */
    public String generateToken(String pageUrl) {
        String captchaIdResponse = ApacheClientUtil.getRequest(generateSendCaptchaUrl(apiKey, pageUrl));
        String captchaId = extractResponsePayload(captchaIdResponse);
        String tokenResponse = getProvidedToken(generateGetCaptchaTokenUrl(apiKey, captchaId));
        return extractResponsePayload(tokenResponse);
    }

    private String extractResponsePayload(String response) {
        int payloadIndex = 3;
        return response.substring(payloadIndex);
    }

    private String generateGetCaptchaTokenUrl(String apiKey, String captchaId) {
        return String.format(captcha.getTokenUrlPattern(), apiKey, captchaId);
    }

    private String generateSendCaptchaUrl(String apiKey, String pageUrl) {
        return String.format(captcha.getCaptchaUrlPattern(), apiKey, captcha.getGoogleKey(), pageUrl);
    }

    private String getProvidedToken(String getTokenUrl) {
        FluentWait<String> wait = new FluentWait<>(getTokenUrl)
                .withTimeout(Duration.ofSeconds(TimeConstant.SECONDS_45))
                .pollingEvery(Duration.ofSeconds(TimeConstant.SECONDS_2));

        return wait.until(requestUrl -> {
            String tokenResponse = ApacheClientUtil.getRequest(getTokenUrl);
            boolean isCaptchaReady = isCaptchaReady(tokenResponse);
            Info.info("Is captcha ready: " + isCaptchaReady);
            if (isCaptchaReady) {
                return tokenResponse;
            }
            return null;
        });
    }

    private boolean isCaptchaReady(String tokenResponse ){
       return !tokenResponse.equals("CAPCHA_NOT_READY");
    }
}
