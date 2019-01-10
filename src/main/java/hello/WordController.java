package hello;

import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map.Entry;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
    // TODO Implement the /words/{word} endpoint
    
    @RequestMapping(value="/words/{word}",method=RequestMethod.GET)
	public ResultVO  display(@PathVariable("word") String word) {
		ResultVO resultVO =new ResultVO();
		resultVO.setWord(word);
		resultVO.setIspalindrome(this.isPanllindrome(word));
		resultVO.setAnagramOfPalindrome(this.isAnagram(word));
		return resultVO;
	}




public boolean isPanllindrome(String word) {
	String reverseString="";
	for(int i=(word.length()-1);i>=0;i--) {
		reverseString+=word.charAt(i);
	}
	if(reverseString.equals(word)){
		return true;
	}else {
		return false;
	}
}


public boolean isAnagram(String word) {
	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	for (int i = 0; i < word.length(); i++) {
		if(map.containsKey(word.charAt(i))) {
			Integer count = map.get(word.charAt(i));
			map.put(word.charAt(i),count+1);
		}else{
			map.put(word.charAt(i), 1);
		}
	}
	int oddCounter=0 ,evenCounter=0;
	
	if(word.length() % 2 == 0) {
		
		for(Entry<Character,Integer>entry :map.entrySet()) {
			if(entry.getValue()%2==0) {
				evenCounter++;
			}
		}
		if(evenCounter == map.size()) {
			return true;	
		}
	}else {
		for(Entry<Character,Integer>entry:map.entrySet()) {
			if(entry.getValue()%2==1) {
				oddCounter++;
			}else if(entry.getValue()%2==0) {
				evenCounter++;
			}				
		}	
		if(oddCounter==1 && evenCounter== map.size()-1) {
			return true;
		}
	}
	return false;
		
}
}


class ResultVO {

	public String word;
	public boolean ispalindrome;
	public boolean anagramOfPalindrome;
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public boolean isIspalindrome() {
		return ispalindrome;
	}
	public void setIspalindrome(boolean ispalindrome) {
		this.ispalindrome = ispalindrome;
	}
	public boolean isAnagramOfPalindrome() {
		return anagramOfPalindrome;
	}
	public void setAnagramOfPalindrome(boolean anagramOfPalindrome) {
		this.anagramOfPalindrome = anagramOfPalindrome;
	}
}
