
package com.example.testdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Base64;

import static org.apache.commons.lang3.StringUtils.isNumeric;

@Slf4j
public class StringTest {
    @Test
    public void stringBuilderTest2() {
        String t1 = "Person";
        String substring = t1.substring(0, t1.length() - 1);
        System.out.println(t1);
        System.out.println(substring);
        StringBuilder builder = new StringBuilder();
        builder.append("Person");
        String substring1 = builder.substring(0, builder.length() - 1);
        System.out.println(builder.toString());
        System.out.println(substring1);


    }

    @Test
    public void test02(){
        //
        Integer integer = null;
        String value = String.valueOf(integer);
        Assert.assertEquals(value, "null");
    }

    @Test
    public void test03(){
        String str = "{ \n" +
        "\t\"mcc\": \"302\",\n" +
                "\t\"mnc\": \"720\",\n" +
                "\t\"cid\": \"117\",\n" +
                "\t\"enodeb_id\": \"370856\",\n" +
                "\t\"latitude\": \"53643298\",\n" +
                "\t\"longitude\": \"-69395452\",\n" +
                "\t\"altitude\": 14,\n" +
                "\t\"polygon\": \"\",\n" +
                "\t\"cell_opening_angle\": 1200,\n" +
                "\t\"cell_bearing\": 1200,\n" +
                "\t\"cell_radius\": 5000,\n" +
                "\t\"tac\": 3,\n" +
                "\t\"power\": 46,\n" +
                "\t\"earfcn_dl\": 400,\n" +
                "\t\"earfcn_ul\": 18040,\n" +
                "\t\"otdoa_supl_active\": \"true\",\n" +
                "\t\"physical_id\": 302,\n" +
                "\t\"antenna_gain\": 19,\n" +
                "\t\"antenna_tilt\": 16,\n" +
                "\t\"gps_time_sfn0_seconds\": 1090854369,\n" +
                "\t\"gps_time_sfn0_decimal_second\": 0,\n" +
                "\t\"prs_config_index_mapped\": 90,\n" +
                "\t\"dl_channel_bandwidth\": 3000,\n" +
                "\t\"no_consecutive_subframes\": 2,\n" +
                "\t\"no_of_tx_antennas\": 1,\n" +
                "\t\"timestamp\": \"\",\n" +
                "\t\"mme_gi_list_lte_related\": 1,\n" +
                "\t\"femto_cell_type\": \"\",\n" +
                "\t\"prs_muting_info\": 0,\n" +
                "\t\"cell_portion_available_flag\": false\n" +
                "}"
        ;

        System.out.println(str);

        log.info("LCSController.deleteBarredMSISDN (cluster:{}; clientId:{}; msisdn:{}; fromFile:{})", "18-cluster-smpc", "01", "123", "import.txt");
        log.info("LCSController.searchBarredIMSI (cluster:{}; clientId:{}; imsi:{}; toFile:{})", "18-cluster-smpc", "01", "123", "export.txt");

    }

    @Test
    public void test04(){
        // [-32768.0 , 32767]
        Float f1 = -32768.0f;
        Float f2 = 32767f;
        Double d1 = -32768.0;
        Double d2 = 32767d;
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
    }

    @Test
    public void test05(){
        String mcc = "aaa";
        String mnc = "111";
        if (!isNumeric(mcc) || !isNumeric(mnc)) {
            System.out.println("\"mcc\" or \"mnc\" contains non-numeric characters.");
        }
    }

    @Test
    public void test06(){
        StringBuilder value = new StringBuilder("123456789");
        String v = value.substring(0, value.length() - 1);
        System.out.println(v);
    }

    @Test
    public void test07() throws UnknownHostException {
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        System.out.println(hostAddress);
    }

    @Test
    public void consul() {

//        Console c = System.console();
//
//        String username = c.readLine("User name:");
//
//        c.printf("user:" + username+"\n");
//
//        char[] passwd = c.readPassword("Password:");
//
//        c.printf(String.valueOf(passwd));

    }

    @Test
    public void testvalue(){
//        String theValue = "null";
//
//        String value = theValue == null ? "" : theValue;
//        Assert.assertEquals("null", value);
        String a = "a";
        String b = "a";
        boolean boo = !(a != null && a.equals(b) && b != null && b.equals(a));
        Assert.assertEquals(true, boo);
    }

    @Test
    public void testfile(){

        boolean isModify = false;
        String fileName = "C:\\Temp\\msc.test";
        File file = new File("C:\\Temp\\msc.test");
        String modifyName = fileName + "." + System.currentTimeMillis();
        if (file.exists()){
            file.renameTo(new File(modifyName));
            isModify = true;
        }
        System.out.println("Operation File!");
        if(isModify){
            File modifyFile = new File(modifyName);
            modifyFile.renameTo(new File(fileName));
//            modifyFile.delete();
        }
    }

    @Test
    public void testRex(){
        String mscNumber = "ALL+ALL";
        String[] split = mscNumber.split("\\+");
        Assert.assertTrue("ALL".equalsIgnoreCase(split[0]));
        Assert.assertTrue("ALL".equalsIgnoreCase(split[1]));
    }

    enum Color {
        RED,
        BLUE,
        YELLOW,
        NULL,
        BBB
    }
    @Test
    public void testEum(){
        Assert.assertEquals("NULL", Color.NULL.name());
        Assert.assertEquals("NULL", Color.NULL.toString());
//        Assert.assertEquals("NULL", Color.valueOf(""));
    }

    public static String escapeEncode(String originStr) {
        String escapedString = originStr;
        try{
            escapedString = URLEncoder.encode(originStr, "utf-8");
        } catch (Exception e) {
            log.error("Encode failed");
        }
        return escapedString;
    }

    public static String base64Encode(String str){
        String encodeStr = null;
        try {
            encodeStr =  Base64.getEncoder().encodeToString(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    @Test
    public void testEncode(){
        String encode = escapeEncode("https://www.baidu.com");
        System.out.println(encode);
        String encode1 = escapeEncode(encode);
        System.out.println(encode1);
    }

    @Test
    public void testBase64Encode(){
        String encode = base64Encode("bbb");
        System.out.println(encode);
    }

    private static int change(int i){
        if(i >= 3 && i <= 6){
            return 9 - i;
        }else {
            return i;
        }
    }

    private static int back(int i){
        if(i >= 3 && i <= 6){
            return 9 - i;
        }else {
            return i;
        }
    }
//      3 4 5 6 2 1
//
//      6 5 4 3 2 1
    @Test
    public void testInt(){
        Assert.assertEquals(6, change(3));
        Assert.assertEquals(5, change(4));
        Assert.assertEquals(4, change(5));
        Assert.assertEquals(3, change(6));
        Assert.assertEquals(2, change(2));
        Assert.assertEquals(1, change(1));

        Assert.assertEquals(3, back(6));
        Assert.assertEquals(4, back(5));
        Assert.assertEquals(5, back(4));
        Assert.assertEquals(6, back(3));
        Assert.assertEquals(2, back(2));
        Assert.assertEquals(1, back(1));
    }
}
