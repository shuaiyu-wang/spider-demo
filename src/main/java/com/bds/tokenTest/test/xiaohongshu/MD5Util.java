package com.bds.tokenTest.test.xiaohongshu;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util
{
  public static String a(String paramString)
  {
    try
    {
      paramString = a(paramString.getBytes("utf-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException p)
    {
      p.printStackTrace();
    }
    return "";
  }
  
  public static String a(byte[] ps)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(ps);
      return StringUtil.a(localMessageDigest.digest());
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return "";
  }
}
