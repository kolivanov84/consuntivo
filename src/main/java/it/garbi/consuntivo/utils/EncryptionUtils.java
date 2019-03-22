package it.garbi.consuntivo.utils;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

public class EncryptionUtils {

	@Autowired                         
    BasicTextEncryptor textEncryptor;

    public String encrypt(String data){
        return textEncryptor.encrypt(data);
    }

    public String decrypt(String encriptedData){
        return textEncryptor.decrypt(encriptedData);
    }
	
}
