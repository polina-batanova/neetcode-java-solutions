class Solution {

    String spr = UUID.randomUUID().toString();

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s).append(spr);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) {
            return new ArrayList<>();
        }
        return Arrays.asList(str.split(Pattern.quote(spr), -1)).subList(0, str.split(Pattern.quote(spr), -1).length - 1);
    }
}