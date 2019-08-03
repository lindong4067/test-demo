
package com.example.testdemo;

import com.google.gson.Gson;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.util.ResourceUtils;
//import sun.misc.Unsafe;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.apache.commons.lang3.StringUtils.replaceOnce;

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
    public void test02() {
        //
        Integer integer = null;
        String value = String.valueOf(integer);
        Assert.assertEquals(value, "null");
    }

    @Test
    public void test03() {
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
                "}";

        System.out.println(str);

//        log.info("LCSController.deleteBarredMSISDN (cluster:{}; clientId:{}; msisdn:{}; fromFile:{})", "18-cluster-smpc", "01", "123", "import.txt");
//        log.info("LCSController.searchBarredIMSI (cluster:{}; clientId:{}; imsi:{}; toFile:{})", "18-cluster-smpc", "01", "123", "export.txt");

    }

    @Test
    public void test04() {
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
    public void test05() {
        String mcc = "aaa";
        String mnc = "111";
        if (!isNumeric(mcc) || !isNumeric(mnc)) {
            System.out.println("\"mcc\" or \"mnc\" contains non-numeric characters.");
        }
    }

    @Test
    public void test06() {
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
    public void testvalue() {
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
    public void testfile() {

        boolean isModify = false;
        String fileName = "C:\\Temp\\msc.test";
        File file = new File("C:\\Temp\\msc.test");
        String modifyName = fileName + "." + System.currentTimeMillis();
        if (file.exists()) {
            file.renameTo(new File(modifyName));
            isModify = true;
        }
        System.out.println("Operation File!");
        if (isModify) {
            File modifyFile = new File(modifyName);
            modifyFile.renameTo(new File(fileName));
//            modifyFile.delete();
        }
    }

    @Test
    public void testRex() {
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
    public void testEum() {
        Assert.assertEquals("NULL", Color.NULL.name());
        Assert.assertEquals("NULL", Color.NULL.toString());
//        Assert.assertEquals("NULL", Color.valueOf(""));
    }

    public static String escapeEncode(String originStr) {
        String escapedString = originStr;
        try {
            escapedString = URLEncoder.encode(originStr, "utf-8");
        } catch (Exception e) {
            log.error("Encode failed");
        }
        return escapedString;
    }

    public static String base64Encode(String str) {
        String encodeStr = null;
        try {
            encodeStr = Base64.getEncoder().encodeToString(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    @Test
    public void testEncode() {
        String encode = escapeEncode("https://www.baidu.com");
        System.out.println(encode);
        String encode1 = escapeEncode(encode);
        System.out.println(encode1);
    }

    @Test
    public void testBase64Encode() {
        String encode = base64Encode("bbb");
        System.out.println(encode);
    }

    private static int change(int i) {
        if (i >= 3 && i <= 6) {
            return 9 - i;
        } else {
            return i;
        }
    }

    private static int back(int i) {
        if (i >= 3 && i <= 6) {
            return 9 - i;
        } else {
            return i;
        }
    }

    //      3 4 5 6 2 1
//
//      6 5 4 3 2 1
    @Test
    public void testInt() {
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
    public void stringFormat() {
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
    public void testIP() {
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
    public void testBigDecimal() {
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
    public void testRegular() {
        String ip = "2001:1b70:200:1000::164";
        String ipv4 = "192.168.0.1";
        String pattern = "^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}$";
        String pattern2 = "^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}$";
        String pattern3 = "^\\s*((([0-9A-Fa-f]{1,4}:){7}([0-9A-Fa-f]{1,4}|:))|(([0-9A-Fa-f]{1,4}:){6}(:[0-9A-Fa-f]{1,4}|((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){5}(((:[0-9A-Fa-f]{1,4}){1,2})|:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){4}(((:[0-9A-Fa-f]{1,4}){1,3})|((:[0-9A-Fa-f]{1,4})?:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){3}(((:[0-9A-Fa-f]{1,4}){1,4})|((:[0-9A-Fa-f]{1,4}){0,2}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){2}(((:[0-9A-Fa-f]{1,4}){1,5})|((:[0-9A-Fa-f]{1,4}){0,3}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){1}(((:[0-9A-Fa-f]{1,4}){1,6})|((:[0-9A-Fa-f]{1,4}){0,4}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(:(((:[0-9A-Fa-f]{1,4}){1,7})|((:[0-9A-Fa-f]{1,4}){0,5}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:)))(%.+)?\\s*$";
        String pattern4 = "([a-f0-9]{1,4}(:[a-f0-9]{1,4}){7}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){0,7}::[a-f0-9]{0,4}(:[a-f0-9]{1,4}){0,7})";
        String pattern5 = ".*[a-fA-F].*";
        boolean matches = ip.matches(pattern5);
        System.out.println(matches);
        boolean matches1 = ipv4.matches(pattern5);
        System.out.println(matches1);
    }

    @Test
    public void testHost() {
        String address = "linux-tot-49.tot";
        String memberAddress = "linux-tot-49";
        if (memberAddress != null && !"".equals(memberAddress)) {
            if (address.contains(memberAddress) || memberAddress.contains(address)) {
                System.out.println(address);
            }
        }
    }

    @Test
    public void testBoolean() {
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
        if (!ipv4.matches(".*[a-fA-F].*")) {
            System.out.println(ipv4 + " is IPv4.");
        }
        if (ipv6.matches(".*[a-fA-f].*")) {
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
    public void testPlmn() {
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
    public void testArray() {
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
    public void testRegx() {
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
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        String string = result.toString(StandardCharsets.UTF_8.name());
        System.out.println(string);

    }

    private static String getFormatClusterValue(String cluster) {
        if (cluster != null && cluster.contains("_")) {
            return cluster.replace("_", "-");
        }
        return cluster;
    }

    @Test
    public void testCluster() {
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
    public void testParam() {
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
        if (StringUtils.isEmpty(cluster)
                || (cluster.contains("-")
                && cluster.split("-").length != 3)
                || (cluster.contains("_")
                && cluster.split("_").length != 3)) {
            return false;
        }
        return true;
    }

    public static String getFormatIP(String ip) {
        if (ip == null || "".equals(ip)) {
            return ip;
        } else if (ip.contains(":")) {
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
    public void test10() {
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
    public void testUpdateMany() {
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
    public void testMap() {
        Map<Object, Object> kvs = new HashMap<>();
        kvs.put(null, "null");
        kvs.put("null", null);
        for (Map.Entry<Object, Object> entry : kvs.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (Objects.equals(null, key)) {
                key = "NULL";
            }
            if (Objects.equals(null, value)) {
                value = "NULL";
            }
            System.out.println(key);
            System.out.println(value);
            System.out.println("------");
        }
    }

    @Test
    public void testNull() {
        List list = new ArrayList();
        // list = null;
        //NullPointerException
        for (Object o : list) {
            System.out.println(o.toString());
        }
    }

    @Test
    public void testEnv() {
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
    public void testStatic() {
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

    public static void raiseAlarm() {
        if (!raisedDB) {
            log.info("Raise an Alarm...");
            raisedDB = true;
            clearedDB = false;
        }
    }

    public static void clearAlarm() {
        if (!clearedDB) {
            log.info("Clear an Alarm...");
            clearedDB = true;
            raisedDB = false;
        }
    }

    @Test
    public void testAlarm() {
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

    public static boolean checkByRegex(String myString, String regex) {
        Pattern p = Pattern.compile("^" + regex + "$");
        Matcher m = p.matcher(myString);
        boolean result = m.find();
        return result;
    }

    @Test
    public void testregex() {
        String regex = "((((([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]).){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]).){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))|((([0-9]|[1-8][0-9]|9[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]).){3}([0-9]|[1-8][0-9]|9[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]))):([0-9]|[1-9]\\d{1}|[1-9]\\d{2}|[1-9]\\d{3}|[1-5]\\d{4}|6[0-4]\\d{3}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-5]));)+";
        String regex2 = "(\\[(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))\\]:([0-9]|[1-8][0-9]|9[0-9]|[1-8][0-9]{2}|9[0-8][0-9]|99[0-9]|[1-8][0-9]{3}|9[0-8][0-9]{2}|99[0-8][0-9]|999[0-9]|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5])|((([0-9]|[1-8][0-9]|9[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-8][0-9]|9[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])):([0-9]|[1-8][0-9]|9[0-9]|[1-8][0-9]{2}|9[0-8][0-9]|99[0-9]|[1-8][0-9]{3}|9[0-8][0-9]{2}|99[0-8][0-9]|999[0-9]|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5]))";
        String str = "[fe80::d88e:b7ff:fe6a:d961]:22";
        boolean b = checkByRegex(str, regex2);
        System.out.println(b);
    }

    @Test
    public void testNum() {
        int a = 20;
        Integer b = 20;
        System.out.println(b.equals(a));
    }

    @Test
    public void testsubstring() {
        String str = "123456";
        String sub = str.substring(0, str.length() - 1);
        System.out.println(sub);
    }

    @Test
    public void testJson() {
        String info = "[]";
        List<Map<String, Object>> invocation = new Gson().fromJson(info, List.class);
        log.info("invocation : {}", invocation);
    }

    @Test
    public void testFuture() {
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
        for (Map.Entry<String, Map<String, Boolean>> entry : ispCache.entrySet()) {

            boolean statusOfOneTypeService = false;
            for (Map.Entry<String, Boolean> entry1 : entry.getValue().entrySet()) {
                // If any service of the same type is good, this kind of service is considered as good. For example, type oam-fds--fdsserver.
                if (entry1.getValue()) {
                    statusOfOneTypeService = true;
                    break;
                }
            }
            // If any kind of service is not good, system is considered as down
            if (!statusOfOneTypeService) {
                status = false;
                break;
            }
        }
        return status;
    }

    @Test
    public void testISP() {
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
    public void testSingleBoolen() {
        String a = null;
        String b = "";

        if (agency(a) || agency(b)) {
            log.info("Short circuit.\n");
        }
        if (agency(a) | agency(b)) {
            log.info("Both sides run.\n");
        }
    }

    private boolean agency(String string) {
        log.info("Check parameter : {}", string);
        return StringUtils.isEmpty(string);
    }

    @Test
    public void testNotNull() {
        String s = null;
        try {
            Objects.requireNonNull(s, "parameter is not null.");
        } catch (Exception e) {
            assert (e instanceof NullPointerException);
        }
        log.info("go on..."); //not come here
    }

    @Test
    public void testCompare() {
        CounterValue value1 = new CounterValue("A");
        CounterValue value2 = new CounterValue("B");
        CounterValue value3 = new CounterValue("C");
        CounterValue value4 = new CounterValue("D");
        CounterValue value5 = new CounterValue("E");

        List<CounterValue> list1 = new ArrayList<>();
        list1.add(value5);
        list1.add(value4);
        list1.add(value3);
        list1.add(value2);
        list1.add(value1);
        List<CounterValue> list2 = new ArrayList<>();
//        list2.add(value1);
//        list2.add(value2);
//        list2.add(value3);
//        list2.add(value4);
//        list2.add(value5);
        list2.add(value5);
        list2.add(value4);
        list2.add(value3);
        list2.add(value2);
        list2.add(value1);

        boolean b = compareList(list1, list2);
        System.out.println(b);
    }

    public static boolean compareList(List<CounterValue> list1, List<CounterValue> list2) {

        for (CounterValue value : list1) {
            for (CounterValue value1 : list2) {
                System.out.println(value + " compare to " + value1);
                if (null != value) {
                    if (value.equals(value1)) {
                        list2.remove(value1);
                        break;
                    } else {
                        System.out.println("*******************************************************" + list1);
                        System.out.println("*******************************************************" + list2);
                    }
                }
            }
        }
        return true;
    }

    private class CounterValue {
        private String value;

        @Override
        public String toString() {
            return value;
        }

        public CounterValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CounterValue that = (CounterValue) o;
            return Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    @Test
    public void init() {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable = () -> log.debug("OK");
        for (int i = 0; i <= 100; i++) {
//            executorService.execute(runnable);
            runnable.run();
        }
    }

//    public void test(){
//        Runnable runnable = () -> VariableService.getParameter("OAMCenter");
//
//        ExecutorService executorService = Executors.newFixedThreadPool(100);
//
//        for (int i = 0; i <= 1000*60*60; i++) {
//            executorService.execute(runnable);
//            log.debug("Get Variable Value Times : {}", i);
//        }
//
//        log.debug("Get Variable Value Times Finish!");
//    }

    @Test
    public void time() {
        long l = System.currentTimeMillis();
        System.out.println(l);
        Date date = new Date(l);
        System.out.println(date);
    }

    @Test
    public void testStatus() {
        String ssl = System.getProperty("ssl");
        System.out.println(ssl);
    }

    @Test
    public void testUrlMapping() {
        String uri = "/v1/data/18-gmpc-cluster/gmpc/network/hlrs_hsss_for_imsi";
        String mspping = "/v1/data/{cluster}/gmpc/network/hlrs_hsss_for_imsi";
        long timeMillis = System.currentTimeMillis();
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        log.debug("timeMillis : {}", timeMillis);
        log.debug("timeInMillis : {}", timeInMillis);
    }

    public class Task {
        public void doOne() {
            try {
                log.debug("Before doOne() ");
                Thread.sleep(1000);
                log.debug("After doOne() ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void doTwo() {
            try {
                log.debug("Before doTwo() ");
                Thread.sleep(2000);
                log.debug("After doTwo() ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void doThree() {
            synchronized (this) {
                try {
                    log.debug("Before doThree() ");
                    wait(3000);
                    log.debug("After doThree() ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void doFour() {
            synchronized (Task.class) {
                try {
                    log.debug("Before doFour() ");
                    wait(4000);
                    log.debug("After doFour() ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void doFive() {
            synchronized (Task.class) {
                try {
                    log.debug("Before doFour() ");
                    Thread.sleep(5000);
                    log.debug("After doFour() ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testLock() {
        Calendar now = Calendar.getInstance();
        System.out.println(now.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(now.getActualMaximum(Calendar.DAY_OF_WEEK));
        System.out.println(now.get(Calendar.WEEK_OF_MONTH));
        System.out.println(now.get(Calendar.DAY_OF_MONTH));
        System.out.println(now.get(Calendar.DAY_OF_WEEK));
        System.out.println(now.get(Calendar.MONTH));
        System.out.println(now.getTime());
        System.out.println(now.getTimeInMillis());
        now.add(Calendar.MONTH, 1);
        now.set(Calendar.DAY_OF_MONTH, 1);
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MILLISECOND, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        long time = now.getTimeInMillis();
        System.out.println(now.getTime());
        System.out.println(time);
        now.add(Calendar.MONTH, 1);
        long time2 = now.getTimeInMillis();
        System.out.println(now.getTime());
        System.out.println(time2);
        long millis = System.currentTimeMillis();
        System.out.println(millis);
    }

    private String calculateMonthAvailability(double month, double downtimeSecondSum) {
        double fullSecondsOfYear = 365.25 * 24 * 60 * 60;
        BigDecimal months = BigDecimal.valueOf(month);
        BigDecimal sumDowntime = BigDecimal.valueOf(downtimeSecondSum);
        BigDecimal fullseconds = BigDecimal.valueOf(fullSecondsOfYear);
        BigDecimal monthNum = BigDecimal.valueOf(12);

        DecimalFormat df = new DecimalFormat("0.00");
        if (sumDowntime.compareTo(BigDecimal.ZERO) == 0) {
            return df.format(100.00);
        }
        if (months.compareTo(BigDecimal.ZERO) == 0) {
            return df.format(0.00);
        }

        BigDecimal oneMonthDowntime = sumDowntime.divide(months, 6, BigDecimal.ROUND_HALF_UP);
        BigDecimal sdt = oneMonthDowntime.multiply(monthNum);
        BigDecimal min = fullseconds.subtract(sdt);
        BigDecimal aa = min.divide(fullseconds, 6, BigDecimal.ROUND_HALF_UP);

        return df.format(aa.multiply(BigDecimal.valueOf(100)).doubleValue());
    }

    private String calculateWeekAvailability(double week, double downtimeSecondSum) {
        double fullSecondsOfWeek = 24 * 60 * 60 * 7.0;
        BigDecimal weeks = BigDecimal.valueOf(week);
        BigDecimal sumDowntime = BigDecimal.valueOf(downtimeSecondSum);
        BigDecimal fullseconds = BigDecimal.valueOf(fullSecondsOfWeek);
        BigDecimal weekNum = BigDecimal.valueOf(4);

        DecimalFormat df = new DecimalFormat("0.00");

        if (sumDowntime.compareTo(BigDecimal.ZERO) == 0) {
            return df.format(100.00);
        }
        if (weeks.compareTo(BigDecimal.ZERO) == 0) {
            return df.format(0.00);
        }

        BigDecimal oneMonthDowntime = sumDowntime.divide(weeks, 6, BigDecimal.ROUND_HALF_UP);
        BigDecimal sdt = oneMonthDowntime.multiply(weekNum);
        BigDecimal min = fullseconds.subtract(sdt);
        BigDecimal aa = min.divide(fullseconds, 6, BigDecimal.ROUND_HALF_UP);

        return df.format(aa.multiply(BigDecimal.valueOf(100)).doubleValue());
    }

    @Test
    public void testAA() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));

//        Calendar now = Calendar.getInstance();
//        now.add(Calendar.MONTH, -6);
//        now.set(Calendar.DAY_OF_MONTH, 1);
//        now.set(Calendar.HOUR_OF_DAY, 0);
//        now.set(Calendar.MILLISECOND, 0);
//        now.set(Calendar.MINUTE, 0);
//        now.set(Calendar.SECOND, 0);
//        long time = now.getTimeInMillis();
//        System.out.println(time);
//        long millis = System.currentTimeMillis();
//        System.out.println(millis);
        getWeekStartDate();
    }

    public static String getFirstAndLastOfWeek(String dataStr) throws ParseException {
        Calendar cal = Calendar.getInstance();

//        cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dataStr));

        int d;
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        // 所在周开始日期
        String data1 = new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        // 所在周结束日期
        String data2 = new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());
        return data1 + "-" + data2;

    }

    public static Date getWeekStartDate() {
        Calendar cal = Calendar.getInstance();
        Date time1 = cal.getTime();
        System.out.println(time1);

        cal.set(Calendar.DAY_OF_WEEK, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        Date time = cal.getTime();
        System.out.println(time);
        cal.add(Calendar.SECOND, -1);
        Date date = cal.getTime();
        System.out.println(date);

        cal.set(Calendar.DAY_OF_WEEK, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        Date time2 = cal.getTime();
        System.out.println(time2);
        cal.add(Calendar.SECOND, -1);
        Date date2 = cal.getTime();
        System.out.println(date2);
        return date;
    }

    public enum BreakPointType {MONTHLY, WEEKLY}

    public List<Pair<Long, Long>> getBreakPoints(long oamStartTime, BreakPointType pointsType) {
        int e;
        boolean flag;
        if (pointsType.equals(BreakPointType.MONTHLY)) {
            e = 6;
            flag = true;
        } else {
            e = 4;
            flag = false;
        }
        Calendar cal = Calendar.getInstance();
        long stopTime = cal.getTimeInMillis();
        if (flag) {
            cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);
        } else {
            cal.set(Calendar.DAY_OF_WEEK, 1);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
        }
        long startTime = cal.getTimeInMillis();

        List<Pair<Long, Long>> pairList = new ArrayList<>();
        for (int i = 0; i <= e; i++) {
            if (startTime > oamStartTime) {
                Pair<Long, Long> pair = new Pair<>(startTime, stopTime);
                pairList.add(pair);
            } else {
                Pair<Long, Long> pair = new Pair<>(oamStartTime, stopTime);
                pairList.add(pair);
                break;
            }

            cal.add(Calendar.SECOND, -1);
            stopTime = cal.getTimeInMillis();
            if (flag) {
                cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);
            } else {
                cal.set(Calendar.DAY_OF_WEEK, 1);
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
            }
            startTime = cal.getTimeInMillis();
        }
        return pairList;
    }

    public Map<Integer, Map<Integer, Pair<Double, Long>>> getDowntimeTree(long startTime, long stopTime, List<DownTimeInfo> downTimeInfoList) {
        long monthDowntimeSum = downTimeInfoList.stream().filter(e ->
                e.getDownTime() >= startTime && e.getDownTime() <= stopTime)
                .mapToLong(e -> e.getRestoreTime() - e.getDownTime()).sum();
        Calendar start = Calendar.getInstance();
        start.setTime(new Date(startTime));
        Calendar stop = Calendar.getInstance();
        stop.setTime(new Date(stopTime));

        int maximum = start.getActualMaximum(Calendar.DATE);
        int dayOfMonth = stop.get(Calendar.DAY_OF_MONTH);
        double month = (double) dayOfMonth / maximum;

        Pair<Double, Long> monthAndDownTime = new Pair<>(month, monthDowntimeSum);
        int findMonth = start.get(Calendar.MONTH) + 1;
        Map<Integer, Pair<Double, Long>> monthToMonthAndDownTime = new HashMap<>();
        monthToMonthAndDownTime.put(findMonth, monthAndDownTime);
        int findYear = start.get(Calendar.YEAR);
        Map<Integer, Map<Integer, Pair<Double, Long>>> yearToMonthToMonthAndDownTime = new HashMap<>();
        yearToMonthToMonthAndDownTime.put(findYear, monthToMonthAndDownTime);
        return yearToMonthToMonthAndDownTime;
    }

    private class DownTimeInfo {
        private long downTime;
        private long restoreTime;

        public long getDownTime() {
            return downTime;
        }

        public void setDownTime(long downTime) {
            this.downTime = downTime;
        }

        public long getRestoreTime() {
            return restoreTime;
        }

        public void setRestoreTime(long restoreTime) {
            this.restoreTime = restoreTime;
        }
    }

    public static void main(String[] args) {
        String str1 = "abcdefg";
        char ch1 = str1.charAt(0);
        System.out.println("使用charAt()方法" +
                "从字符串中提取字符,结果是：" + ch1);
        int codePoint = 0;
        for (int i = 0; i < 8; i++) {
            try {
                codePoint = str1.codePointAt(i);
            } catch (StringIndexOutOfBoundsException e1) {
                System.out.println("codePointAy()所调用的索引值" + i +
                        "已经超出所要查询的字符串的长度!");
            } finally {
                try {
                    System.out.println(str1.charAt(i)
                            + "的Unicode码为" + ":" + codePoint);
                } catch (StringIndexOutOfBoundsException e2) {
                    System.out.println("charAt()所调用的索引值" + i +
                            "已经超出所要查询的字符串的长度!");
                }
            }
        }
    }

    @Test
    public void testString() {
        String string = "abc";
        // Get Unicode of char 'b'
        int i = string.codePointAt(2);
        System.out.println(i);
        int i1 = string.codePointBefore(2);
        System.out.println(i1);
        int i2 = string.hashCode();
        System.out.println(i2);
        String str1 = new String("abcd");
        String str2 = new String("abcd");
        String str3 = "abcd";
        String str4 = "abcd";
        System.out.println(str3 == str1.intern());
        System.out.println(str3 == str2.intern());
        System.out.println(str1 == str2);
        System.out.println(str3 == str4);

        double d1 = 3.14;
        double d2 = d1 * 7;
        System.out.println(d2);
        BigDecimal weekDays = BigDecimal.valueOf(21.8975893478967349);
        BigDecimal scale = weekDays.setScale(0, BigDecimal.ROUND_HALF_UP);
        System.out.println(scale);

        String format = String.format("%02d", 1);
        System.out.println(format);
    }

    public enum Color2 {

        BLUE(1, "蓝色"),
        GREEN(2, "绿色"),
        RED(0, "红色");


        private int code;
        private String desc;

        Color2(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static Color2 getValue(int code) {

            for (Color2 color : values()) {
                if (color.getCode() == code) {
                    return color;
                }
            }
            return null;

        }


        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    @Test
    public void testColor() {

//        String s = Color2.getValue(0).getDesc();
//        System.out.println("获取的值为:"+ s);
//
//        Color2 color = Color2.valueOf("GREEN");
//        System.out.println(color.getDesc());
//
//
//        Color2 s2 = Color2.getValue(0) ;
//        System.out.println("获取的值为:"+ s2.toString());
        String name = Color2.GREEN.name();
        System.out.println(name);
        String string = Color2.GREEN.toString();
        System.out.println(string);
    }

    private static String getResourceAsString(Class cls, String resource) {
        try {
            File file = ResourceUtils.getFile("classpath:com/example/testdemo/client1.json");
            System.out.println(file);
        } catch (FileNotFoundException e) {
            return null;
        }
//        InputStream is = cls.getClassLoader().getResourceAsStream(resource);
//        InputStream is = MyThread.currentThread().getContextClassLoader().getResourceAsStream(resource);
//        if (is != null) {
//            return new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
//        }
        return null;
    }

    @Test
    public void testPath() {
        String string = getResourceAsString(this.getClass(), "client1.json");
        System.out.println(string);
    }

    @Test
    public void testIngeter() {
        if (Integer.MAX_VALUE + 1 == Integer.MIN_VALUE) {
            System.out.println("Max + 1 = Min, ");
        }
    }

    @Test
    public void testByte() {
        int i = 5;
        System.out.println(i << 1);//左移
        System.out.println(i >> 1);//右移
        System.out.println(i >>> 1);//无符号右移
    }

    @Test
    public void testReflect() throws IllegalAccessException, NoSuchFieldException {
        Person person = new Person();
        Class<? extends Person> personClass = person.getClass();
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "Lyndon");
        Field age = personClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(person, 18);
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }

    public class Person {
        private String name;
        private int age;

        public Person() {
        }

        private Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        private void setAge(int age) {
            this.age = age;
        }
    }

    @Test
    public void testStackOverFlowError() {
        addStackLength(0);
    }

    private void addStackLength(int i) {
        System.out.println("Invoke times : " + i);
        i++;
        addStackLength(i);
    }

    /**
     * With -Xms20m -Xmx20m -XX:PermSize=8m -XX:MaxPermSize=8m
     */
    @Test
    public void testOutofMemoryError() {
        addNewThread(0);
    }

    private void addNewThread(int i) {
        while (true) {
            System.out.println("MyThread number : " + i);
            i++;
            new Thread(() -> {
                while (true) ;
            }).start();
        }
    }

    @Test
    public void bitOperation() {
        int a = 1100111000;
        int b = 0000111000;
        System.out.println(a & b);//如果相对应位都是1，则结果为1，否则为0

        System.out.println(a | b);//如果相对应位都是0，则结果为0，否则为1

        System.out.println(a ^ b);//如果相对应位值相同，则结果为0，否则为1

        System.out.println(~a);//按位取反运算符翻转操作数的每一位，即0变成1，1变成0。
    }

    @Test
    public void operation() {
        int i = 1 + 2 * 4;
        System.out.println(i);
    }

    @Test
    public void switchcase1() {
        int i = 5;
        //如果 case 语句块中没有 break 语句时，JVM 并不会顺序输出每一个 case 对应的返回值，而是继续匹配，匹配不成功则返回默认 case。
        switch (i) {
            case 0:
                System.out.println("0");
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            default:
                System.out.println("default");
        }
        //default
    }

    @Test
    public void switchcase2() {
        int i = 1;
        //如果 case 语句块中没有 break 语句时，匹配成功后，从当前 case 开始，后续所有 case 的值都会输出。
        switch (i) {
            case 0:
                System.out.println("0");
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            default:
                System.out.println("default");
        }
        //1
        //2
        //default
    }

    @Test
    public void switchcase3() throws InterruptedException {
        int i = 1;
        //如果当前匹配成功的 case 语句块没有 break 语句，则从当前 case 开始，后续所有 case 的值都会输出，如果后续的 case 语句块有 break 语句则会跳出判断。
        switch(i){
            case 0:
                System.out.println("0");
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3"); break;
            default:
                System.out.println("default");
        }
        //1
        //2
        //3
        Object object = new Object();
        //Object类的所有public方法
        object.toString();
        object.equals(object);
        object.hashCode();
        object.getClass();
        object.notify();
        object.notifyAll();
        object.wait();
        object.wait(1000L);
        object.wait(1000L, 1);

        Exception exception = new Exception();
    }

    @Test
    public void testIntern() {
        System.out.println("Test");
//        String a= “abc” String b = “abc” String c = new String(“abc”) String d = “ab” + “c”
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = "ab" + "c";
        System.out.println(a == b); //true
        System.out.println(a == c); //false
        System.out.println(a == d); //true
        System.out.println(b == c); //false
        System.out.println(b == d); //true
        System.out.println(c == d); //false
    }

    @Test
    public void test(){
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("1",1) ;
        map.put("2",2) ;
        map.put("3",3) ;
        map.put("4",4) ;
        map.put("5",5) ;
        System.out.println(map.toString());

    }

    @Test
    public void testJDKClass() {
        String string;
        StringBuilder stringBuilder;
        StringBuffer stringBuffer;

        Byte by;
        Short sh;
        Integer in;
        Long lo;
        Double dou;
        Float fl;
        Boolean b;
        Character ch;
        Void voidd;

        HashMap hashMap;
        Hashtable hashtable;
        ConcurrentHashMap concurrentHashMap;

        Thread thread;
        ThreadLocal threadLocal;

        Enum enumm;

        Throwable throwable;
        Error error;
        Exception exception;

        Class clazz;
        ClassLoader classLoader;

//        Unsafe unsafe;
        AtomicInteger atomicInteger;

        Compiler compiler;
        System system;
        Package packagee;

        //interface
        Collection collection;
            Set set;
            List list;
            Queue queue;

        //class
        AbstractCollection abstractCollection;
            AbstractList abstractList;
                ArrayList arrayList;
                Vector vector;
                    Stack stack;
                AbstractSequentialList abstractSequentialList;
                    LinkedList linkedList;
            AbstractSet abstractSet;
                TreeSet treeSet;
                HashSet hashSet;
                    LinkedHashSet linkedHashSet;
            AbstractQueue abstractQueue;
                PriorityQueue priorityQueue;
            ArrayDeque arrayDeque;

        // interface
        Map map;
            SortedMap sortedMap;
                NavigableMap navigableMap;

        //class
        AbstractMap abstractMap;
            HashMap hashMapp;
            TreeMap treeMap;//红黑树
            WeakHashMap weakHashMap;

        Hashtable hashtable1;
            Properties properties;

        Collections collections;
        Arrays arrays;
        Comparator comparator;
        Iterator iterator;

        Base64 base64;
        Date date;

        EventListener eventListener;
        Random random;
        Timer timer;
        UUID uuid;

        //current
        ConcurrentHashMap concurrentHashMap1;
        Executor executor;
        AbstractExecutorService abstractExecutorService;
        ThreadPoolExecutor threadPoolExecutor;
        BlockingQueue blockingQueue;
        AbstractQueuedSynchronizer abstractQueuedSynchronizer;
        CountDownLatch countDownLatch;
        FutureTask futureTask;
        Semaphore semaphore;
        CyclicBarrier cyclicBarrier;
        CopyOnWriteArrayList copyOnWriteArrayList;
        SynchronousQueue synchronousQueue;
        BlockingDeque blockingDeque;
        Callable callable;

//        Collections.sort();
//        Arrays.sort();
    }
}