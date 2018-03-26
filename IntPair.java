public class IntPair {
    int first;
    int second;

    public IntPair(int pFirst, int pSecond){
	this.first  = pFirst;
	this.second = pSecond;
    }

    @Override
    public boolean equals(Object o){
	boolean equal = false;
	if(o == this) {
	    equal = true;
	}
	if(!(equal) && (o instanceof IntPair)) {
	    IntPair p = (IntPair) o;
	    equal = first == p.first;
	}
	return equal; 
    }
}
