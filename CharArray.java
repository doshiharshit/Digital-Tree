
import java.util.Arrays;

public class CharArray {
	private Character data;
	private CharArray[] charList;
	private int size = 0;
	private Boolean leaf = false;
	
	public void insert(String wordIn){
		if(wordIn != null){
			if(charList != null){
				for(CharArray singleChar : charList){
					if(singleChar.data.equals(wordIn.charAt(0))){
						if(wordIn.length() > 1){
							singleChar.insert(wordIn.substring(1));
							return;
						}else{
							singleChar.leaf = true;
							return;
						}
					}
				}
				CharArray[] newCharList = Arrays.copyOf(charList, ++size);
				newCharList[size-1] = new CharArray();
				newCharList[size-1].data = wordIn.charAt(0);
				if(wordIn.length() > 1){
					newCharList[size-1].insert(wordIn.substring(1));
				}else{
					newCharList[size-1].leaf = true;
				}
				charList = null;
				charList = newCharList;
			}else{
				charList = new CharArray[++size];
				charList[0] = new CharArray();
				charList[0].data = wordIn.charAt(0);
				if(wordIn.length() > 1){
					charList[0].insert(wordIn.substring(1));
				}else{
					charList[0].leaf = true;
				}
			}
		}
	}
	
	public void printTrie(){
		if(data != null){
			System.out.print(data + " ");
			if(leaf){
				System.out.println("LEAF ");
			}
		}
		if(charList != null){
			for(CharArray singleChar : charList){
				singleChar.printTrie();
			}
		}
	}
}
