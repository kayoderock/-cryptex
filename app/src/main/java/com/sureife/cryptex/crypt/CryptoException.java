package com.sureife.cryptex.crypt;

/**
 * Created by sureife on 25/04/2017.
 */
public class CryptoException extends Exception{
    public CryptoException() {
    }

    public CryptoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
