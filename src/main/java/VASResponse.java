
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author MaiHuyCanh
 * @Date 23-11-2019
 *
 *       VASResponse.java
 */
public class VASResponse {
    private String status = null;
    private String statusMessage = null;
    private Map<String, String> parameter = null;
    private String response = null;

    /**
     * @param response
     */
    public VASResponse(String response) {
        this.response = response;
    }

    /**
     * @return the parameter
     */
    public Map<String, String> getParameter() {
        if (this.parameter == null) {
            this.parameter = extractParameters(this.response);
        }
        return parameter;
    }

    private String extractValue(String key) {
        String tag = "<" + key + ">";
        if (response.indexOf(tag) > 0) {
            String tagEnd = "</" + key + ">";
            return response.substring(response.indexOf(tag) + tag.length(), response.indexOf(tagEnd));
        } else {

            String regex = "<*:" + key + ">";
            Pattern pattern = Pattern.compile(regex);
            Matcher m = pattern.matcher(response);
            if (m.find()) {
                int start = m.end();
                m.find();
                int end = m.start();
                String a = response.substring(start, end);
                return a.substring(0, a.lastIndexOf("<"));
            }
        }
        return null;
    }

    public Map<String, String> extractParameters(String content) {
        // check exist Parameters in the response
        if (content.indexOf("Parameters") > 0) {
            Map<String, String> map = new HashMap<String, String>();

            // get value of namespace
            String namespace = null;
            String regex = "<*:Parameters";
            Pattern pattern = Pattern.compile(regex);
            Matcher m = pattern.matcher(content);
            if (m.find()) {
                int start = m.start();
                String beforeStart = content.substring(0, start);
                namespace = content.substring(beforeStart.lastIndexOf("<") + 1, start + 1);
            } else
                return null;
            String contentParams = content.substring(content.indexOf("<" + namespace + "Parameters>") + ("<" + namespace + "Parameters>").length(), content.indexOf("</" + namespace + "Parameters>"));
            regex = "<" + namespace + "Parameter>";
            pattern = Pattern.compile(regex);
            m = pattern.matcher(contentParams);
            while (m.find()) {
                int start = m.start();
                String nameAndValue = contentParams.substring(start, contentParams.indexOf("</" + namespace + "Parameter>", start));
                String name = "";
                if (nameAndValue.indexOf("<name>") > -1) {
                    name = nameAndValue.substring(nameAndValue.indexOf("<name>") + ("<name>").length(), nameAndValue.indexOf("</name>"));
                } else
                    name = nameAndValue.substring(nameAndValue.indexOf("<" + namespace + "name>") + ("<" + namespace + "name>").length(), nameAndValue.indexOf("</" + namespace + "name>"));
                if (nameAndValue.indexOf("<" + namespace + "value/>") > 0) {
                    map.put(name, "");
                } else {
                    String value = "";
                    if (nameAndValue.indexOf("<value>") > -1) {
                        value = nameAndValue.substring(nameAndValue.indexOf("<value>") + ("<value>").length(), nameAndValue.indexOf("</value>"));
                    } else
                        value = nameAndValue.substring(nameAndValue.indexOf("<" + namespace + "value>") + ("<" + namespace + "value>").length(), nameAndValue.indexOf("</" + namespace + "value>"));
                    map.put(name, value);
                }
            }
            return map;
        }
        return null;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        if (this.status == null) {
            this.status = extractValue("STATUS");
        }
        return status;
    }

    public String getSubId() {
        Map<String, String> paramerters = extractParameters(response);
        return paramerters == null ? null : paramerters.get("SUB_ID") ;
    }

    /**
     * @return the statusMessage
     */
    public String getStatusMessage() {
        if (this.statusMessage == null) {
            this.statusMessage = extractValue("STATUS_MESSAGE");
        }
        return statusMessage;
    }
    public static void main(String[] args) {
        String response = "ssssssssssssssss";
        // System.out.println(getValue(response, "STATUS"));
        // System.out.println(getValue(response, "STATUS_MESSAGE"));
        @SuppressWarnings("unused")
        VASResponse va = new VASResponse(response);
        System.out.println(va);
        System.out.println(va.getParameter());
        //System.out.println(va.getStatus());
//        System.out.println(cacheValue);
       System.out.println(va.getMsisdn());
    }

    public String getMsisdn() {
        String cacheValue = extractValue("CacheValue");
        Map<String, String> mapParameters = extractParameters(cacheValue);

        return mapParameters.get("MSISDN");
    }

    public String getSubId2() {
        String cacheValue = extractValue("CacheValue");
        Map<String, String> mapParameters = extractParameters(cacheValue);

        return mapParameters.get("SUB_ID");
    }
}
