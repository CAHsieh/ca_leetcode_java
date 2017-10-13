// Please implement the serializer and deserializer for char array below.
// For char arrays, we follow the JSON standard according to http://www.json.org/
// Therefore, a single character A is represented as "A" (wrapped in double quotes instead of single quotes).
// A char array containing 3 elements "A", "B", "C" is represented in string as ["A","B","C"].
// For the purpose of this problem, you must not use JSON parser library or eval method. 
// Standard library provided by the language (not including JSON library) is allowed.

class Main {
    public static String charArrayToString(char[] param) throws Exception {
        if(param == null) return "[]";
        StringBuilder builder = new StringBuilder("[");
        boolean notOne = false;
        for(char a : param){
            if(notOne){
                builder.append(",");
            }else notOne = true;

            switch(a){
                case '\t':
                builder.append("\"\\t\"");
                break;
                case '\b':
                builder.append("\"\\b\"");
                break;
                case '\n':
                builder.append("\"\\n\"");
                break;
                case '\r':
                builder.append("\"\\r\"");
                break;
                case '\f':
                builder.append("\"\\f\"");
                break;
                case '\'':
                builder.append("\"'\"");
                break;
                case '\"':
                builder.append("\"\\\"\"");
                break;
                case '\\':
                builder.append("\"\\\\\"");
                break;
                default:
                builder.append("\"").append(a).append("\"");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    // Bonus point if your deserializer is able to deal with whitespaces between elements.
    // For example: param = "[  \"a\",  \"b\", \"c\"  ]"
    public static char[] stringToCharArray(String param) throws Exception {
        if(!param.contains("\"")) return null;
        String[] splitString = param.contains(",")?param.split(","):new String[]{param};
        char[] character = new char[splitString.length];
        for(int i=0; i<splitString.length; i++){
            String sub = splitString[i].substring(splitString[i].indexOf("\"")+1,splitString[i].lastIndexOf("\""));
            if (sub.charAt(0) != '\\') {
                character[i] = sub.charAt(0);    
            }else{
                switch(sub.charAt(1)){
                    case 't':
                    character[i] ='\t';
                    break;
                    case 'b':
                    character[i] ='\b';
                    break;
                    case 'n':
                    character[i] ='\n';
                    break;
                    case 'r':
                    character[i] ='\r';
                    break;
                    case 'f':
                    character[i] ='\f';
                    break;
                    case '\'':
                    character[i] ='\'';
                    break;
                    case '\"':
                    character[i] ='\"';
                    break;
                    case '\\':
                    character[i] ='\\';
                    break;
                }
            }
        }
        return character;
    }

    // Note: These tests are basic and passing them does not mean your code is correct.
    // Feel free to write additional tests and test serializer and deserializer individually.
    public static void main(String[] args) {
        String[] testcases = {
            "[]",
            "[\"a\",\"b\",\"c\"]",
            "[\"T\",\"e\",\"!\",\"'\"]",
            "[\"'\",\"\\\"\",\"c\"]",
            "[\"\\n\",\"\\t\",\"'\",\"\\\"\",\"\\\\\"]"
        };

        for(String testcase : testcases) {
            try {
                if (!charArrayToString(stringToCharArray(testcase)).equals(testcase)) {
                    System.out.println("TESTCASE FAILED : {}" + testcase);
                } else {
                    System.out.println("TESTCASE PASSED");
                }
            } catch(Exception e) {
                System.out.println("Exception occured in testcase : " + testcase);
                break;
            }
        }
    }
}
