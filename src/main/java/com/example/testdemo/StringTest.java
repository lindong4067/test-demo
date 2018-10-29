
package com.example.testdemo;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.apache.commons.lang3.StringUtils.trimToNull;
import static sun.misc.PostVMInitHook.run;

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

//        log.info("LCSController.deleteBarredMSISDN (cluster:{}; clientId:{}; msisdn:{}; fromFile:{})", "18-cluster-smpc", "01", "123", "import.txt");
//        log.info("LCSController.searchBarredIMSI (cluster:{}; clientId:{}; imsi:{}; toFile:{})", "18-cluster-smpc", "01", "123", "export.txt");

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

    @Test
    public void stringFormat(){
//        String format = String.format("aaa %s bbb cc%s d%sd", "", 1000.1010, "d");
//        System.out.println(format);
        String hostname = "linux-tot-49,linux-tot-50,linux-tot-51,linux-tot-52";
        Long starttime = 1238454723L;
        Long stoptime = 12383244723L;
        String[] hosts = hostname.split(",");
        String sql = "SELECT MODULE_NAME, EVENT_NAME, ORGINATING_SOURCE_IP, ORGINATING_HOSTNAME, CATEGORY, TIME_STAMP, COUNT, EVENT_TYPE, INFORMATION, AFFECTED_OBJECT FROM EventLog WHERE ORGINATING_HOSTNAME NOT IN(%s,%s,%s,%s) AND TIME_STAMP BETWEEN %s AND %s ORDER BY TIME_STAMP DESC";
        String sqlStatement = String.format(sql, hosts[0], hosts[1], hosts[2], hosts[3], starttime, stoptime);
        System.out.println(sqlStatement);
    }

    @Test
    public void testIP(){
        try {
            boolean flag = InetAddress.getByName("CN00212361").isReachable(3000);
            String hostName = InetAddress.getLocalHost().getHostName();
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            System.out.println(hostName);
            System.out.println(hostAddress);
            System.out.println(flag);
        } catch (Exception e) {
        }
    }

    @Test
    public void testBigDecimal(){
        double d1 = 1.01;
        double d2 = 2.02;
        double d3 = d1 + d2;
        System.out.println(d3);

        BigDecimal b1 = new BigDecimal("1.01");
        BigDecimal b2 = BigDecimal.valueOf(2.02);
        BigDecimal b3 = b1.add(b2);
        System.out.println(b3);
    }

    @Test
    public void testRegular(){
        String ip = "2001:1b70:200:1000::164";
        String ipv4 = "192.168.0.1";
        String pattern = "^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}$";
        String pattern2 = "^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}$";
        String pattern3 =  "^\\s*((([0-9A-Fa-f]{1,4}:){7}([0-9A-Fa-f]{1,4}|:))|(([0-9A-Fa-f]{1,4}:){6}(:[0-9A-Fa-f]{1,4}|((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){5}(((:[0-9A-Fa-f]{1,4}){1,2})|:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){4}(((:[0-9A-Fa-f]{1,4}){1,3})|((:[0-9A-Fa-f]{1,4})?:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){3}(((:[0-9A-Fa-f]{1,4}){1,4})|((:[0-9A-Fa-f]{1,4}){0,2}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){2}(((:[0-9A-Fa-f]{1,4}){1,5})|((:[0-9A-Fa-f]{1,4}){0,3}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){1}(((:[0-9A-Fa-f]{1,4}){1,6})|((:[0-9A-Fa-f]{1,4}){0,4}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(:(((:[0-9A-Fa-f]{1,4}){1,7})|((:[0-9A-Fa-f]{1,4}){0,5}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:)))(%.+)?\\s*$";
        String pattern4 = "([a-f0-9]{1,4}(:[a-f0-9]{1,4}){7}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){0,7}::[a-f0-9]{0,4}(:[a-f0-9]{1,4}){0,7})";
        String pattern5 = ".*[a-fA-F].*";
        boolean matches = ip.matches(pattern5);
        System.out.println(matches);
        boolean matches1 = ipv4.matches(pattern5);
        System.out.println(matches1);
    }

    @Test
    public void testHost(){
        String address = "linux-tot-49.tot";
        String memberAddress = "linux-tot-49";
        if(memberAddress != null && !"".equals(memberAddress)){
            if(address.contains(memberAddress) || memberAddress.contains(address)){
                System.out.println(address);
            }
        }
    }

    @Test
    public void testBoolean(){
        boolean a = true;
        boolean b = true;
        boolean c = false;
        boolean d = true;
        System.out.println(a || c && d);

    }

    @Test
    public void testIPV6() throws UnknownHostException {
        String ipAddr0 = "2001:1b70:200:1000:0:0:0:164";
        String ipAddr1 = "2001:1b70:200:1000::164";
        InetAddress inetAddr = InetAddress.getByName(ipAddr1);
        ipAddr1 = inetAddr.getHostAddress();
        System.out.println(ipAddr0);
        System.out.println(ipAddr1);

    }

    @Test
    public void testIPv4IPv6() throws UnknownHostException {
        String ipv4 = "192.168.1.1";
        String ipv6 = "FE80:98FA::B45A";
        if(!ipv4.matches(".*[a-fA-F].*")){
            System.out.println(ipv4 + " is IPv4.");
        }
        if(ipv6.matches(".*[a-fA-f].*")){
            System.out.println(ipv6 + " is IPv6.");
        }
        String address = InetAddress.getByName(ipv6).getHostAddress();
        System.out.println(address);

        InetAddress localHost = InetAddress.getLocalHost();
        String hostAddress = localHost.getHostAddress();
        System.out.println(hostAddress);
        InetAddress localHost1 = Inet6Address.getLocalHost();
        String hostAddress1 = localHost1.getHostAddress();
        System.out.println(hostAddress1);
    }

    @Test
    public void testPlmn(){
        String plmnValue = "1234567,123;2345678,;,234;";
        String[] gtspcs = plmnValue.split(";");
        for (String gtspc : gtspcs) {
            String[] gs = gtspc.split(",", 2);
            System.out.println(gs[0]);
//            System.out.println(gs.length < 2 ? "" : gs[1]);
            System.out.println(gs[1]);
            System.out.println("plmn");
        }
        String str = "2345678,;";
        String replace = plmnValue.replace(str, "");
        System.out.println(str);
        System.out.println(replace);
        System.out.println(plmnValue);
        System.out.println(str.concat(str).concat(str));
    }

    @Test
    public void testArray(){
        //One
        String[] arr1 = new String[3];
        arr1[0] = "AAA";
        arr1[1] = "BBB";
        arr1[2] = "CCC";
        for (String s : arr1) {
            System.out.println(s);
        }
        //Two
        String[] arr2 = {"AAA", "BBB", "CCC"};
        for (String s : arr2) {
            System.out.println(s);
        }
        //Three
        String[] arr3 = new String[]{"AAA", "BBB", "CCC"};
        for (String s : arr3) {
            System.out.println(s);
        }
    }

    @Test
    public void testRegx(){
        String reg = "^([0-1](\\.[0-9][0-9]?))$|^([0-2])$";
        String str = "0:2";
        boolean matches = str.matches(reg);
        System.out.println(matches);
        byte[] buffer = new byte[1024];
        int length = buffer.length;
        System.out.println(length);
    }

    @Test
    public void testFilePath() throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("test/test_file.txt");
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1){
            result.write(buffer, 0, length);
        }
        String string = result.toString(StandardCharsets.UTF_8.name());
        System.out.println(string);

    }

    private static String getFormatClusterValue(String cluster) {
        if(cluster != null && cluster.contains("_")){
            return cluster.replace("_", "-");
        }
        return cluster;
    }

    @Test
    public void testCluster(){
        String cluster1 = "18-smpc-cluster";
        String cluster2 = "18_smpc-cluster";
        String cluster3 = "18-smpc_cluster";
        String cluster4 = "18_smpc_cluster";
        String cluster5 = "cluster";
        String v1 = getFormatClusterValue(cluster1);
        System.out.println(v1);
        String v2 = getFormatClusterValue(cluster2);
        System.out.println(v2);
        String v3 = getFormatClusterValue(cluster3);
        System.out.println(v3);
        String v4 = getFormatClusterValue(cluster4);
        System.out.println(v4);
        String v5 = getFormatClusterValue(cluster5);
        System.out.println(v5);
    }

    @Test
    public void testParam(){
        String cluster1 = "18-smpc-cluster";
        String cluster2 = "18_smpc-cluster";
        String cluster3 = "18_smpc_cluster";
        boolean b1 = checkParameter(cluster1);
        System.out.println(b1);
        boolean b2 = checkParameter(cluster2);
        System.out.println(b2);
        boolean b3 = checkParameter(cluster3);
        System.out.println(b3);
    }

    private boolean checkParameter(String cluster) {
        if(StringUtils.isEmpty(cluster)
                || (cluster.contains("-")
                && cluster.split("-").length != 3)
                || (cluster.contains("_")
                && cluster.split("_").length != 3)){
            return false;
        }
        return true;
    }

    public static String getFormatIP(String ip){
        if(ip == null || "".equals(ip)){
            return ip;
        }else if(ip.contains(":")){
            try {
                ip = InetAddress.getByName(ip).getHostAddress();
            } catch (UnknownHostException e) {
                log.debug(e.getMessage());
            }
            return ip;
        }
        return ip;
    }

    @Test
    public void test10(){
        String ipv4 = "192.168.1.1";
        String ipv6 = "[FE80:98FA::B45A]";
        String ip4 = getFormatIP(ipv4);
        String ip6 = getFormatIP(ipv6);
        System.out.println(ip4);
        System.out.println(ip6);
    }

    private static List<String> updateMany(List<String> peopleList, Predicate<String> predicate, Consumer<String> consumer) {
        for (String aPeopleList : peopleList) {
            if (!predicate.test(aPeopleList)) {
                consumer.accept(aPeopleList);
            }
        }
        return peopleList;
    }

    @Test
    public void testUpdateMany(){
        List<String> stringList = new ArrayList<>();
        stringList.add("ABC");
        stringList.add("ABC");
        stringList.add("BCD");
        stringList.add("BCD");
        stringList.add("CDE");
        List<String> strings = new ArrayList<>();
        updateMany(stringList, strings::contains, strings::add);
        System.out.println(strings);
    }

    @Test
    public void testMap(){
        Map<Object, Object> kvs = new HashMap<>();
        kvs.put(null, "null");
        kvs.put("null", null);
        for (Map.Entry<Object, Object> entry : kvs.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (Objects.equals(null, key)){
                key = "NULL";
            }
            if (Objects.equals(null, value)){
                value = "NULL";
            }
            System.out.println(key);
            System.out.println(value);
            System.out.println("------");
        }
    }

    @Test
    public void testNull(){
        List list = new ArrayList();
        // list = null;
        //NullPointerException
        for (Object o : list) {
            System.out.println(o.toString());
        }
    }

    @Test
    public void testEnv(){
        String oam_center_ip = EnvironmentVariables.get("OAM_Center_IP");
        String oam_center_local_ip = EnvironmentVariables.get("OAM_Center_Local_IP");
        String oam_center_local_vip = EnvironmentVariables.get("OAM_Center_Local_VIP");
        System.out.println(oam_center_ip);
        System.out.println(oam_center_local_ip);
        System.out.println(oam_center_local_vip);
    }

    private static long num;
    private static Boolean sended = false;

    @Test
    public void testStatic(){
        num++;
        num++;
        //It's OK.
        sended = true;
        //It's OK.
        log.debug("Num : {}", num);
        log.debug("Sended : {}", sended);
    }

    @Test
    public void testInter() throws UnknownHostException {
        String originIp = "192.168.0.1";
//        String originIp = null;
//        Assert.assertNull(InetAddress.getByName(null));
        InetAddress address = InetAddress.getByName(originIp);

        String hostAddress = address.getHostAddress();
        String hostName = address.getHostName();

        log.debug(address.toString());
        log.debug(hostAddress);
        log.debug(hostName);

        log.debug("\nOAM center cannot access Consul, raise an alarm({}) : \nModuleId : {} \nErrorCode : {} \nDescription : {}",
                "consulAlarmNum", "OAM_CENTER", 643, "RAISE_ALARM_DB");
    }

    public static boolean raisedDB = false;
    public static boolean clearedDB = false;

    public static void raiseAlarm(){
        if (!raisedDB) {
            log.info("Raise an Alarm...");
            raisedDB = true;
            clearedDB = false;
        }
    }

    public static void clearAlarm(){
        if (!clearedDB) {
            log.info("Clear an Alarm...");
            clearedDB = true;
            raisedDB = false;
        }
    }

    @Test
    public void testAlarm(){
        log.info("Start...");
        clearAlarm();
        clearAlarm();
        clearAlarm();
        log.info("******");
        raiseAlarm();
        raiseAlarm();
        raiseAlarm();


        log.info("******");
        raiseAlarm();
        clearAlarm();
        raiseAlarm();
        clearAlarm();
        raiseAlarm();
        clearAlarm();
        log.info("******");

        log.info("Stop...");
    }

    public static boolean checkByRegex(String myString, String regex){
        Pattern p = Pattern.compile("^" + regex + "$");
        Matcher m=p.matcher(myString);
        boolean result = m.find();
        return result;
    }

    @Test
    public void testregex(){
        String regex = "((((([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]).){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]).){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))|((([0-9]|[1-8][0-9]|9[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]).){3}([0-9]|[1-8][0-9]|9[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]))):([0-9]|[1-9]\\d{1}|[1-9]\\d{2}|[1-9]\\d{3}|[1-5]\\d{4}|6[0-4]\\d{3}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-5]));)+";
        String regex2 = "(\\[(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))\\]:([0-9]|[1-8][0-9]|9[0-9]|[1-8][0-9]{2}|9[0-8][0-9]|99[0-9]|[1-8][0-9]{3}|9[0-8][0-9]{2}|99[0-8][0-9]|999[0-9]|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5])|((([0-9]|[1-8][0-9]|9[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-8][0-9]|9[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])):([0-9]|[1-8][0-9]|9[0-9]|[1-8][0-9]{2}|9[0-8][0-9]|99[0-9]|[1-8][0-9]{3}|9[0-8][0-9]{2}|99[0-8][0-9]|999[0-9]|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5]))";
        String str = "[fe80::d88e:b7ff:fe6a:d961]:22";
        boolean b = checkByRegex(str, regex2);
        System.out.println(b);
    }

    @Test
    public void testNum(){
        int a = 20;
        Integer b = 20;
        System.out.println(b.equals(a));
    }

    @Test
    public void testsubstring(){
        String str = "123456";
        String sub = str.substring(0, str.length() - 1);
        System.out.println(sub);
    }

    @Test
    public void testJson(){
        String info = "[]";
        List<Map<String, Object>> invocation = new Gson().fromJson(info, List.class);
        log.info("invocation : {}", invocation);
    }

    @Test
    public void testFuture(){
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> System.out.println("Hello"));
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private boolean analyzeCache(Map<String, Map<String, Boolean>> ispCache) {
        boolean status = true;
        for(Map.Entry<String, Map<String, Boolean>> entry : ispCache.entrySet()) {

            boolean statusOfOneTypeService = false;
            for(Map.Entry<String, Boolean> entry1 : entry.getValue().entrySet()) {
                // If any service of the same type is good, this kind of service is considered as good. For example, type oam-fds--fdsserver.
                if(entry1.getValue()) {
                    statusOfOneTypeService = true;
                    break;
                }
            }
            // If any kind of service is not good, system is considered as down
            if(!statusOfOneTypeService) {
                status = false;
                break;
            }
        }
        return status;
    }

    @Test
    public void testISP(){
        Map<String, Map<String, Boolean>> ispCache = new ConcurrentHashMap<>();
        Map<String, Boolean> fdsmap = new HashMap<>();
        fdsmap.put("fds-1", true);
        fdsmap.put("fds-2", true);
        fdsmap.put("fds-3", false);
        ispCache.put("fds", fdsmap);
        Map<String, Boolean> udamap = new HashMap<>();
        udamap.put("uda-1", false);
        udamap.put("uda-2", true);
        udamap.put("uda-3", true);
        ispCache.put("uda", udamap);
        Map<String, Boolean> postgremap = new HashMap<>();
        postgremap.put("postgre-1", false);
        postgremap.put("postgre-2", false);
        postgremap.put("postgre-3", false);
        ispCache.put("postgre", postgremap);
        boolean cache = analyzeCache(ispCache);
        System.out.println(cache);
    }

    @Test
    public void testSingleBoolen(){
        String a = null;
        String b = "";

        if (agency(a) || agency(b)){
            log.info("Short circuit.\n");
        }
        if (agency(a) | agency(b)){
            log.info("Both sides run.\n");
        }
    }

    private boolean agency(String string){
        log.info("Check parameter : {}", string);
        return StringUtils.isEmpty(string);
    }

    @Test
    public void testNotNull(){
        String s = null;
        try {
            Objects.requireNonNull(s, "parameter is not null.");
        }catch (Exception e){
            assert(e instanceof NullPointerException);
        }
        log.info("go on..."); //not come here
    }
}
