public class TestBC_Teacher{
	public static void main(String args[]){
		
		b_label:{
			c_label:
			for(int j=0 ; j<5  ; j++)
			{
				for(int i=0 ; i<10 ; i++){
					if(i==7){
						//continue;
						//break;
						continue c_label;
						//break b_label;
						}
					System.out.println("i="+i+" "+"j="+j+" ");
				}
				System.out.println("j="+j+" ");
			}
		}
	}
}