/*
 * Copyright (c) 2015 - 2015, Orion Tech Ltd. All rights reserved.
 * OrionWeb is a legal product of Orion Tech Ltd, Nairobi, Kenya. Orion Tech reserves the full rights on the product.
 */

package com.fundmaster.mss.common;

import org.jboss.logging.Logger;

/**
 * Created by bryanitur on 9/13/15.
 */
public class LOGGER<T> {

    private Class<T> clazz;

    public LOGGER(Class clazz)
    {
        this.clazz = clazz;
    }

    /**
     * helper class d() to log debug level information.
     */

    private static String format_msg(String message)
    {
        return ">>>>>>>>>>> " + message + " <<<<<<<<<<";
    }
    public void d(String message)
    {
        Logger log = Logger.getLogger(this.clazz);
        log.debug(format_msg(message));
    }


    /**
     * helper class i() to log info level information.
     */
    public void i(String message)
    {
        Logger log = Logger.getLogger(this.clazz);
        log.info(format_msg(message));
    }


    /**
     * helper class w() to log warning level information.
     */
    public void w(String message)
    {
        Logger log = Logger.getLogger(this.clazz);
        log.warn(format_msg(message));
    }



    /**
     * helper class e() to log error information.
     */
    public void e(String message)
    {
        Logger log = Logger.getLogger(this.clazz);
        log.error(format_msg(message));
    }



    /**
     * helper class f() to log fatal level information.
     */
    public void f(String message)
    {
        Logger log = Logger.getLogger(this.clazz);
        log.fatal(format_msg(message));
    }



    /**
     * helper class t() to log trace information.
     */
    public void t(String message)
    {
        Logger log = Logger.getLogger(this.clazz);
        log.trace(format_msg(message));
    }
}
