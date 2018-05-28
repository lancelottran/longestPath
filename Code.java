int longestPath(String fileSystem) {
    
    String[] path = fileSystem.split("\f");
    List<String> nav = new ArrayList<String>();
    Stack<String> stack = new Stack<String>();
    int prev = 0, res = 0, cur = 0;
    
    for(String line : path){
        int level = line.lastIndexOf("\t") + 2;
        System.out.println(line + " " + level);
        line = line.replace("\t", "");
        
        if(level <= prev){
            while(!(level > prev)){
                cur = cur - stack.pop().length();
                prev--;
            }
        }
        
        if(level > prev)
        {   
            cur = cur + line.length();
            stack.push(line);
        }
        
        if(line.contains("."))
        {
            res = Math.max(cur + level - 1, res);
        }
        
        prev = level;
    }
    
    return res;   
}
