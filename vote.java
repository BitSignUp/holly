
import java.util.ArrayList;

import java.util.Scanner;

 

class vote{

    static String[] name;

    

    public static void main(String[] args) {
    	
    	
                Scanner sc = new Scanner(System.in);
			

			    int numberOfCandidate= sc.nextInt(); //�ĺ��� �� �Է�
   

			    ArrayList<Integer>[] vote = new ArrayList[1000]; //���ű��� ���� ��ǥ�������� ����Ʈ ����
			    ArrayList<Integer>[] list = new ArrayList[numberOfCandidate]; // �ĺ��� ����Ʈ ���� intŸ�Ը� ��밡��, �뷮����

			    

			    int CountAll = 0;

			    
			    for(int k = 0; k < numberOfCandidate; k++){

			        list[k] = new ArrayList<Integer>();

			    }
			    
			    //�ĺ��ڵ��� �Էµ� ����Ʈ ���� ���ڿ� Ÿ�Ը� ��밡��, �뷮����
			    String[] plist = new String[numberOfCandidate]; 

			    sc.nextLine(); //�Է� ��Ʈ���� ������ �־��� ���ڸ� �о���̰� �� ���� ��ȯ

			    // �ռ� �Է��ߴ� �ĺ��� �� ��ŭ �ĺ��ڸ��� �Էµɶ����� �ĺ��� �Է�
			    for(int k = 0; k < numberOfCandidate; k++){

			        plist[k] = sc.nextLine();

			    }

			    //vote ����Ʈ�� �ĺ��� ����
			    while(true){

			        String input = sc.nextLine();

			        if(input.isEmpty()){

			            sc.nextLine();

			            break;

			        }

			        Scanner scc = new Scanner(input);

			        vote[CountAll] = new ArrayList<Integer>();

			        int temp = scc.nextInt()-1;

			        list[temp].add(CountAll);

			        vote[CountAll].add(temp);

			        while(scc.hasNext()){

			            temp = scc.nextInt()-1;;

			            vote[CountAll].add(temp);

			        }

			        CountAll++;

			    }

			    
			    
			    int Selected = -1;

			    int mod = numberOfCandidate;

			    ArrayList<Integer> low = new ArrayList<Integer>();

			    // ��ǥ Process
			    while(true){

			        for(int k = 0; k < numberOfCandidate; k++){
			        	//// ���帹�� ǥ�� ���� �ĺ����� ��ǥ�� ���ݼ� �̻��̶�� �ش� ����Ʈ�� ����� �̸� ����
			            if(plist[k].isEmpty())

			                continue;

			            int a = list[k].size();

			            if(a > CountAll/2){

			                Selected = k;

			                break;

			            }
			            
			            //�׷��� ������ ���� ���� ǥ�� ���� �ĺ��ڸ� ã�Ƽ� ����
			            else if(low.isEmpty() || a < list[low.get(0)].size()){

			                low.clear();

			                low.add(k);

			            }

			            else if(a == list[low.get(0)].size()){

			                low.add(k);

			            }

			        }

			        
			        
			        //���� ǥ�� �ְ�ǥ�� ���� �ϴٸ� ���̻� ������ �� �����Ƿ� ����
			        if(Selected != -1 || low.size() == mod)

			            break;

			        
			        // Ż������ ���� �ĺ���� ���� ������ȣ���� �����ĺ��� ������ ǥ�� ��´�.
			        for(int k : low){

			            for(int y = 0; y < list[k].size(); y++){

			                int cityzen = list[k].get(y);

			                vote[cityzen].remove(0); 

			                while(plist[vote[cityzen].get(0)].isEmpty()){

			                    vote[cityzen].remove(0);

			                }

			                list[vote[cityzen].get(0)].add(cityzen);

			            }

			            plist[k] = "";

			            list[k].clear();

			            mod--;

			        }

			        low.clear();

			    }
			    // ��ǥ process ����
			    
			      if(Selected != -1){

			        System.out.println(plist[Selected]);

			    }
			    
			    else{

			        for(int k : low){

			            System.out.println(plist[k]);

			        }

			    }
		
			      
			
		
    }

    

}