package com.json.util;


public class TranscodeUtil {
    /**
     * ASCII�����byte����תʮ�����ַ���
     * @param b ASCII�����byte����
     * @return
     */
    public static String byte2DecStr(byte[] b) {
        String hs = "";
        String stmp = "";
        String resultStr = "";
        String result = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            resultStr = toStringHex1(stmp);
            result = result + resultStr;
	       /* if (stmp.length() == 1) {
	            hs = hs + "0" + stmp;
	        }else {
	            hs = hs + stmp;
	        // if (n<b.length-1) hs=hs+":";
	        }*/
        }
        return result;
    }

    /**
     * ʮ������תʮ����
     * @param s ʮ�������ַ���������ʮ����������
     * @return
     */
    public static String toStringHex1(String s) {
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "utf-8");// UTF-16le:Not
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }
}