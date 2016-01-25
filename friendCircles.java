/*
 * Complete the function below.
 */

    static int friendCircles(String[] friends) {            
        // if friends is null, return 0
        if(friends == null) {
            return 0;
        }
        
        // the number of unique groups we've found
        int uniqueGroups = 0;

        // an array to keep track of whether or not each student has yet been visited
        boolean[] visited = new boolean[friends.length];
        
        // visit all students of one group then move on to the next group
        for(int i = 0; i < friends.length; i++) {
            // if this student has already been visited, skip it
            if(!visited[i]) {
                uniqueGroups++;
                visited[i] = true;
                findCircle(friends, i, visited);
            }
        }
        
        // return the number of unique groups
        return uniqueGroups;
    }

    static void findCircle(String[] friends, int index, boolean[] visited) {
        String preference = friends[index];
        for(int i = 0; i < preference.length(); i++) {
            // for each student that the student referred to by index is friends with, mark it as visited and find all that student's friends
            if(preference.charAt(i) == 'Y' && !visited[i] && i != index) { 
                visited[i] = true;
                findCircle(friends, i, visited);
            }
        }
    }

