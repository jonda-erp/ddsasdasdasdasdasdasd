package com.jonda.common.util;

import org.apache.commons.lang3.time.FastDateParser;

import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by rejoady on 2014/8/13.
 */
public class JondaDateParser extends FastDateParser {

    /**
     * <p>Constructs a new FastDateParser.</p>
     *
     * @param pattern  non-null {@link java.text.SimpleDateFormat} compatible
     *                 pattern
     * @param timeZone non-null time zone to use
     * @param locale   non-null locale
     */
    protected JondaDateParser(String pattern, TimeZone timeZone, Locale locale) {
        super(pattern, timeZone, locale);
    }

    public JondaDateParser(String pattern) {
        super(pattern, TimeZone.getDefault(), Locale.getDefault());
    }

}
