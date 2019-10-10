package com.bds.tokenTest.test.xiaohongshu.utils;

import java.io.CharArrayWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;

public class xhsUtils {
	static BitSet a = new BitSet(256);
	  
	  static
	  {
	    int i = 97;
	    while (i <= 122)
	    {
	      a.set(i);
	      i += 1;
	    }
	    i = 65;
	    while (i <= 90)
	    {
	      a.set(i);
	      i += 1;
	    }
	    i = 48;
	    while (i <= 57)
	    {
	      a.set(i);
	      i += 1;
	    }
	    a.set(32);
	    a.set(45);
	    a.set(95);
	    a.set(46);
	  }
	  
	  public static String handleSb(String paramString1,String paramString2) throws UnsupportedEncodingException{
			StringBuffer localStringBuffer = new StringBuffer(paramString1.length());
		    Charset localCharset = Charset.forName(paramString2);
	        int i = 0;
	        int k = 0;
	        try{
		        while(i<paramString1.length()){
		        	int n = paramString1.charAt(i);
		            int j = i;
		            int m = n;
		            if (a.get(n)){
		              j = n;
		              if (n == 32)
		              {
		                j = 43;
		                k = 1;
		              }
		              localStringBuffer.append((char)j);
		              i += 1;
		            }else{
//		            	BitSet paramString3 = a;
		            	CharArrayWriter localCharArrayWriter = new CharArrayWriter();
		            	do{
		                  localCharArrayWriter.write(m);
		                  i = j;
//		                  if (m >= 55296)
//		                  {
//		                    i = j;
//		                    if (m <= 56319)
//		                    {
//		                      k = j + 1;
//		                      i = j;
//		                      if (k < paramString1.length())
//		                      {
//		                        m = paramString1.charAt(k);
//		                        i = j;
//		                        if (m >= 56320)
//		                        {
//		                          i = j;
//		                          if (m <= 57343)
//		                          {
//		                            localCharArrayWriter.write(m);
//		                            i = k;
//		                          }
//		                        }
//		                      }
//		                    }
//		                  }
		                  i += 1;
		                  if (i >= paramString1.length()) {
		                    break;
		                  }
		                  k = paramString1.charAt(i);
		                  j = i;
		                  m = k;
		                } while (!a.get(k));
		            	localCharArrayWriter.flush();
		                byte[] paramString4 = new String(localCharArrayWriter.toCharArray()).getBytes(localCharset);
		                j = 0;
		                while (j < paramString4.length)
		                {
		                  localStringBuffer.append('%');
		                  char c2 = Character.forDigit(paramString4[j] >> 4 & 0xF, 16);
		                  char c1 = c2;
		                  if (Character.isLetter(c2)) {
		                    c1 = (char)(c2 - ' ');
		                  }
		                  localStringBuffer.append(c1);
		                  c2 = Character.forDigit(paramString4[j] & 0xF, 16);
		                  c1 = c2;
		                  if (Character.isLetter(c2)) {
		                    c1 = (char)(c2 - ' ');
		                  }
		                  localStringBuffer.append(c1);
		                  j += 1;
		                }
		            }
		        }
		        if (k != 0) {
		        	paramString1 = localStringBuffer.toString();
		        }
		        return paramString1;
	        }catch (Exception e) {
				// TODO: handle exception
			}
	        throw new UnsupportedEncodingException(paramString2);
		}
	  
}
