
import java.util.ArrayList;

import java.util.Scanner;

 

class vote{

    static String[] name;

    

    public static void main(String[] args) {
    	
    	
                Scanner sc = new Scanner(System.in);
			

			    int numberOfCandidate= sc.nextInt(); //후보자 수 입력
   

			    ArrayList<Integer>[] vote = new ArrayList[1000]; //선거권자 들의 투표내용저장 리스트 생성
			    ArrayList<Integer>[] list = new ArrayList[numberOfCandidate]; // 후보자 리스트 생성 int타입만 사용가능, 용량한정

			    

			    int CountAll = 0;

			    
			    for(int k = 0; k < numberOfCandidate; k++){

			        list[k] = new ArrayList<Integer>();

			    }
			    
			    //후보자들이 입력될 리스트 생성 문자열 타입만 사용가능, 용량한정
			    String[] plist = new String[numberOfCandidate]; 

			    sc.nextLine(); //입력 스트림에 남겨져 있었던 글자를 읽어들이고 빈 줄을 반환

			    // 앞서 입력했던 후보자 수 만큼 후보자명이 입력될때까지 후보자 입력
			    for(int k = 0; k < numberOfCandidate; k++){

			        plist[k] = sc.nextLine();

			    }

			    //vote 리스트에 후보자 저장
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

			    // 투표 Process
			    while(true){

			        for(int k = 0; k < numberOfCandidate; k++){
			        	//// 가장많은 표를 얻은 후보자의 득표가 과반수 이상이라면 해당 리스트에 저장된 이름 리턴
			            if(plist[k].isEmpty())

			                continue;

			            int a = list[k].size();

			            if(a > CountAll/2){

			                Selected = k;

			                break;

			            }
			            
			            //그렇지 않으면 제일 적은 표를 얻은 후보자를 찾아서 삭제
			            else if(low.isEmpty() || a < list[low.get(0)].size()){

			                low.clear();

			                low.add(k);

			            }

			            else if(a == list[low.get(0)].size()){

			                low.add(k);

			            }

			        }

			        
			        
			        //최하 표와 최고표가 동일 하다면 더이상 집계할 수 없으므로 종료
			        if(Selected != -1 || low.size() == mod)

			            break;

			        
			        // 탈락되지 않은 후보가운데 가장 높은선호도를 얻은후보가 삭제된 표를 얻는다.
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
			    // 투표 process 종료
			    
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