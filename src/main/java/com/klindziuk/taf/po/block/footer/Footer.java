package com.klindziuk.taf.po.block.footer;

import com.klindziuk.taf.common.constant.TimeConstant;
import com.klindziuk.taf.common.envelope.LocatorType;
import com.klindziuk.taf.common.envelope.WebEnvelope;

/**
 * Represents 'Footer' element
 */
public class Footer {

    // PO Elements
    private WebEnvelope twitter(){
        return new WebEnvelope(LocatorType.CLASS_NAME, "icon twitter");
    }

    private WebEnvelope linkedIn(){
        return new WebEnvelope(LocatorType.CLASS_NAME, "icon linkedin");
    }

    private WebEnvelope facebook(){
        return new WebEnvelope(LocatorType.CLASS_NAME, "icon facebook");
    }

    // PO Methods
    public boolean isTwitterVisible(){
        return twitter().isVisible(TimeConstant.SECONDS_3);
    }

    public boolean isLinkedInVisible(){
        return linkedIn().isVisible(TimeConstant.SECONDS_3);
    }

    public boolean isFacebookVisible(){
        return facebook().isVisible(TimeConstant.SECONDS_3);
    }
}
