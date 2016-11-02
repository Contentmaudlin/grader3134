/* test case with unbalance of comment */
public static List<Integer> compute(List<Integer> L1, List<Integer> L2){
	
	for (Integer L1Item : L1){
		while (L1Item.compareTo(temp) > 0 && Iterator2.hasNext()){
			temp = Iterator2.next();
		}
		if(L1Item.compareTo(temp) > 0 && !Iterator2.hasNext()){
			return result;
		}
		if(L1Item == temp){
			result.add(L1Item);
			continue;
		}else {  // element in 2 bigger
			continue;
		}
		/* this is the error */ */
	}
	return result;
}