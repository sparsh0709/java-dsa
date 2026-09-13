127.Word Ladder
https://leetcode.com/problems/word-ladder/description/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        queue.offer(null);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            String word = queue.poll();


            if (word == null) {

                level++;

                if (!queue.isEmpty()) {
                    queue.offer(null);
                }

                continue;
            }


            if (word.equals(endWord)) {
                return level;
            }

            for (int i = 0; i < word.length(); i++) {

                char[] chars = word.toCharArray();

                for (char c = 'a'; c <= 'z'; c++) {

                    chars[i] = c;

                    String nextWord = new String(chars);

                    if (wordSet.contains(nextWord)
                            && !visited.contains(nextWord)) {

                        visited.add(nextWord);
                        queue.offer(nextWord);
                    }
                }
            }
        }

        return 0;
    }
}
