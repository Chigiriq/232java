
public class Word implements Comparable<Word>{
	
	String text;
	int editDist;
	
	public Word(String t, int e) {
		this.text = t;
		this.editDist = e;
	}
	
	public String getText() {
		return this.text;
	}
	
	public int getDist() {
		return this.editDist;
	}

	public void setDist(int n) {
		this.editDist = n;
	}
	
	@Override
	public int compareTo(Word o) {
		return Integer.compare(this.editDist, o.editDist);
	}
	
	
}
