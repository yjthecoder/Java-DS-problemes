package jiuzhang.java.elementary;

public class StrStrSolution {

    public int strStr(String source, String target) {
        // write your code here
        if (source == null || target == null || source.length() < target.length()){
            return -1;
        }
        
        if (target.equals("")){
        	return 0;
        }
	    for (int i = 0; i < source.length(); i++){
			if (source.charAt(i) == target.charAt(0)){
			    if (source.length() - i < target.length()){
                    return -1;
				}
			    int k = 0;
			    for (k = 1; k < target.length(); k++) {
				    if (target.charAt(k) != source.charAt(i + k)) {
					    break; //bug here, the first round fail does mean not cannot find the target
				    }
				}
				if (k == target.length()){
				    return i;
				}
		    }
	    }
		
	    return -1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = ""; 
		if(test.equals("")){
			System.out.println(test.charAt(0));
		}
		
		System.out.println(new StrStrSolution().strStr("source", "target"));
		System.out.println(new StrStrSolution().strStr("", ""));
		System.out.println(new StrStrSolution().strStr("abcdabcdefg", "bcd"));

		
	}

}
