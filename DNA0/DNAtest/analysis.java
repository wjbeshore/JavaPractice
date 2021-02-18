
/**
 * Write a description of analysis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class analysis {
    public String findSimpleGene(String dna){
        int start = dna.indexOf("ATG");
        if(start == -1){
            return "";
        }
        int end = dna.indexOf("TAA");
        if(end == -1){
            return "";
        }
        if((start - end)%3 == 0){
            return dna.substring(start, end+3);
        } else {
            return "";
        }
    }
    
    
    
    public void testSimpleGene(){
        String a = "atgcctag";
        System.out.println(findSimpleGene(a));
	String ap = "";
	System.out.println(findSimpleGene(ap));
	a = "ATGCCCTAGTAA";
	System.out.println(findSimpleGene(a));
	ap = "ATGCCCTAGTCATAA";
	System.out.println(findSimpleGene(ap));
     
    }
        
}
