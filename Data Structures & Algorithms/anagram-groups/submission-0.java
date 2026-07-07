class Solution {
    public String getHash(String str) {
        int[] freq = new int[26];
        for (char ch: str.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<26; i++) {
            if (freq[i] > 0) {
                sb.append((char) (i + 'a'));
                sb.append(freq[i]);
            }
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (String str: strs) {
            String code = getHash(str);
            List<String> list;
            if (map.containsKey(code)) {
                list = map.get(code);
            } else {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(code, list);
        }

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}
