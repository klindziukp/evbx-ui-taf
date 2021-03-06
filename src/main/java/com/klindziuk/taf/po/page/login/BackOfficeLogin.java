package com.klindziuk.taf.po.page.login;

import com.klindziuk.taf.common.log.Info;
import com.klindziuk.taf.po.page.BasePage;

/**
 * Represents 'BackOfficeLogin' page
 */
public class BackOfficeLogin extends BasePage {

    @Override
    public boolean isPageOpened(int seconds) {
        return true;
    }

    public void login(String password, String username) {
        // w8 for page opened
        // login
        Info.info("Login with credentials " + password + "/" + username);
    }
}
