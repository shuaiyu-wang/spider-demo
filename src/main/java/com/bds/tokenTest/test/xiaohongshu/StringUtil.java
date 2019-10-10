package com.bds.tokenTest.test.xiaohongshu;


public class StringUtil
{
  private static final char[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return "";
    }
    int j = paramArrayOfByte.length;
    char[] arrayOfChar = new char[j * 2];
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      int m = i * 2;
      arrayOfChar[m] = c[(k >>> 4 & 0xF)];
      arrayOfChar[(m + 1)] = c[(k & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
}
