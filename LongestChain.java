/*
 * Complete the function below.
 */

    static int longest_chain(String[] w) {
        // the max depth that we've found
        int maxDepth = 0;
        
        // convert the array of words to a set for convenience later on
        Set<String> wordSet = new HashSet<String>();
        for(String word : w) {
            wordSet.add(word);
        }
        
        // initialize the cache
        Map<String, Integer> cache = new HashMap<String, Integer>();
        
        // for each word, use the helper function to find the max depth; if it's greater than the current max, then set the max to that depth
        for (String word : w) {
            int depth = longestChainForWord(wordSet, word, cache);
            if(depth > maxDepth) {
                maxDepth = depth;
            }
        }
        
        return maxDepth;
    }


    static int longestChainForWord(Set<String> words, String word, Map<String, Integer> cache) {
        // check the cache to see if it contains this word
        if(cache.keySet().contains(word)) {
            return cache.get(word);
        }
        
        int maxDepth = 0;
        
        // if not, remove one character at a time and if it's a valid word, call the helper function
        for (int i = 0; i < word.length(); i++) {
            String without = word.substring(0, i) + word.substring(i+1, word.length());
            if(words.contains(without)) {
                int depth = longestChainForWord(words, without, cache);
                
                // if the depth is greater than the max we've found, set the max to this depth
                if (depth > maxDepth) {
                    maxDepth = depth;
                }
            }
        }
        
        // add 1 to the depth because the current call we're in counts as a valid word
        cache.put(word, maxDepth + 1);
        return maxDepth + 1;
    }

