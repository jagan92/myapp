package com.myapp.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myapp.constants.AppConstants;

@Component
public class EncryptionUtils {

  private static final String CLASS_NAME = EncryptionUtils.class.getName();
  private static final String METHOD_SET_ENCRYPTED_ID = "setEncryptedId";

  private static StringEncryptor stringEncryptor;

  public static Long decryptId(String encryptedString) {
    if (StringUtils.isBlank(encryptedString)) {
      return null;
    }
    return Long.valueOf(stringEncryptor.decrypt(encryptedString));
  }

  public static String encryptId(Long id) {
    String encryptedId = "";
    if (id != null) {
      try {
        encryptedId = URLEncoder.encode(stringEncryptor.encrypt(String.valueOf(id)), "UTF-8");
      } catch (UnsupportedEncodingException ex) {
        
      }
    }
    return encryptedId;
  }

  @Autowired
  public void setStringEncryptor(StringEncryptor stringEncryptor) {
    EncryptionUtils.stringEncryptor = stringEncryptor;
  }

}