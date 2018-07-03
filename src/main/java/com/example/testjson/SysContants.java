package com.example.testjson;

public class SysContants {
    // /auth/users/
    public static final String COMMON_AUTH_USERS = "/auth/users/";
    // "/data/access_keys/"
    public static final String COMMON_ACCESS_KEYS = "/data/access_keys/";
    // "/data/licenses/features"
    public static final String COMMON_URL_FEATURES = "/data/licenses/features";
    // "/auth/tokens"
    public static final String COMMON_URL_TOKENS = "/auth/tokens";
    // "/auth/roles/"
    public static final String COMMON_AUTH_ROLES = "/auth/roles/";
    // "/alarm_manager/alarms/alarm_list?node="
    public static final String COMMON_ALARM_LIST_URL_OM_HOST = "/data/alarms/active_alarm_list?host_name=";
    // not host name
    public static final String COMMON_ALARM_LIST_URL_OM = "/data/alarms/active_alarm_list";
    // /alarm_manager/active_alarm_list
    public static final String COMMON_ALARM_SETTING_URL_OM = "/data/alarms/alarm_list";
    // "/value/alarm_manager/alarms/alarm_list"
    public static final String COMMON_ALARM_SETTING_URL = "/alarm_manager/alarms/alarm_list";
    // "/components"
    public static final String COMMON_COMPONENTS_SLASH = "/components";
    // "/v1/configurations/clusters/"
    public static final String COMMON_CONFIGURATIONS = "/v1/configurations/clusters/";
    // \servlet.properties win
    public static final String COMMON_SERVLET_FILE_PATH_WIN = "context-config.properties";
    // \servlet.properties linux
    public static final String COMMON_SERVLET_FILE_PATH_LINUX = "/opt/mps/webbe/conf/context-config.properties";
    // ERROR
    public static final String ERROR = "error";
    // ""
    public static final String SPACE = "";
    // ";"
    public static final String SEMICOLON = ";";
    // TLS
    public static final String RESTFUL_TLS = "TLS";
    // Content-Type
    public static final String RESTFUL_CONTENT_TYPE = "Content-Type";
    // application/json;charset=utf-8
    public static final String RESTFUL_APPLICATION_UTF = "application/json;charset=utf-8";
    // "application/json"
    public static final String RESTFUL_APPLICATION = "application/json";
    // utf-8
    public static final String RESTFUL_UTF8 = "utf-8";
    // GET POST
    public static final String OMSERVICE_GET_REPOEST = "GET";
    // DELETE
    public static final String OMSERVICE_DELETE_REPOEST = "DELETE";
    // POST
    public static final String OMSERVICE_POST_REPOEST = "POST";
    // PUT
    public static final String OMSERVICE_PUT_REPOEST = "PUT";
    // SLASH
    public static final String SLASH = "/";
    // QUESTION MARK
    public static final String QUESTION_MARK = "?";
    // STATUS
    public static final String STATUS = "status";
    // BODY
    public static final String BODY = "body";
    // CONNECTION
    public static final String CONNECTION = "Connection";
    // KEEP ALIVE
    public static final String KEEP_ALIVE = "Keep-Alive";
    // CHARSET
    public static final String CHARSET = "Charset";
    // TOKEN
    public static final String TOKEN = "X-Auth-Token";
    // ACCEPT
    public static final String ACCEPT = "accept";
    // CONTENT LENGTH
    public static final String CONTENT_LENGTH = "Content-Length";
    // SCHEMA
    public static final String SCHEMA = "schema";
    // VALUE
    public static final String VALUE = "value";
    // mps_version
    public static final String MPS_VERSION = "mps_version";
    // mps_version_value
    public static final String MPS_VERSION_VALUE  = "18";
    // false
    public static final boolean COMMON_FALSE = false;
    // false
    public static final String COMMON_FALSE_STRING = "false";
    // comma
    public static final String COMMON_COMMA = ",";
    // feature_name
    public static final String COMMON_FEATURE_NAME = "feature_name";
    // gmpc
    public static final String COMMON_GMPC = "gmpc";
    // smpc
    public static final String COMMON_SMPC = "smpc";
    // aecid
    public static final String COMMON_AECID = "aecid";
    // menuFile/gmpc_menu.json
    public static final String COMMON_GMPC_MENU_FILE = "menuFile/gmpc_menu.json";
    // menuFile/smpc_menu.json
    public static final String COMMON_SMPC_MENU_FILE = "menuFile/smpc_menu.json";
    // group
    public static final String COMMON_GROUP = "group";
    // license
    public static final String COMMON_LICENSE = "license";
    // "0"
    public static final String COMMON_ZERO = "0";
    // "1"
    public static final String COMMON_ONE = "1";
    // access_key
    public static final String COMMON_ACCESS_KEY = "access_key";
    // authority
    public static final String COMMON_AUTHORITY = "authority";
    // "\""
    public static final String COMMON_QUOTES = "\"";
    // user
    public static final String COMMON_USER = "user";
    // role
    public static final String COMMON_ROLE = "role";
    // user_name
    public static final String COMMON_USER_NAME = "user_name";
    // dev
    public static final String COMMON_DEV = "dev";
    // userId
    public static final String COMMON_USERID = "userId";
    // userName
    public static final String COMMON_USERNAME = "userName";
    // userInfo
    public static final String COMMON_USERINFO = "userInfo";
    // menuInfo
    public static final String COMMON_MENUINFO = "menuInfo";
    // remark
    public static final String COMMON_REMARK = "remark";
    // loginInfo
    public static final String COMMON_LOGININFO = "loginInfo";
    // "testFile/menuOm.json"
    public static final String COMMON_TEST_FILE_MENU_OM= "testFile/menuOm.json";
    // test get role id
    public static final String COMMON_TEST_ROLE_ID= "testFile/getRoleId.json";
    // "200"
    public static final String COMMON_TEO_HUNDRED = "200";
    // 200
    public static final int COMMON_TEO_HUNDRED_INT = 200;
    // "token"
    public static final String COMMON_TOKEN = "token";
    // "tokens"
    public static final String COMMON_TOKENS = "tokens";
    // "auth"
    public static final String COMMON_AUTH = "auth";
    // "user_id"
    public static final String COMMON_USER_ID = "user_id";
    // "testFile/getUserId.json"
    public static final String COMMON_TEST_FILE_USER_ID = "testFile/getUserId.json";
    // "authorities"
    public static final String COMMON_AUTHORITIES = "authorities";
    // ":"
    public static final String COMMON_COLON = ":";
    // ".*\\{.*"
    public static final String COMMON_BRACES = ".*\\{.*";
    // "(?<=\\{)(.+?)(?=\\})"
    public static final String COMMON_QUESTION_MARK = "(?<=\\{)(.+?)(?=\\})";
    // "cluster"
    public static final String COMMON_CLUSTER = "cluster";
    // "node"
    public static final String COMMON_NODE = "node";
    // "node_smpc"
    public static final String COMMON_NODE_SMPC = "node_smpc";
    // "node_aecid"
    public static final String COMMON_NODE_AECID = "node_aecid";
    // network_type
    public static final String COMMON_NETWORK_TTPE = "network_type";
    // "nodes"
    public static final String COMMON_NODES = "nodes";
    // "components"
    public static final String COMMON_COMPONENTS = "components";
    // Components
    public static final String COMMON_COMPONENTS_LOGIN = "Components";
    // SMPC Components"
    public static final String COMMON_SMPC_COMPONENTS = "SMPC Components";
    // AECID Components
    public static final String COMMON_AECID_COMPONENTS = "AECID Components";
    // "component"
    public static final String COMMON_COMPONENT = "component";
    // "scopes"
    public static final String COMMON_SCOPES = "scopes";
    // "parameters"
    public static final String COMMON_PARAMETERS = "parameters";
    // "parameter_id"
    public static final String COMMON_PARAMETER_ID = "parameter_id";
    // "_"
    public static final String COMMON_SLIDE_LINE = "_";
    // "LOCAL"
    public static final String COMMON_LOCAL = "LOCAL";
    // "MAPPING"
    public static final String COMMON_MAPPING = "MAPPING";
    // "data"
    public static final String COMMON_DATA = "data";
    // "validationrules"
    public static final String COMMON_VALIDATIONRULES = "validationrules";
    // "testFile/test.json"
    public static final String COMMON_TEST_FILE = "testFile/test.json";
    // "value_type"
    public static final String COMMON_VALUE_TYPE = "value_type";
    // "vList"
    public static final String COMMON_VLIST = "vList";
    // "object"
    public static final String COMMON_OBJECT = "object";
    // "items"
    public static final String COMMON_ITEMS = "items";
    // "properties"
    public static final String COMMON_PROPERTIES = "properties";
    // "."
    public static final String COMMON_SPOT = ".";
    // "id"
    public static final String COMMON_ID = "id";
    // 1070
    public static final String COMMON_FUNTURE_MENU_GMPC = "1070";
    // 1080
    public static final String COMMON_FUNTURE_MENU_SMPC = "1080";
    // "enum"
    public static final String COMMON_ENUM = "enum";
    // "\\."
    public static final String COMMON_QUOTES_SPOT = "\\.";
    // "display_name"
    public static final String COMMON_DISPLAY_NAME = "display_name";
    // "default_value"
    public static final String COMMON_DEFAULT_VALUE = "default_value";
    // "unit"
    public static final String COMMON_UNIT = "unit";
    // "brief_description"
    public static final String COMMON_BRIEF_DESCRIPTION = "brief_description";
    // "description"
    public static final String COMMON_DESCRIPTION = "description";
    // "impacts"
    public static final String COMMON_IMPACTS = "impacts";
    // "[]"
    public static final String COMMON_BRACES_DOUBLE = "[]";
    // "impact_component"
    public static final String COMMON_IMPACT_COMPONENT = "impact_component";
    // "rules"
    public static final String COMMON_RULES = "rules";
    // "values"
    public static final String COMMON_VALUES = "values";
    // "boolean"
    public static final String COMMON_BOOLEAN = "boolean";
    // password
    public static final String COMMON_PASSWORD = "password";
    // "******"
    public static final String COMMON_PASSWORD_ENCRYPTION = "******";
    // "time"
    public static final String COMMON_TIME = "time";
    // "enumtype"
    public static final String COMMON_ENUM_TYPE = "enumtype";
    // "true"
    public static final boolean COMMON_TRUE = true;
    // "true"
    public static final String COMMON_TRUE_STRING = "true";
    // "transfer_boolean"
    public static final String COMMON_TRANSFER_BOOLEAN = "transfer_boolean";
    // "string"
    public static final String COMMON_STRING = "string";
    // "text"
    public static final String COMMON_TEXT = "text";
    // "number"
    public static final String COMMON_NUMBER = "number";
    // "minimum"
    public static final String COMMON_MINIMUM = "minimum";
    // "maximum"
    public static final String COMMON_MAXIMUM = "maximum";
    // "integer"
    public static final String COMMON_INTEGER = "integer";
    // "min_size"
    public static final String COMMON_MIN_SIZE = "min_size";
    // "max_size"
    public static final String COMMON_MAN_SIZE = "max_size";
    // "min_length"
    public static final String COMMON_MIN_LENGTH = "min_length";
    // "max_length"
    public static final String COMMON_MAN_LENGTH = "max_length";
    // "simple_pattern"
    public static final String COMMON_SIMPLE_PATTERN = "simple_pattern";
    // "validation_rule"
    public static final String COMMON_VALIDATION_RULE = "validation_rule";
    // "minvalue"
    public static final String COMMON_MINVALUE = "minvalue";
    // "maxvalue"
    public static final String COMMON_MANVALUE = "maxvalue";
    // "length"
    public static final String COMMON_LENGTH = "length";
    // "enablestatus"
    public static final String COMMON_ENABLESTATUS = "enablestatus";
    // "enabled"
    public static final String COMMON_ENABLED = "enabled";
    // "displaystatus"
    public static final String COMMON_DISPLAYSTATUS = "displaystatus";
    // "READ_WRITE"
    public static final String COMMON_READ_WRITE = "READ_WRITE";
    // NO_READ
    public static final String COMMON_NO_READ = "NO_READ";
    // "read"
    public static final String COMMON_READ = "read";
    // "READ_ONLY"
    public static final String COMMON_READ_ONLY = "READ_ONLY";
    // "write"
    public static final String COMMON_WRITE = "write";
    // "YES"
    public static final String COMMON_YES = "YES";
    // "NO"
    public static final String COMMON_NO = "NO";
    // NO_LICENSE
    public static final String COMMON_NO_LICENSE = "NO_LICENSE";
    // 0
    public static final int COMMON_ZERO_INT = 0;
    // 1
    public static final int COMMON_ONE_INT = 1;
    // "X-Requested-With"
    public static final String COMMON_X_REQUESTED = "X-Requested-With";
    // "redirect:ajax/error?message="
    public static final String COMMON_REDIRECT = "redirect:ajax/error?message=";
    // "400"
    public static final String COMMON_FOUR_HANDRED = "450";
    // "408"
    public static final String COMMON_FOUR_EIGHT_HANDRED = "408";
    // "name"
    public static final String COMMON_NAME = "name";
    // "module_id"
    public static final String COMMON_MODULE_ID = "module_id";
    // "error_code"
    public static final String COMMON_ERROR_CODE = "error_code";
    // "sndfunction"
    public static final String COMMON_SEND_FUNCTION = "sndfunction";
    // runtime_configurable
    public static final String COMMON_RUNTIME_CONFIGURABLE = "runtime_configurable";
    // runtimeconfigurable
    public static final String COMMON_RUNTIMECONFIGURABLE = "runtimeconfigurable";
    // "null"
    public static final String COMMON_NULL_STR = "null";
    // Alarm List
    public static final String COMMON_ALARM_LIST = "Alarm List";
    // Alarm Setting
    public static final String COMMON_ALARM_SETTING = "Alarm Setting";
    // include_message
    public static final String COMMON_INCLUDE = "&include_message=false";
    // "%"
    public static final String COMMON_SIGN = "%";
    // active
    public static final String COMMON_ACTIVE = "active";
    // yes
    public static final String COMMON_YES_SMALL = "yes";
    // no
    public static final String COMMON_NO_SMALL = "no";
    // severity
    public static final String COMMON_SEVERITY = "severity";
    // active_description
    public static final String COMMON_ACTIVE_DESCRIPTION = "active_description";
    // activeDescription
    public static final String COMMON_ACTIVEDESCRIPTION = "activeDescription";
    // resource_id
    public static final String COMMON_RESOURCE_ID = "resource_id";
    // resourceId
    public static final String COMMON_RESOURCEID = "resourceId";
    // alarmList.json
    public static final String COMMON_ALARM_LIST_JSON = "testFile/alarmList.json";
    // alarmSetting.json
    public static final String COMMON_ALARM_SETTING_JSON = "testFile/alarmSetting.json";
    // alarm_message
    public static final String COMMON_ALARM_MESSAGE = "alarm_message";
    // "text/html"
    public static final String COMMON_TEXT_HTML = "text/html";
    // "ip_address_list"
    public static final String COMMON_IP_ADDRESS_LIST = "ip_address_list";
    // "ip_address"
    public static final String COMMON_IP_ADDRESS = "ip_address";
    // "lbis_addresses"
    public static final String COMMON_IBIS_ADDRESSES = "lbis_addresses";
    // "lbis_address"
    public static final String COMMON_IBIS_ADDRESS = "lbis_address";
    // "rss"
    public static final String COMMON_RSS = "rss";
    // "rms"
    public static final String COMMON_RMS = "rms";
    // "mts"
    public static final String COMMON_MTS = "mts";
    // "mtm"
    public static final String COMMON_MTM = "mtm";
    // "cmm"
    public static final String COMMON_CMM = "cmm";
    // "cms"
    public static final String COMMON_CMS = "cms";
    // "mum"
    public static final String COMMON_MUM = "mum";
    // "mus"
    public static final String COMMON_MUS = "mus";
    // "unk"
    public static final String COMMON_UNK = "unk";
    // "room"
    public static final String COMMON_ROOM = "room";
    // "flr"
    public static final String COMMON_FLR = "flr";
    // "loc"
    public static final String COMMON_LOC = "loc";
    // call_related_list
    public static final String COMMON_CALL_RELATED_LIST = "call_related_list";
    // dialled_by_ms
    public static final String COMMON_DIALLED_BY_MS = "dialled_by_ms";
    // session_related_list
    public static final String COMMON_SESSION_RELATED_LIST = "session_related_list";
    // oss_addresses
    public static final String COMMON_OSS_ADDRESSES = "oss_addresses";
    // oss_address
    public static final String COMMON_OSS_ADDRESS = "oss_address";
    // service_mapping_list
    public static final String COMMON_SERVICE_MAPPING_LIST = "service_mapping_list";
    // service_id_number
    public static final String COMMON_SERVICE_ID_NUMBER = "service_id_number";
    // service_type_number
    public static final String COMMON_SERVICE_TYPE_NUMBER = "service_type_number";
    // "0, off, OFF, Off, no, NO, No, false, FALSE, False, n, N, disable, DISABLE, Disable"
    public static final String COMMON_FALSE_MAP = "0, off, OFF, Off, no, NO, No, false, FALSE, False, n, N, disable, DISABLE, Disable";
    // "1, on, ON, On, yes, YES, Yes, true, TRUE, True, y, Y, enable, ENABLE, Enable"
    public static final String COMMON_TRUE_MAP = "1, on, ON, On, yes, YES, Yes, true, TRUE, True, y, Y, enable, ENABLE, Enable";
    // "prefer_async, protocol, url, poi_agreement, key, password, id"
    public static final String COMMON_OBJECT_MAP = "prefer_async, protocol, url, poi_agreement, key, password, id, low_delay, delay_tolerant, low_delay_horizontal_unspecified, delay_tolerant_horizontal_unspecified, low_delay_horizontal_range_1, delay_tolerant_horizontal_range_1, low_delay_horizontal_range_2, delay_tolerant_horizontal_range_2, low_delay_horizontal_range_3, delay_tolerant_horizontal_range_3, response_time, permit_return_accuracy_not_fulfill, shape_convert, polygon, ellipsoid_arc, ellipsoid_point, ellipsoid_point_with_uncertainty_circle, ellipsoid_point_with_uncertainty_ellipse, ellipsoid_point_with_altitude, ellipsoid_point_with_altitude_and_uncertainty_ellipsoid, horizontal_1, horizontal_2, gnss, otdoa, mbs, hybrid_avail_at_single, enable_barometric_sensor, hybrid_selected_tech";
    // "/value/*"
    public static final String COMMON_VALUE_ALL = "/value/*";
    // apn
    public static final String COMMON_APN = "apn";
    // NONE
    public static final String COMMON_NONE = "NONE";
    // ".jar"
    public static final String COMMON_JAR = ".jar";
    // "file"
    public static final String COMMON_FILE = "file";
    // "WBE"
    public static final String COMMON_WBE = "WBE";
    // "restful om center url="
    public static final String COMMON_OMCENTER_URL = "restful.oamcenter.url";
    // "os.name"
    public static final String COMMON_OS_NAME = "os.name";
    // "win"
    public static final String COMMON_OS_WINDOWS = "win";
    // "dev1"
    public static final String COMMON_TEST_DEV_ONE = "dev1";
    // "dev2"
    public static final String COMMON_TEST_DEV_TWO = "dev2";
    //
    public static final String COMMON_SPACE_OR_SPACE = " or ";
    // "70101"
    public static final String COMMON_REFERENCE_MENU = "70101";

//    public static final String COMMON_SYSTEM_ADMIN = "System Administrator";
    public static final String COMMON_SYSTEM_ADMIN = "system_admin";

//    public static final String COMMON_ACCOUNT_ADMIN = "Account Administrator";
    public static final String COMMON_ACCOUNT_ADMIN = "account_admin";

//    public static final String COMMON_STATISTICS_ADMIN = "Statistics Administrator";
    public static final String COMMON_STATISTICS_ADMIN = "statistics_admin";

//    public static final String COMMON_SMPC_CELL_DATA_ADMIN = "SMPC Cell Data Admin";
    public static final String COMMON_SMPC_CELL_DATA_ADMIN = "smpc_celldata_admin";

    public static final String COMMON_USER_MANAGEMENT = "User Management";

    public static final String COMMON_SYSTEM_RECORDS = "System Records";

    public static final String COMMON_STATISTICS = "Statistics";

    public static final String COMMON_DATA_MANAGEMENT = "Data Management";

    public static final String COMMON_CELL_DATA = "Cell Data";


}
