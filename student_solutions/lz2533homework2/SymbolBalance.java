import java.io.*;

public class SymbolBalance {
	public static void main(String args[])throws IOException{

		//input file address from keyboard
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String str;
		System.out.println("please enter the file address:");
		str = br1.readLine();
	    br1.close();
		BufferedReader br2 = new BufferedReader(new FileReader(str));

		int LINE=0;
		String line;
		MyStack<Character> S = new MyStack<Character>();
		MyStack<Character> S1 = new MyStack<Character>();


		//push symbols into the stack
		while((line = br2.readLine()) != null) {
			line = line.trim();
			LINE++;

			for(int i=0; i<line.length(); i++){
				char character = line.charAt(i);
				if(character=='('||character==')'||character=='['||character==']'||character=='{'||character=='}'||character=='"')
					S.push(character);

				else if(character=='/'){
					i++;
					character = line.charAt(i);
					if(character=='*'){
						S.push(character);
					}
					else if(character=='('||character==')'||character=='['||character==']'||character=='{'||character=='}'||character=='"')
						S.push(character);
			    }

				else if(character=='*'){
					i++;
					character = line.charAt(i);
					if(character=='/'){
					    S.push(character);
					}
					else if(character=='('||character==')'||character=='['||character==']'||character=='{'||character=='}'||character=='"')
						S.push(character);
			    }
			}
		}
		br2.close();



		int i=0,j=0,q=0;
		char arr1[] = new char[100];
		char arr2[] = new char[100];
		char a = '"';
		int s=S.size();
		while(S.size()>0){
			arr1[i]=S.pop();
			S1.push(arr1[i]);
			i++;
		}
		while(S1.size()>0){
			arr2[j]=S1.pop();
			j++;
		}



		//examine whether there is an Unbalanced situation
		for(int k=0; k<s;k++){


			if(arr2[k]=='*'){
				while(arr2[k]!='/'&&k<s)
					k++;
				arr2[k]='1';
				if(k==s){
					System.out.println("Unbalanced! Symbol /* is mismatched.");
					q++;
				    break;
				}
			}
			else if(arr2[k]=='/'){
					System.out.println("Unbalanced! Symbol */ is mismatched.");
					q++;
					break;
			}


			else if(arr2[k]=='"'){
				k++;
				while(arr2[k]!='"'&&k<s)
					k++;
				arr2[k]='1';
				if(k==s){
					System.out.println("Unbalanced! Symbol "+a+" is mismatched.");
					q++;
				    break;
				}
			}


			else if(arr2[k]=='('){
				int x = k;
				while(arr2[k]!=')'&&k<s){
					k++;
				    if(arr2[k]=='"'){
				    	k++;
					    while(arr2[k]!='"'&&k<s)
						k++;
					    k++;
				    }
				    else if(arr2[k]=='*'){
				    	k++;
					    while(arr2[k]!='/'&&k<s)
						k++;
					    k++;
				    }
				}
				arr2[k]='1';
				if(k==s){
					System.out.println("Unbalanced! Symbol ( is mismatched.");
					q++;
				    break;
				}
				k=x;
		    }
			else if(arr2[k]==')'){
				System.out.println("Unbalanced! Symbol ) is mismatched.");
				q++;
				break;
		    }


			else if(arr2[k]=='['){
				int x = k;
				while(arr2[k]!=']'&&k<s){
					k++;
					if(arr2[k]=='"'){
				    	k++;
					    while(arr2[k]!='"'&&k<s)
						k++;
					    k++;
				    }
				    else if(arr2[k]=='*'){
				    	k++;
					    while(arr2[k]!='/'&&k<s)
						k++;
					    k++;
				    }
				}
				arr2[k]='1';
				if(k==s){
					System.out.println("Unbalanced! Symbol [ is mismatched.");
					q++;
					break;
				}
				k=x;
		    }
			else if(arr2[k]==']'){
				System.out.println("Unbalanced! Symbol ] is mismatched.");
				q++;
				break;
		    }


			else if(arr2[k]=='{'){
				int x = k;
				while(arr2[k]!='}'&&k<s){
					k++;
					if(arr2[k]=='"'){
				    	k++;
					    while(arr2[k]!='"'&&k<s)
						k++;
					    k++;
				    }
				    else if(arr2[k]=='*'){
				    	k++;
					    while(arr2[k]!='/'&&k<s)
						k++;
					    k++;
				    }
				}
				arr2[k]='1';
				if(k==s){
					System.out.println("Unbalanced! Symbol { is mismatched.");
					q++;
					break;
				}
				k=x;
		    }
			else if(arr2[k]=='}'){
				System.out.println("Unbalanced! Symbol } is mismatched.");
				q++;
				break;
		    }

		}
		if(q==0)
			System.out.println("Balanced!");
    }
}
