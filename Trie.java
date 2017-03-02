
public class Trie {
	private CharArray root;
	
	public void insert(String data){
		if(data != null){
			if(root == null){
				root = new CharArray();
			}
			root.insert(data);
		}
	}
	
	public void displayTrie(){
		if(root != null){
			root.printTrie();
		}
	}
}
