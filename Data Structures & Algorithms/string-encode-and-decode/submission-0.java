class Solution {
    public String encode(List<String> strs) {
        // word-size + | + word
        StringBuilder encoded = new StringBuilder();
        for (String str: strs) {
            encoded.append(str.length());
            encoded.append('|');
            encoded.append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        StringBuilder sb = new StringBuilder();
        List<String> decoded = new ArrayList<>();
        for (int i=0; i<str.length();) {
            // get word size
            sb.setLength(0);
            for (;str.charAt(i) != '|'; i++) {
                sb.append(str.charAt(i));
            }
            int size = Integer.parseInt(sb.toString());
            i++;
            sb.setLength(0);

            int j;
            for (j=i; (j<(i+size)) && (j<str.length()); j++) {
                sb.append(str.charAt(j));
            }
            i = j;
            decoded.add(sb.toString());
        }

        return decoded;
    }
}
