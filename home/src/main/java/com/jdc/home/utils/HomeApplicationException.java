package com.jdc.home.utils;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
@SuppressWarnings("serial")
public class HomeApplicationException extends RuntimeException {

}
